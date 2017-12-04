

function validatePassword(form)
{
    if (form.newpassword.value != "" && form.newpassword.value == form.repeatnewpassword.value) {
        if (form.newpassword.value.length < 8) {
            alert("Error: Password must contain at least eight characters!");
            form.newpassword.focus();
            return false;
        }
        re = /[0-9]/;
        if (!re.test(form.newpassword.value)) {
            alert("Error: password must contain at least one number (0-9)!");
            form.newpassword.focus();
            return false;
        }
        re = /[a-z]/;
        if (!re.test(form.newpassword.value)) {
            alert("Error: password must contain at least one lowercase letter (a-z)!");
            form.newpassword.focus();
            return false;
        }
        re = /[A-Z]/;
        if (!re.test(form.newpassword.value)) {
            alert("Error: password must contain at least one uppercase letter (A-Z)!");
            form.newpassword.focus();
            return false;
        }
    } else {
        alert("Error: Please ensure that the password field match!");
        form.newpassword.focus();
        return false;
    }
    return true;
}