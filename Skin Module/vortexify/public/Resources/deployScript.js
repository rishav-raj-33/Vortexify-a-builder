function isValidGitHubRepo(url) {
    const regex = /^https:\/\/github\.com\/[a-zA-Z0-9-]+(\/[a-zA-Z0-9-_.]+)?(\/)?$/;
    return regex.test(url);
}



function submitForm() {
    var url = document.getElementById("git-hub-text").value;
    if (!isValidGitHubRepo(url)) {
        
        document.getElementById('undefined-url').style.display = 'block';
        setTimeout(() => {
            document.getElementById('undefined-url').style.display = 'none';
        }, 3000);
    } else {
        console.log(document.getElementById('loader'));
        document.getElementById('loader').style.display = 'block';
    }

}