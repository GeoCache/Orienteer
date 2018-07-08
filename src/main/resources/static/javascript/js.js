//n
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
//Bootstrap animation initiation---------
new WOW().init();
//animation END--------------------------

// $(window).scroll(function() {
//     var scroll = $(window).scrollTop();
//     $("#hero").css({
//         width: (100 + scroll/5)  + "%"
//
//
//
// });
// });
// Bootstrap js for Google Maps-----------------------------
function regular_map() {
    var map, infoWindow, marker, pos;

    var myStyles =[
        {
            featureType: "poi",
            elementType: "labels",
            stylers: [
                { visibility: "off" }
            ]
        }
    ];

    function CenterControl(controlDiv, map) {

        // Set CSS for the control border.
        var controlUI = document.createElement('button');
        controlUI.style.height= '20px';
        controlUI.style.width= '20px';
        controlUI.style.backgroundColor = '#fff';
        controlUI.style.border = '2px solid #fff';
        controlUI.style.borderRadius = '15px';
        controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
        controlUI.style.cursor = 'pointer';
        controlUI.style.marginBottom = '22px';
        controlUI.style.textAlign = 'center';
        controlUI.title = 'Click to recenter the map';
        controlDiv.appendChild(controlUI);

        // Set CSS for the control interior.
        var controlText = document.createElement('div');
        controlText.style.paddingLeft = '5px';
        controlText.style.paddingRight = '5px';
        controlText.style.backgroundImage = 'img("static/img/gps.svg")';
        controlText.style.backgroundSize = '10px 10px';
        controlText.style.backgroundPosition = '0px 0px';
        controlText.style.backgroundRepeat = 'no-repeat';
        controlUI.appendChild(controlText);

        // Setup the click event listeners: simply set the map to Chicago.
        controlUI.addEventListener('click', function() {
            map.setCenter(pos);
        });

    }
    var location = new google.maps.LatLng(29.426791, -98.489602);

    //Google Maps js----------------------------------
    var mapoptions = {
        center: location,
        zoom: 14,
        styles: myStyles,
        disableDefaultUI: true
    };

    map = new google.maps.Map(document.getElementById("map-container"),
        mapoptions);

    marker = new google.maps.Marker({
        position: map.center,
        map: map,
        icon: {
            path: google.maps.SymbolPath.CIRCLE,
            scale: 5,
            strokeColor: 'black',
            fillColor: 'red',
            fillOpacity: 1
        }
    });
    var centerControlDiv = document.createElement('div');
    var centerControl = new CenterControl(centerControlDiv, map);

    centerControlDiv.index = 1;
    map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(centerControlDiv);

    // Allows app to access built in GPS in devices
    const watchOptions = {
        enableHighAccuracy: true,
        timeout: 1
    };

    infoWindow = new google.maps.InfoWindow;
    if (navigator.geolocation) {

        navigator.geolocation.watchPosition(function (position) {

             pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            marker.setPosition(pos);
            infoWindow.setPosition(pos);
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        }, watchOptions);
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

//Google Maps js END-------------------------------------------