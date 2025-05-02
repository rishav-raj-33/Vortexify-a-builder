<?php

namespace App\Services;

use App\Models\User;

use Illuminate\Support\Facades\Hash;

class UserService
{





    public function createUser(array $data): User
    {
        return User::create([
            'first_name' => $data['firstName'],
            'last_name' => $data['lastName'],
            'email' => $data['email'],
            'password' => Hash::make($data['password']),
            'description' => $data['message']
            

        ]);
    }


    public function deleteUser() {}
}
