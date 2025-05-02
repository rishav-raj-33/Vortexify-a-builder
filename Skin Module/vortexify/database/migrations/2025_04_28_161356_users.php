<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{

    public function up(): void
    {
        Schema::create('users', function (Blueprint $table) {

            $table->id();
            $table->string('first_name');
            $table->string('last_name')->nullable();;
            $table->string('email')->unique();
            $table->string('password');
            $table->string('description');
            $table->timestamp('created_at')->useCurrent();
            $table->rememberToken()->nullable();
        });
    }


    public function down(): void
    {
        Schema::dropIfExists('users');
    }
};
