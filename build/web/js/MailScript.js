/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateMail() {

    var x = document.forms["mailmessage"]["message"].value;
    if (x == null || x == "") {
        alert("Message box cannot be empty");
        return false;
    }

    var x = document.forms["mailmessage"]["multiselectemployee"].value;
    if (x == null || x == "") {
        alert("Please, do select a username in the list below");
        return false;
    }
}