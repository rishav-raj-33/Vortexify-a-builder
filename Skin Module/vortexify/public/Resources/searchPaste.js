function copyValue(button) {

    let icon = button.querySelector('i');



    icon.setAttribute('class', 'bi bi-clipboard-check-fill ms-3 text-white');  //change icon

    var valueToCopy = button.value; // get the value of the clicked button

    navigator.clipboard.writeText(valueToCopy)


    setTimeout(() => {
        icon.setAttribute('class', 'bi bi-clipboard ms-3 text-white');  //change icon

    }, 1000);

}




//--------------------------------------------------------------------------

