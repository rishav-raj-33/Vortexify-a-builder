// Function to smoothly scroll to the bottom of the log-display
function scrollToLatestLog() {
    const logDisplay = document.getElementById('log-display');
    logDisplay.scrollTo({
        top: logDisplay.scrollHeight,
        behavior: 'smooth' // smooth scroll
    });
}

// Example: Adding a new log and scrolling
function addNewLog(message) {
    const logDisplay = document.getElementById('log-display');
    const newLog = document.createElement('div');
    newLog.textContent = message;
    logDisplay.appendChild(newLog);
    scrollToLatestLog(); // Scroll after adding new log
}


setInterval(() => {
    const timestamp = new Date().toLocaleTimeString();
    addNewLog(`New log at ${timestamp}`);
}, 2000);


setTimeout(() => {
    addNewLog('Deployment Completed Successfully ✅');
}, 1000);  // after 5 seconds
