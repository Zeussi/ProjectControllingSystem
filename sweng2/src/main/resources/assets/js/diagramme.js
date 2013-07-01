function drawDiagrams(JSONFilterRules, keyFigure, diagramID, serviceName) {
    jQuery.ajax({
        url: "service/" + serviceName + "/" + keyFigure,
        type: "POST",
        data: JSON.stringify(JSONFilterRules),
        dataType: "json",
        contentType: "application/json",
    }).done(function (result) {
        var dataPre = {
            labels: [result.valuesX],
            datasets: [result.valuesY]
        }
        dataPre = {
            labels: result.valuesX,
            datasets: [{
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                data: result.valuesY
            }]
        }

        var ctx = $("#" + diagramID).get(0).getContext("2d");
        var x = new Chart(ctx).Bar(dataPre);

    });
}

function drawTable(JSONFilterRules, keyFigure, diagramID) {
    jQuery.ajax({
        url: "service/only-keyfigures",
        type: "POST",
        data: JSON.stringify(JSONFilterRules),
        dataType: "json",
        contentType: "application/json",
    }).done(function (result) {

        for (var i = 0; i < result.length; i++)
		{			
			    $('#grid').data('kendoGrid').dataSource.add({
				kennzahl: result[i].keyFigure,
				value: result[i].keyFigureValue
				});
			
		}


    });
}