function getAllVehicles() {
        $.ajax({
        url: "/vehicles/all",
        contentType: "application/json",
        dataType: 'json',
        cache: false,
        success: function (data) {
            var count = Object.keys(data).length;
            var json = "<P><b>*****  Get Al Vehicles   *****<br/>"
                + "<br/>Total Vehicles : "+count+"</b></p><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#vehicleJosn').html(json);
        },
    });
}

function getVehiclesToHire() {
        $.ajax({
        url: "/vehicles/hire",
        contentType: "application/json",
        dataType: 'json',
        cache: false,
        success: function (data) {
            var count = Object.keys(data).length;
            var json = "<P><b>*****  Get Al available Vehicles to hire   *****<br/>"
                + "<br/>Total Vehicles : "+count+"</b></p><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#vehicleJosn').html(json);
        },
    });
}

function getVehicleHireCost() {
        $.ajax({
        url: "/vehicles/REG-4/2020-01-01/2020-01-31",
        contentType: "application/json",
        dataType: 'json',
        cache: false,
        success: function (data) {
            var json = "<P><b>*****  Get Vehicle hire cost  *****</b></p><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#vehicleJosn').html(json);
        },
    });
}

function getVehicleNotFoundMessage() {
        $.ajax({
        url: "/vehicle/XXXXX",
        cache: false,
        error: function (e) {
            var json = "<P><b>*****  Get Vehicle Not Found Error  *****</b></p><pre>"
                + e.responseText + "</pre>";
            $('#vehicleJosn').html(json);
        }
    });
}