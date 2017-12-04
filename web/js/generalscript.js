function validateForm() {

    var x = document.forms["mystaff"]["username"].value;
    if (x == null || x == "") {
        alert("username must be filled out");
        return false;
    }

    var x = document.forms["mystaff"]["firstname"].value;
    if (x == null || x == "") {
        alert("firstname must be filled out");
        return false;
    }

    var x = document.forms["mystaff"]["lastname"].value;
    if (x == null || x == "") {
        alert("lastname must be filled out");
        return false;
    }

    var x = document.forms["mystaff"]["emailaddress"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        alert("Not a valid e-mail address");
        return false;
    }

    var x = document.forms["mystaff"]["dob"].value;
    if (x == null || x == "") {
        alert("Date of birth must be filled out");
        return false;
    }
    var x = document.forms["mystaff"]["hiredate"].value;
    if (x == null || x == "") {
        alert("Date of hire must be filled out");
        return false;
    }
    var x = document.forms["mystaff"]["sinno"].value;
    if (x == null || x == "") {
        alert("SIN number must be filled out");
        return false;
    }

    if (ocument.forms["mystaff"]["sinno"].value != 9) {
        alert("Error: Password must contain only 9 characters!");
        return false;
    }

    var x = document.forms["mystaff"]["aboutstaff"].value;
    if (x == null || x == "") {
        alert("About Staff must be filled out");
        return false;
    }
}


