function getAllVehicles() {
        $.ajax({
        url: "/vehicles/all",
        contentType: "application/json",
        dataType: 'json',
        cache: false,
        success: function (data) {
            $('#vehicleJosn').html(
               "<P><b>*****  Get Al Vehicles   *****<br/>"
               + "<br/>Total Vehicles : "+Object.keys(data).length+"</b></p>"
               .concat(buildJsonTable(data)));
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
            $('#vehicleJosn').html(
               "<P><b>*****  Get Al available Vehicles to hire   *****<br/>"
               + "<br/>Total Vehicles : "+Object.keys(data).length+"</b></p>"
               .concat(buildJsonTable(data)));
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

function buildJsonTable(data) {
    var keys = [];
    var table = "";
    table = table.concat("<table border==\"1\"><tr>");
    for (key in data[0]) {
        table = table.concat('<td>' + key + '</td>');
    }
    table = table.concat("</tr>");
    for (var i = 0; i < data.length; i++) {
        table = table.concat('<tr>');
        for (key in data[i]) {
        table = table.concat('<td>' + data[i][key] + '</td>');
      }
        table = table.concat('</tr>');
    }
    table = table.concat("</table>");
    return table;
}