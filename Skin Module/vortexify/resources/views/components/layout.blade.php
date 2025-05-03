<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vortexify-{{$title}}</title>

    <link rel="stylesheet" href="{{ asset('Resources/bootstrap.min.css') }}">
    <link rel="stylesheet" href="{{asset('Resources/font/bootstrap-icons.min.css')}}">
    <link rel="stylesheet" href="{{ asset('Resources/style.css') }}">
    <script src="{{asset('Resources/bootstrap.bundle.min.js')}}"></script>
    <link rel="icon" type="image/png" href="{{$logo}}">
    <meta name="csrf-token" content="{{ csrf_token() }}">



</head>

<body>

    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark color">

        <div>
            <i class="bi bi-tools text-white me-3 fs-3 ms-3"></i>
            <span class="navbar-brand fs-2 lead">Vortexify</span>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span><i class="bi bi-blockquote-right"></i></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end me-3" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active me-5 fs-5 mb-3">
                    <i class="bi bi-house-gear-fill text-white me-3 ms-3"></i>
                    <a class="{{request()->is('home*')? 'lead link active' :'lead link'}}" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item active me-5 fs-5 mb-3">
                    <i class="bi bi-list me-3 text-white ms-3"></i>
                    <a class="{{request()->is('dlist*')? 'lead link active' :'lead link'}}" aria-current="page" href="/dlist">Deployment List</a>
                </li>
                <li class="nav-item active me-5 fs-5 mb-3">
                    <i class="bi bi-hammer text-white me-3 ms-3"></i>
                    <a class="{{request()->is('deploy*')? 'lead link active' :'lead link'}}" aria-current="page" href="/deploy">Deploy</a>
                </li>
                <li class="nav-item active fs-5 me-2 mb-3">
                    <i class="bi bi-person-circle me-3 text-white ms-3"></i>
                    <a class="{{request()->is('profile*')? 'lead link active' :'lead link'}}" aria-current="page" href="/profile">Profile</a>
                </li>
                <div class="btn-group dropstart">
        <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
         <i class="bi bi-three-dots-vertical text-white"></i>
        </button>
         <ul class="dropdown-menu">
            <li class="ms-3"> 
                <form action="/logout" method="POST">
                    @csrf
                <i class="bi bi-door-open-fill"></i>
                <button class="btn btn-border" id='logout'> Log Out </button>
                </form>
                </li>
                <li>
                    <form action="/delete" method="POST">
                        @csrf
                        @method('DELETE')
                        
                        <button class="btn btn-border fs-bold small" id="btn-delete"><i class="bi bi-person-x-fill"></i> Delete Account</button>
                    </form>
                </li>
         </ul>
      </div>
    </nav>


    {{$slot}}

  


@stack("deployScript")
@stack("listScript")

</body>

</html>