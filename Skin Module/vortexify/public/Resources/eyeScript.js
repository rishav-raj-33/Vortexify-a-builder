let eyeIcon = document.getElementById("eye-icon");
let eyeButton = document.getElementById("eye-button");
let passwordElement = document.getElementById('password');



eyeButton.addEventListener('click', function () {
    if (passwordElement.getAttribute('type') == 'password') {
        passwordElement.setAttribute('type', 'text');
        eyeIcon.setAttribute("class", "bi bi-eye-fill");
    } else {
        passwordElement.setAttribute('type', 'password');
        eyeIcon.setAttribute("class", "bi bi-eye-slash-fill");

    }
})