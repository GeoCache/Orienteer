


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

new WOW().init();

// $(window).scroll(function() {
//     var scroll = $(window).scrollTop();
//     $("#hero").css({
//         width: (100 + scroll/5)  + "%"
//
//
//
// });
// });
