

"use strict"

let opts = {

    //Wheather to scan continuously for QR codes. If false, user scanner.scan() to manually scan.
    //If true, the scanner emits the "scan" event when a QR code is scanned. Defult true.
    continuous: true,

    // Ther HTML element to use for the camera'

    video: document.getElementById('preview'),

    mirror: true,

    captureImage: false,

    backgroundScan: false,

    refactoryPeriod: 5000,

    scanPeriod: 1
};