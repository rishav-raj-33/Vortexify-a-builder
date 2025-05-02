<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;


use Illuminate\Support\Facades\Password;

class PasswordResetController extends Controller
{
    // Show the form to request a password reset link
    public function showLinkRequestForm()
    {
        return view('auth.forgot-password');
    }

    // Send the password reset link to the user
    public function sendResetLinkEmail(Request $request)
    {
        $request->validate([
            'email' => 'required|email',
        ]);

        $response = Password::sendResetLink(
            $request->only('email')
        );

        if ($response == Password::RESET_LINK_SENT) {
            return back()->with('status', 'We have e-mailed your password reset link!');
        } else {
            return back()->withErrors(['email' => 'We cannot find a user with that e-mail address.']);
        }
    }

    // Show the form to reset the password
    public function showResetForm(Request $request, $token = null)
    {
        return view('auth.reset-password', ['token' => $token, 'email' => $request->email]);
    }

    // Handle the password reset
    public function reset(Request $request)
    {
        $request->validate([
            'email' => 'required|email',
            'password' => 'required|confirmed|min:8',
            'token' => 'required',
        ]);

        $response = Password::reset(
            $request->only('email', 'password', 'password_confirmation', 'token'),
            function ($user, $password) {
                $user->forceFill([
                    'password' => bcrypt($password)
                ])->save();
            }
        );

        if ($response == Password::PASSWORD_RESET) {
            return redirect()->route('login')->with('status', 'Your password has been reset!');
        } else {
            return back()->withErrors(['email' => 'The provided token is invalid.']);
        }
    }
}
