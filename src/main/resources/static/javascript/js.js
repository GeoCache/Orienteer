//n

function approximate(number) {
    return Number(number.toFixed(4));
}

function getApproximatLocation(lat, long) {
    return {
        'lat': lat,
        'long': long
    }

}


//HOME and LOGIN navigation: hide and show nav on scroll----------------------
var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;
    if (prevScrollpos > currentScrollPos) {
        document.getElementById("myNavbar").style.top = "0px";
    } else {
        document.getElementById("myNavbar").style.top = "-85px";
    }
    prevScrollpos = currentScrollPos;
};
//END-----------------------------------------------------------------------------

//Bootstrap animation initiation---------
new WOW().init();

var markers = [];
var uniqueId = 1;
// Google map js
window.onload = function () {
    var map, infoWindow, marker, pos;
    var holdStart = null;
    var holdTime = null;
    var startLocation = null;
    var endLocation = null;
    var first = 1;

    // Allows app to access built in GPS in devices
    const watchOptions = {enableHighAccuracy: true, timeout: 1};

    var myStyles = [
        {featureType: "poi", elementType: "labels", stylers: [{visibility: "off"}]}
    ];

    if (document.getElementById("lat") != null) {
        var zoomedMarker = {
            lat: document.getElementById("lat").value,
            lon: document.getElementById("lon").value,
            username: document.getElementById("userName").value,
            cacheName: document.getElementById("cacheName").value
        };
    var zoomedLocation = new google.maps.LatLng(zoomedMarker.lat, zoomedMarker.lon);
    }


// Creates initial map and location
    var location = new google.maps.LatLng(29.426791, -98.489602);
    var mapoptions = {
        center: location,
        zoom: 18,
        styles: myStyles,
        disableDefaultUI: true,
        options: {
            minZoom: 5
            , maxZoom: 20
        }
    };

// Sets the map to our mapcontainer div
    map = new google.maps.Map(document.getElementById("map-container"),
        mapoptions);

// Hold down for 3 seconds to add a marker and pull those cordinates
    google.maps.event.addListener(map, 'mousedown', function (evt) {
        holdStart = Date.now();
        startLocation = evt.latLng;


        var lat = startLocation.lat();
        var long = startLocation.lng();

        lat = approximate(lat);
        long = approximate(long);

        startLocation = getApproximatLocation(lat, long)

    });


    google.maps.event.addListener(map, 'mouseup', function (evt) {
        holdTime = Date.now() - holdStart;
        endLocation = evt.latLng;

        var lat = endLocation.lat();
        var long = endLocation.lng();

        lat = approximate(lat);
        long = approximate(long);

        endLocation = getApproximatLocation(lat, long);

        console.log({holdTime});
        console.log({startLocation});
        console.log({endLocation});


        if (holdTime >= 1000 && startLocation.lat == endLocation.lat && startLocation.long == endLocation.long) {

            // Line to make testing faster
            // if(true){
            placeMarker(evt.latLng);
            marker.id = uniqueId;
            uniqueId++;
            location = (evt.latLng);

            //Attach click event handler to the marker.
            google.maps.event.addListener(marker, "click", function (e) {
                var content = 'Latitude: ' + location.lat() + '<br />Longitude: ' + location.lng();
                content += "<br />" +
                    "<div class='dlBtnWrapper'>" +
                    "<input data-id=" + marker.id + " class='deleteBtn' type = 'button' value='Delete' />" +
                    "</div>";
                var infoWindow = new google.maps.InfoWindow({
                    content: content
                });
                infoWindow.open(map, marker);
            });
            markers.push(marker);
            $("#latitude").html("Latitude: " + location.lat());
            $("#longitude").html("Longitude: " + location.lng());
            $('#geocacheModal').modal('toggle');

            // $("#latitude").html("Latitude: " + latitude);
            // $("#longitude").html("Longitude: " + longitude);

            // help back end find info

            $("#latitude-input").val(location.lat());
            $("#longitude-input").val(location.lng());


        }

    });


    $('div').delegate('.deleteBtn', 'click', function () {
        var id = $(this).attr('data-id');
        for (var i = 0; i < markers.length; i++) {
            if (markers[i].id == id) {
                //Remove the marker from Map
                markers[i].setMap(null);
                //Remove the marker from array.
                // markers.splice(i, 1);
                return;
            }
        }

    });

// Places marker at a specified location
    function placeMarker(pos) {
        marker = new google.maps.Marker({
            position: pos,
            map: map,
            animation: google.maps.Animation.DROP
        });
    }

// Custom marker made to mark persons current location
    var gps = new google.maps.Marker({
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
//ajax request for database location data-----------------------------------------------
    (function ($) {
        var request = $.ajax({'url': '/geocaches.json'});
        request.done(function (geocaches) {
            geocaches.forEach(function (geocache) {

                //console logs --------------
                // console.log(geocache.latitude);
                // console.log(geocache.longitude);
                // console.log(geocache.description);
                // console.log(geocache.name);
                //console logs end-----------------

                var userMarker = new google.maps.Marker({
                    position: {lat: geocache.latitude, lng: geocache.longitude},
                    map: map,
                    animation: google.maps.Animation.DROP
                });
                userMarker.setMap(map);

            })


        });
    })(jQuery);
//ajax END-----------------------------------------------------------------------------

// Sets the location for the center on me button---------------------------------------
    var centerControlDiv = document.createElement('div');
    var centerControl = new CenterControl(centerControlDiv, map);
    centerControlDiv.index = 1;
    map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(centerControlDiv);


    function CenterControl(controlDiv, map) {
        // Controls the appearance of our center on me button.
        var controlUI = document.createElement('div');
        controlUI.style.marginRight = '10px';
        controlUI.style.height = '35px';
        controlUI.style.width = '35px';
        controlUI.style.borderRadius = '20px';
        controlUI.style.cursor = 'pointer';
        controlUI.style.marginBottom = '1.5vh';
        controlUI.style.textAlign = 'center';
        controlUI.title = 'Click to recenter the map';
        controlDiv.appendChild(controlUI);
        var controlText = document.createElement('div');
        controlText.style.height = '30px';
        controlText.style.width = '30px';
        controlText.style.backgroundImage = 'url(/img/gps.svg)';
        controlText.style.backgroundSize = '30px 30px';
        controlText.style.backgroundPosition = '0px 0px';
        controlText.style.marginRight = '5px';
        controlText.style.backgroundRepeat = 'no-repeat';
        controlUI.appendChild(controlText);

        // Setup the click event listeners: simply set the map to users location.
        controlUI.addEventListener('click', function () {
            map.setCenter(pos);
        });

    }

//center UI button END-------------------------------------------------------------------

// Display an infowindow if there is an error
    infoWindow = new google.maps.InfoWindow;
    if (navigator.geolocation) {
        navigator.geolocation.watchPosition(function (position) {
            pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };


            // Sets the map to persons location the first time
            if (first === 1) {
                map.setCenter(pos);
                // map.setCenter(zoomedLocation);
                // console.log(zoomedLocation);
                first++

            }

            // Keeps marker on their location

            if (zoomedLocation != null) {
                map.setCenter(zoomedLocation);
                infoWindow.setPosition(zoomedLocation);
            }


            if (zoomedLocation == null) {
                gps.setPosition(pos);
                infoWindow.setPosition(pos);
            }
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        }, watchOptions);
    } else {
        handleLocationError(false, infoWindow, map.getCenter());
    }

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?

            //  => This error needs to be fixed in the future.
            'You are here.' :
            'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
    }
}
;


//Google Maps js END-------------------------------------------
