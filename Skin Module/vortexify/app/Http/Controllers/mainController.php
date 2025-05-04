<?php

namespace App\Http\Controllers;

use App\Services\UserService;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Auth;
use Illuminate\Validation\ValidationException;
use Illuminate\Http\Client\ConnectionException;
use Illuminate\Support\Facades\Cache;
use Illuminate\Support\Facades\Validator;
use Illuminate\Http\Request;

class mainController extends Controller
{


    protected UserService $userService;




    public function __construct(UserService $userService)
    {
        $this->userService = $userService;
    }


    //function Methods...





    public function register()
    {



        $user = request()->validate([
            'firstName' => 'required|string|min:3|max:25',
            'lastName' => 'nullable|string|max:25',
            'email' => 'required|email|unique:users,email',
            'password' => [
                'required',
                'string',
                'min:8',
                'max:20',
                'regex:/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/'
            ],
            'message' => 'required|string|max:255',
        ]);






        $userSaved = $this->userService->createUser($user);

        Auth::login($userSaved);

        return redirect('/');
    }


    public function session()
    {
        $user = request()->validate([
            'email' => 'required|email',
            'password' => [
                'required',
                'string',
                'min:8',
                'max:20',
                'regex:/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/'
            ]
        ]);


        if (!Auth::attempt($user)) {
            throw ValidationException::withMessages([
                'email' => ['The provided credentials are incorrect.'],
            ]);
        }



        request()->session()->regenerate();
        return redirect('/home');
    }

    public function logout()
    {
        if (!Auth::check()) {
            return redirect('/');
        }


        Auth::logout();

        return redirect('/');
    }



    public function deleteUser()
    {
        if (!Auth::check()) {
            return redirect('/');
        }
        $user = Auth::user();

        Auth::logout();
        $user->delete();

        return redirect('/')->with('success', 'Account deleted successfully.');
    }



    //Brain Module Integration Views





    function deploymentList()
    {
        if (!Auth::check()) {
            return redirect('/');
        }

        try {
            $response = Http::withHeaders([
                'Authorization' => 'Bearer ' . env('BRAIN_API_KEY'),
            ])->get('http://localhost:8080/api/user/' . Auth::id());


            $data = $response->json();


            if ($response->successful()) {
                return view("deploymentList", ['data' => $data]);
            } else {
                abort(500, 'Unexpected internal error occurred.');
            }
        } catch (ConnectionException $e) {
            abort(503, 'Service temporarily unavailable.');
        }
    }



    function profile()
    {

        if (!Auth::check()) {
            return redirect('/');
        }



        try {
            $response = Http::withHeaders([
                'Authorization' => 'Bearer ' . env('BRAIN_API_KEY'),
            ])->get('http://localhost:8080/api/user/count/' . Auth::id());


            $count = $response->json();
            if ($response->successful()) {
                return view("profile", ['count' => $count]);
            } else {
                $count = "N/A";
                return view("profile", ['count' => $count]);
            }
        } catch (ConnectionException $e) {
            $count = "N/A";
            return view("profile", ['count' => $count]);
        }
    }


    //Satus API Called for polling

    public function status()
    {
        if (!Auth::check()) {
            return response('', 401);
        }


        if (!Cache::has(Auth::id())) {
            return response('', 204);
        }

        $status = Cache::get(Auth::id());

        if ($status == 'pending') {
            return response('', 202);
        } else if ($status == 'done') {
            Cache::forget(Auth::id());
            return response('', 200);
        }
    }


    //API for Deploy Request

    public function requestDeploy(Request $request)
    {


        if (!Auth::check()) {
            return response('', 401);
        }



        if (Cache::has(Auth::id())) {
            return response('', 503);
        }

        $validated = Validator::make($request->all(), [
            'git_url' => 'required|url|regex:/^https:\/\/github\.com\/[a-zA-Z0-9-]+(\/[a-zA-Z0-9-_.]+)?\/?$/',   // Regex for GitHub URL
        ]);

        



        if ($validated->fails()) {
            return response()->json([
                'message' => 'Validation failed',
                'errors' => $validated->errors()
            ], 422);
        } else {
            $validatedUrl = $validated->validated()['git_url'];

            try {
                $response = Http::withHeaders([
                    'Authorization' => 'Bearer ' . env('BRAIN_API_KEY'),

                ])->post(
                    'http://localhost:8080/api/service/deploy',
                    [
                        'url' => $validatedUrl,
                        'userId' => Auth::id(),
                    ]
                );

                Cache::put(Auth::id(), 'pending', 600);
                if ($response->successful()) {
                    Cache::put(Auth::id(), 'done', 600);
                    return response('', 200);
                } else {
                    Cache::forget(Auth::id());
                    return response('', 500);
                }
            } catch (ConnectionException $e) {
                Cache::forget(Auth::id());
                return response('', 503);
            }
        }
    }
















    //Views Methods...





    public function index()
    {
        if (Auth::check()) {
            return redirect('/home');
        }

        return view("login");
    }


    function home()
    {

        if (!Auth::check()) {
            return redirect('/');
        }

        return view("home");
    }



    function signup()
    {
        if (!Auth::check()) {
            return redirect('/home');
        }

        return view("signup");
    }



    function deploy()
    {

        if (!Auth::check()) {
            return redirect('/');
        }
        return view("deploy");
    }

    function logs()
    {

        if (!Auth::check()) {
            return redirect('/');
        }
        return view("logs");
    }
}
