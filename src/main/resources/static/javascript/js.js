"use strict";


var prevScrollpos = window.pageYOffset;
window.onscroll = function() {
        var currentScrollPos = window.pageYOffset;
        if (prevScrollpos > currentScrollPos) {
            document.getElementById("myNavbar").style.top = "0px";
        } else {
            document.getElementById("myNavbar").style.top = "-56px";
        }
        prevScrollpos = currentScrollPos;
    };