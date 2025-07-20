


<x-layout :title="'Home'" :logo="asset('Resources/Logo/vortexifyLogo.svg')">

     <section class="color pb-5">

        <div class="cointainer-fluid">

            <div class="row pt-5 justify-content-center">
                <div class="col-12 pt-5 pb-5">

                    <figure class="text-center pt-5 pb-5">
                        <blockquote class="blockquote">
                            <i class="bi bi-tools text-white mb-3 fs-1"></i>
                            <p class="text-white" id="heading">Vortexify: A Builder</p>
                        </blockquote>
                        <figcaption class="blockquote-footer">
                            "From code to container <cite title="Source Title">— Vortexify spins it, builds it, lives
                                it.</cite>
                        </figcaption>
                    </figure>
                    <div class="d-flex justify-content-center">
                        <button type="button" class="btn-hover me-3" data-bs-toggle="modal"
                            data-bs-target="#exampleModalLong1">
                            <i class="bi bi-file-earmark-medical-fill text-white me-3"></i>Instructions
                        </button>
                        <button type="button" class="btn-hover me-3" data-bs-toggle="modal"
                            data-bs-target="#exampleModalLong">
                            <i class="bi bi-cpu-fill text-white me-3"></i>Tech Used
                        </button>

                    </div>

                </div>


                <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog"
                    aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header color text-white">
                                <h5 class="modal-title" id="exampleModalLongTitle"><i class="bi bi-cpu-fill text-white me-3"></i>Tech Used</h5>
                                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body color">
                                <ol>
                                    <li class="text-white fs-4">VMWare (for virtual Machine)</li>
                                    <li class="text-white fs-4">Kali LINUX OS</li>
                                    <li class="text-white fs-4">Spring Boot For Brain Module</li>
                                    <li class="text-white fs-4">Python Automation for Heart Module</li>
                                    <li class="text-white fs-4">Laravel for Skin Module</li>
                                    <li class="text-white fs-4">Shell Scripting for System Level Scripting</li>
                                    <li class="text-white fs-4">Auto scalability and De-Scalability by AI Module for
                                        better resource optimization (comming soon...)</li>
                                    <li class="text-white fs-4">Real Time Logging (comming soon...)<br>
                                    and many more.....</li>

                                </ol>

                            </div>
                            <div class="modal-footer color">
                                <button type="button" class="btn color text-white btn-hover"
                                    data-bs-dismiss="modal">Close</button>

                            </div>
                        </div>
                    </div>
                </div>



                <div class="modal fade" id="exampleModalLong1" tabindex="-1" role="dialog"
                    aria-labelledby="exampleModalLongTitle1" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header color text-white">
                                <h5 class="modal-title" id="exampleModalLongTitle"><i
                                        class="bi bi-file-earmark-medical-fill text-white me-3"></i>Instructions</h5>
                                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body color">
                                <ol>
                                    <li class="text-white fs-4">Provide an absolute GitHub repository URL.</li>
                                    <li class="text-white fs-4">Ensure the repository contains a valid Dockerfile at the
                                        root
                                        or specified directory for successful containerization.</li>
                                    <li class="text-white fs-4">Keep the repository public to allow Vortexify to access
                                        and
                                        clone the
                                        repository. (Private repo feature comming soon....)</li>
                                    <li class="text-white fs-4">Make sure your application code is present in the main
                                        branch.
                                        (Deployment process will pull from the main branch by default.)</li>
                                    <li class="text-white fs-4">Follow naming conventions for Docker ports inside your
                                        application if any, to avoid conflicts during deployment.</li>
                                </ol>

                            </div>
                            <div class="modal-footer color">
                                <button type="button" class="btn color text-white btn-hover"
                                    data-bs-dismiss="modal">Close</button>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-evenly">
                    <div class="col-md-7">
                        <p class="text-white fs-5 mt-3 lead">Vortexify is designed to empower a wide spectrum of
                            technology
                            professionals and learners seeking a faster, smarter
                            approach to application deployment. DevOps practitioners will find Vortexify an essential
                            tool for automating
                            containerized deployments, enabling them to manage remote Docker environments with precision
                            and ease. Full-stack
                            developers can utilize the platform to instantly transform their GitHub repositories into
                            live, running applications
                            without the overhead of manual server configuration. For students and educators, Vortexify
                            offers a real-world platform
                            to explore core DevOps, Docker, and deployment concepts, making it a powerful addition to
                            any technical curriculum.
                            Deployment engineers and quality assurance teams can leverage the tool to quickly provision
                            isolated testing
                            environments, accelerating development cycles and improving software delivery pipelines.
                            Startups, small businesses, and
                            agile teams can dramatically reduce time-to-market by using Vortexify’s automated workflows
                            instead of building complex,
                            costly infrastructure from scratch. Its modular architecture — powered by Spring Boot,
                            Python, and Laravel — ensures
                            high scalability, maintainability, and future readiness, aligning with modern industry
                            standards. In a world where
                            automation defines success, Vortexify stands as a practical, versatile, and indispensable
                            solution for anyone aiming to
                            bridge the gap between development and deployment with speed, reliability, and clarity.

                        </p>
                        <p class="text-white fs-5 text-center"><i
                                class="bi bi-person-raised-hand text-white me-3"></i>Welcome To Vortexify<i
                                class="bi bi-tools text-white ms-3"></i></p>
                    </div>
                </div>
            </div>
    </section>

    <x-footer> </x-footer>


</x-layout>