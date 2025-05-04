


<x-layout :title="'Deploy'" :logo="asset('Resources/Logo/vortexifyDeploy.svg')">


    <section class="color" id="deploy-section">

        <div class="cointainer-fluid">
            <div class="row justify-content-center pt-5">
                <div class="col-md-6 mt-6 text-white" id="text-area">
                    <h1><i class="bi bi-tools text-white me-3 fs-1 ms-3"></i>Vortexify a Builder</h1>
                    <p id="text">Draws in code, Spinning out solutions
                    </p>
                    <form id="urlForm" method="post">
                        @csrf
                        <input class="form-control form-control-lg" name="url" type="text" placeholder="Paste Absolue GitHub Url"
                            id="git-hub-text">
                        <button type="button" id="btn-build" onclick="submitForm()">Build</button>
                    </form>
                    <div class="d-flex mt-5">
                        <button class="btn text-white btn-border fs-5" type="button" id="loader">
                                <span class="spinner-border spinner-border-sm" aria-hidden="true" id="spinner"></span>
                                <span role="status" class="loader-text" id="status">Deploying...</span>
                            </button>
                    </div>
                        
                    
                    <div class="alert alert-danger" role="alert" id="undefined-url">
                        Git Hub Link Undefined or Not a Absolute Url.Check Again!
                    </div>

                </div>


            </div>




    </section>

    @push('deployScript')

    <script src="{{asset('Resources/deployScript.js')}}"> </script>
        
    @endpush

</x-layout>