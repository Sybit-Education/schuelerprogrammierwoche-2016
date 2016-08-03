/* 
 * Script für die Anwendung
 */
$(document).ready(function () {
    var password = document.getElementById("password"), passwordwdh = document.getElementById("passwordwdh");

    function validatePassword() {
        if (password.value != passwordwdh.value) {
            passwordwdh.setCustomValidity("Die Passwörter stimmen nicht überein!");
        } else {
            passwordwdh.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    passwordwdh.onkeyup = validatePassword;

    var email = document.getElementById("email");

    function validateEmail() {
        if (email.value.length >= 5 && email.value.includes("@") && email.value.includes(".")) {
            email.setCustomValidity('');
        } else {
            email.setCustomValidity("Email falsch");
        }
    }

    email.onchange = validateEmail;
});


