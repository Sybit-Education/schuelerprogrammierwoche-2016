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

$(document).ready(function() {
    $("#plz").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
                // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
                // Allow: Ctrl+C
            (e.keyCode == 67 && e.ctrlKey === true) ||
                // Allow: Ctrl+X
            (e.keyCode == 88 && e.ctrlKey === true) ||
                // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
});


