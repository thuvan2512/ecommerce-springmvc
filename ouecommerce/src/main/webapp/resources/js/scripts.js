/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


window.onscroll = function () {
    scrollFunction()
};
function scrollFunction() {
    if (document.body.scrollTop > 120 || document.documentElement.scrollTop > 120) {
        document.querySelector(".button-go-to-top").style.display = "block";
        document.getElementById("navbar").classList.add("fixed-top")
        document.getElementById("search").style.display = "block";
    } else {
        document.querySelector(".button-go-to-top").style.display = "none";
        document.getElementById("navbar").classList.remove("fixed-top");
        document.getElementById("search").style.display = "none";
    }
}
function topFunction() {
    document.documentElement.scrollTop = 0;
    document.body.scrollTop = 0; //safary
}

function addComment() {
//    event.preventDefault();
    var content_comment = document.getElementById('content-of-comment').value;
    var patient_comment = document.getElementById('name-of-patient-comment').value;
    var star_comment = document.querySelector('input[name="rating"]:checked');
    if (star_comment != null && patient_comment != "" && content_comment != "") {
        console.log(patient_comment + " - " + content_comment + " - " + star_comment.value);
        alert("Send feedback successfully !!!");
    }else{
        alert("Please enter all required information");
    }
    
}