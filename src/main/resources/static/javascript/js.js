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
        startLocation = evt.latLng.toString()
    });
    google.maps.event.addListener(map, 'mouseup', function (evt) {
        holdTime = Date.now() - holdStart;
        endLocation = evt.latLng.toString();
        console.log(holdTime);
        if (holdTime >= 1000 && startLocation === endLocation) {
            // Line to make testing faster
        // if(true){
            placeMarker(evt.latLng);
            marker.id = uniqueId;
            uniqueId++;

            //Attach click event handler to the marker.
            google.maps.event.addListener(marker, "click", function (e) {
                var content = 'Latitude: ' + location.lat() + '<br />Longitude: ' + location.lng();
                content += "<br />" +
                    "<div class='dlBtnWrapper'>" +
                    "<input data-id="+marker.id+" class='deleteBtn' type = 'button' value='Delete' />" +
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

    $('div').delegate('.deleteBtn','click', function(){
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
        console.log(markers);
    });

    // Places marker at a specified location
    function placeMarker(location) {
        marker = new google.maps.Marker({
            position: location,
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

    // Sets the location for the center on me button
    var centerControlDiv = document.createElement('div');
    var centerControl = new CenterControl(centerControlDiv, map);
    centerControlDiv.index = 1;
    map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(centerControlDiv);

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
                first++
            }

            // Keeps marker on their location
            gps.setPosition(pos);
            infoWindow.setPosition(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        }, watchOptions);
    } else {
        handleLocationError(false, infoWindow, map.getCenter());
    }

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

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
            'Error: The Geolocation service failed.' :
            'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
    }
};



//Google Maps js END-------------------------------------------
if (document.documentElement.requestFullscreen) {

document.documentElement.requestFullscreen();
}
