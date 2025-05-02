<x-layout :title="'Deployment List'" :logo="asset('Resources/Logo/deployList.svg')">


<section class="color" id="deploylist-section">


        <div class="container-fluid color text-white">
            <div class="row justify-content-center pt-5">
                <div class="col-md-6 mt-6 text-white pt-5">
                    <input class="form-control form-control-lg" type="text" oninput="search()"
                        placeholder="Search by Deployment Status...." id="Search-deploy">
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-12">
                    <section class="intro mt-3" id="table-content">
                        <div class="h-100">
                            <div class="mask d-flex align-items-center h-100">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-12">
                                            <div class="table-responsive">
                                                <table class="table mb-0">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">User ID</th>
                                                            <th scope="col">Live Url</th>
                                                            <th scope="col">Created At</th>
                                                            <th scope="col">Updated At</th>
                                                            <th scope="col">Status</th>
                                                            <th scope="col">Power ON/ OFF/ Terminate</th>
                                                            <th scope="col">Logs</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody id="table-body">
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                </div>

            </div>

        </div>












    </section>


    @push('listScript')
    <script src="{{asset('Resources/searchPaste.js')}}"> </script>

    @endpush

</x-layout>