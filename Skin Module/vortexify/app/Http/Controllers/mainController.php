<?php

namespace App\Http\Controllers;

use App\Services\UserService;

use Illuminate\Support\Facades\Auth;
use Illuminate\Validation\ValidationException;

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


    //Views Methods...





    public function index()
    {

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

        return view("signup");
    }


    function deploy()
    {
        // if (!Auth::check()) {
        //     return redirect('/');
        // }

        return view("deploy");
    }



    function deploymentList()
    {
        if (!Auth::check()) {
            return redirect('/');
        }

        return view("deploymentList");
    }


    function profile()
    {

        if (!Auth::check()) {
            return redirect('/');
        }
        return view("profile");
    }


    function logs()
    {

        if (!Auth::check()) {
            return redirect('/');
        }
        return view("logs");
    }
}
