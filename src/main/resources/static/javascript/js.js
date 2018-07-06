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
// Regular map
function regular_map() {
    var var_location = new google.maps.LatLng(29.426791, -98.489602);

    var var_mapoptions = {
        center: var_location,
        zoom: 14
    };

    var var_map = new google.maps.Map(document.getElementById("map-container"),
        var_mapoptions);

    var var_marker = new google.maps.Marker({
        position: var_location,
        map: var_map,
        title: "New York",
        icon: {
            path: google.maps.SymbolPath.CIRCLE,
            scale: 5,
            strokeColor: 'black',
            fillColor: 'red',
            fillOpacity: 1
        }
    });

    var infoWindow = new google.maps.InfoWindow;
    if (navigator.geolocation) {
        navigator.geolocation.watchPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            marker.setPosition(pos);
            infoWindow.setPosition(pos);
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}


// Initialize maps
google.maps.event.addDomListener(window, 'load', regular_map);