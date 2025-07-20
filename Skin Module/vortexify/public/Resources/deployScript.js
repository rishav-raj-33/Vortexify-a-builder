let polling;
let buildBtn = document.getElementById("btn-build");
let spinner = document.getElementById('spinner');

const statusElement = document.getElementById("status");



function isValidGitHubRepo(url) {
    const regex = /^https:\/\/github\.com\/[a-zA-Z0-9-]+(\/[a-zA-Z0-9-_.]+)?(\/)?$/;
    return regex.test(url);
}



function submitForm() {
    const token = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
    var url = document.getElementById("git-hub-text").value;
    if (!isValidGitHubRepo(url)) {

        document.getElementById('undefined-url').style.display = 'block';
        setTimeout(() => {
            document.getElementById('undefined-url').style.display = 'none';
        }, 3000);
    } else {
        buildBtn.disabled = true;
        document.getElementById('loader').style.display = 'block';
        clearInterval(polling);
        fetch('/request', {  // The API endpoint to handle form submission
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': token
            },
            body: JSON.stringify({
                'git_url': url
            })
        });

        polling = setInterval(fetchStatus, 10000);
        fetchStatus();  //Starts after Button is clicked..
    }

}



function fetchStatus() {



    fetch('/status')
        .then(response => {
            if (response.status === 204) {
                buildBtn.disabled = false;
                console.log(response.status);
                document.getElementById('loader').style.display = 'none';
                clearInterval(polling);     //if no process is going on then it will prevent from unnecessary calls to backend.
            }
            if (response.status === 202) {
                console.log(response.status);
                buildBtn.disabled = true;
                statusElement.textContent = "Deploying....";

                document.getElementById('loader').style.display = 'block';
            } else if (response.status === 200) {
                console.log(response.status);
                spinner.style.display = 'none';
                statusElement.textContent = "Process complete!";

                clearInterval(polling);
            }
        })
        .catch(error => {
            console.error('Error fetching status:', error);
            statusElement.textContent = "Failed..";
        });
}

//If Page refreshes this will take take of the process status

polling = setInterval(fetchStatus, 10000);   //20000
fetchStatus();







