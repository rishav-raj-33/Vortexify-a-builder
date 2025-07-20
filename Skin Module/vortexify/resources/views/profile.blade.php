<x-layout :title="'Profile'" :logo="asset('Resources/Logo/vortexifyProfile.svg')">



        <section class="color" id="profile">
        <div class="container pt-4 mb-4 p-3 d-flex justify-content-center">
            <div class="card-p p-4">
                <div class=" image d-flex flex-column justify-content-center align-items-center"> <button
                        class="btn-p btn-secondary"> <img src="{{asset('Resources/Logo/default.png')}}" height="100" width="100" /></button> <span
                        class="name mt-3">{{ auth()->user()->first_name ." ". auth()->user()->last_name  }}</span> <span class="idd">{{ auth()->user()->email }}</span>
                    <div class="d-flex flex-row justify-content-center align-items-center gap-2"> <span
                            class="idd1">User Id: {{  auth()->user()->id}} </span> <span><i class="bi bi-person-vcard"></i></span> </div>
                    <div class="d-flex flex-row justify-content-center align-items-center mt-3"> <span class="number">{{$count}}
                            <span class="follow">Deployments</span></span> </div>
                    <div class=" d-flex mt-2"> <button class="btn1 btn-dark">User Description</button> </div>
                    <div class="text mt-3 text-center"> <span class="word">{{  auth()->user()->description  }}
                            <br><br><i class="bi bi-tools me-3 fs-3 ms-3"></i> User of Vortexify </span>
                    </div>

                    <div class=" px-2 rounded mt-4 date "> <span class="join">Joined {{ auth()->user()->created_at->format('F Y') }}</span> </div>
                </div>
            </div>
        </div>


    </section>

</x-layout>