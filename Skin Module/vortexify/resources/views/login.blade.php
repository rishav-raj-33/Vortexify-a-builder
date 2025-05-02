<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vortexify-Login</title>
    <link rel="stylesheet" href="{{ asset('Resources/bootstrap.min.css') }}">
    <link rel="stylesheet" href="{{ asset('Resources/font/bootstrap-icons.min.css') }}">
    <link rel="stylesheet" href="{{ asset('Resources/style.css') }}">
    <link rel="icon" type="image/png" href="{{ asset('Resources/Logo/vortexifyProfile.svg') }}">
    <script src="{{ asset('Resources/bootstrap.bundle.min.js') }}"></script>


</head>

<body>
    <section class="vh-100 color">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center color">


                            
                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                <p class="text-white-50 mb-5">Please enter your login and password!</p>

                                <div data-mdb-input-init class="form-outline form-white mb-4">
                                    <form method="post" action="/session">
                                        @csrf
                                    <div class="input-wrapper">
                                        <input type="email" id="typeEmailX" name="email" value="{{ old('email') }}" class="form-control form-control-lg" />
                                    </div>
                                    
                                    <label class="form-label" for="typeEmailX">Email</label>
                                    @error('email')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                </div>

                                <div data-mdb-input-init class="form-outline form-white mb-4">
                                    <div class="input-wrapper">
                                        <input type="password" id="password" name="password"  class="form-control form-control-lg" />
                                      <button type="button" class="btn" id="eye-button"><i class="bi bi-eye-slash-fill" id="eye-icon"></i></button>

                                    </div>
                                    
                                    <label class="form-label" for="password">Password</label>
                                    @error('password')
                                           <p class="text-danger fw-bold small">{{$message}}</p> 
                                        @enderror
                                </div>

                                <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="{{ route('password.request') }}">Forgot password?</a>
                                </p>

                                <button data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

                            </div>
                            </form>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="/signup" class="text-white-50 fw-bold">Sign
                                        Up</a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    </section>



<script src="{{asset('Resources/eyeScript.js')}}"> </script>
</body>

</html>