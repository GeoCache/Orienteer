"use strict";


var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;
    if (prevScrollpos > currentScrollPos) {
        document.getElementById("myNavbar").style.top = "0px";
    } else {
        document.getElementById("myNavbar").style.top = "-75px";
    }
    prevScrollpos = currentScrollPos;
};

$(window).scroll(function () {
    var scroll = $(window).scrollTop();
    $(".zoom #img").css({
        width: (100 + scroll / 5) + "%"
    });
});