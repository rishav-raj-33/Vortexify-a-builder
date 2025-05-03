let polling;
const buildBtn = document.getElementById("build");
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
        clearInterval(polling);
        fetch('/build', {  // The API endpoint to handle form submission
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': token
            },
            body: JSON.stringify({
                git_url: url
            })
        });
        polling = setInterval(fetchStatus, 5000);
        fetchStatus();  //Starts after Button is clicked..
    }

}



function fetchStatus() {
    fetch('/api/status')
        .then(response => {
            if (response.status === 404) {
                buildBtn.disabled = false;
                clearInterval(polling);     //if no process is going on then it will prevent from unnecessary calls to backend.
            }
            if (response.status === 202) {
                buildBtn.disabled = true;
                statusElement.textContent = "Deploying....";
            } else if (response.status === 200) {
                statusElement.textContent = "Process complete!";
                document.getElementById('loader').style.display = 'block';
                clearInterval(polling);
            }
        })
        .catch(error => {
            console.error('Error fetching status:', error);
            statusElement.textContent = "Failed to fetch status. Please try again later.";
        });
}

//If Page refreshes this will take take of the process status

polling = setInterval(fetchStatus, 5000);
fetchStatus();





