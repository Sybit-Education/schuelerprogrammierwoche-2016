/* 
 * Script für die Anwendung
 */
$(document).ready(function () {
    var password = document.getElementById("password"), passwordWdh = document.getElementById("passwordWdh");

    function validatePassword() {
        if (password.value != passwordWdh.value) {
            passwordWdh.setCustomValidity("Die Passwörter stimmen nicht überein!");
        } else {
            passwordWdh.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    passwordWdh.onkeyup = validatePassword;

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


