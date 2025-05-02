<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Votexify-SignUp</title>
    <link rel="stylesheet" href="{{ asset('Resources/bootstrap.min.css') }}">
    <link rel="stylesheet" href="{{ asset('Resources/font/bootstrap-icons.min.css') }}">
    <link rel="stylesheet" href="{{ asset('Resources/style.css') }}">
     <link rel="icon" type="image/png" href="{{ asset('Resources/Logo/vortexifyProfile.svg') }}">
    <script src="{{ asset('Resources/bootstrap.bundle.min.js') }}"></script>



</head>

<body>

    <section class="background-radial-gradient color pt-5" id="sign-up">


        <div class="container px-4 py-5 px-md-5 text-center text-lg-start">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Vortexify <br />
                        <span style="color: hsl(218, 81%, 75%)">Draws in code, Spinning out solutions.</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Vortexify is designed to empower a wide spectrum of
                        technology
                        professionals and learners seeking a faster, smarter
                        approach to application deployment. DevOps practitioners will find Vortexify an essential
                        tool for automating
                        containerized deployments, enabling them to manage remote Docker environments with precision
                        and ease. Full-stack
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass color text-white">
                        <div class="card-body px-4 py-5 px-md-5">
                            <form method="post" action="/signup">
                                @csrf
                                <!-- 2 column grid layout with text inputs for the first and last names -->
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline me-3">
                                            <input type="text" name="firstName" id="form3Example1" value="{{ old('firstName') }}" class="form-control" />
                                            <label class="form-label" for="form3Example1">First name</label>
                                            @error('firstName')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="text" name="lastName" id="form3Example2" value="{{ old('lastName') }}" class="form-control" />
                                            <label class="form-label" for="form3Example2">Last name</label>
                                        </div>
                                        @error('lastName')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                         
                                    </div>
                                </div>

                                <!-- Email input -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="email" name="email" value="{{ old('email') }}" id="form3Example3" class="form-control" />
                                    <label class="form-label" for="form3Example3">Email address</label>
                                     @error('email')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                </div>
                                

                                <!-- Password input -->
                                <div data-mdb-input-init class="form-outline">
                                    <div class="input-wrapper">
                                    <input type="password" name="password" id="password" class="form-control" />
                                    <button type="button" class="btn" id="eye-button"><i class="bi bi-eye-slash-fill" id="eye-icon"></i></button>
                                    </div>
                                    <label class="form-label" for="password">Password</label>
                                </div>
                              <!-- Dropdown for Password Rules -->
                            <div id="passwordRules" style="display:none;">
                                     <ul id="passwordRuleList">
                                         <li id="rule1" class="rule">At least 8 characters</li>
                                         <li id="rule2" class="rule">At least one uppercase letter</li>
                                         <li id="rule3" class="rule">At least one lowercase letter</li>
                                         <li id="rule4" class="rule">At least one number</li>
                                         <li id="rule5" class="rule">At least one special character (@$!%*?&)</li>
                                     </ul>
                                 </div>

                                <!-- Confirm Password input -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="confirmPassword" class="form-control" readonly />
                                    <label class="form-label" for="confirmPassword">Confirm Password</label>
                                </div>

                                <!-- Describe your Profession input -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <textarea id="form3Example5"  name="message" rows="2" cols="50" class="form-control">
                                        {{ old('message') }}
                                    </textarea>
                                    <label class="form-label" for="form3Example5">Describe your Profession...</label>
                                    @error('message')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                </div>
                                 

                                
                                <div class="form-check d-flex justify-content-center mb-4">
                                    <label class="form-check-label">
                                        <i class="bi bi-person-raised-hand text-white me-3"></i>Welcome To Vortexify<i
                                            class="bi bi-tools text-white ms-3"></i>
                                    </label>
                                </div>

                                <!-- Submit button -->
                                <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-primary btn-block mb-4" id="submitBtn" disabled>
                                    Sign up
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </section>









    <script src="{{asset('Resources/eyeScript.js')}}"> </script>
    <script src="{{asset('Resources/passwordScript.js')}}"> </script>
</body>

</html>