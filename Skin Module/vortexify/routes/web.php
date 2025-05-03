<?php


use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PasswordResetController;
use App\Http\Controllers\mainController;






// Import the controller if it's needed

// Forgot password route
Route::get('forgot-password', [PasswordResetController::class, 'showLinkRequestForm'])->name('password.request');

// Reset password route
Route::post('forgot-password', [PasswordResetController::class, 'sendResetLinkEmail'])->name('password.email');

// Reset password form (this will be triggered after clicking the reset link)
Route::get('reset-password/{token}', [PasswordResetController::class, 'showResetForm'])->name('password.reset');

// Handle password reset
Route::post('reset-password', [PasswordResetController::class, 'reset'])->name('password.update');

Route::get('/', [mainController::class, 'index']);
Route::get('/home', [mainController::class, 'home']);
Route::get('/signup', [mainController::class, 'signup']);
Route::get('/profile', [mainController::class, 'profile']);
Route::get('/deploy', [mainController::class, 'deploy']);
Route::get('/dlist', [mainController::class, 'deploymentList']);
Route::post('/logout', [mainController::class, 'logout']);
Route::delete('/deleteUser', [mainController::class, 'deleteUser']);
Route::post('/signup', [mainController::class, 'register']);
Route::post('/session', [mainController::class, 'session']);
Route::delete('/delete', [mainController::class, 'deleteUser']);
Route::get('/api/status', [mainController::class, 'status']);
Route::post('/build', [mainController::class, 'requestDeploy']);









require __DIR__ . '/auth.php';
