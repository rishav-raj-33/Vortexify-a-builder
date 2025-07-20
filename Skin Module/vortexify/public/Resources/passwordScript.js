const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');
const passwordRules = document.getElementById('passwordRules');

confirmPassword.addEventListener('keyup', function () {
    if (confirmPassword.value === password.value) {
        confirmPassword.style.border = '4px solid green';
        document.getElementById("submitBtn").disabled = false;
    } else {
        confirmPassword.style.border = '4px solid red';
    }
});


passwordElement.addEventListener("keyup", function () {
    passwordRules.style.display = 'block';
    const passwordValue = password.value;

    // Regular expressions to validate the rules
    const rules = [
        { id: "rule1", regex: /.{8,}/, message: "At least 8 characters" },
        { id: "rule2", regex: /[A-Z]/, message: "At least one uppercase letter" },
        { id: "rule3", regex: /[a-z]/, message: "At least one lowercase letter" },
        { id: "rule4", regex: /\d/, message: "At least one number" },
        { id: "rule5", regex: /[@$!%*?&]/, message: "At least one special character (@$!%*?&)" }
    ];

    // Check each rule
    rules.forEach(rule => {
        const ruleElement = document.getElementById(rule.id);

        // If password matches the rule, mark it as satisfied and hide the rule
        if (rule.regex.test(passwordValue)) {
            ruleElement.classList.add("satisfied");
            ruleElement.classList.remove("rule");
            ruleElement.style.color = 'green';  // Turn the text green
            ruleElement.style.textDecoration = 'line-through';  // Strike through the rule
            ruleElement.style.display = 'none';  // Hide the rule
        } else {
            ruleElement.classList.remove("satisfied");
            ruleElement.classList.add("rule");
            ruleElement.style.color = 'red';  // Reset text color to red
            ruleElement.style.textDecoration = 'none';  // Remove line-through
            ruleElement.style.display = 'block';  // Show the rule
        }
    });

    // Check if all rules are satisfied to enable submit button
    const allRulesSatisfied = Array.from(document.querySelectorAll('#passwordRules .rule')).every(rule => rule.style.display === 'none');
    if (allRulesSatisfied) {
        confirmPassword.removeAttribute('readonly');

    }


});