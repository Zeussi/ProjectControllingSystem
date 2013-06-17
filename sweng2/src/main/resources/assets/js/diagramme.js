
function drawDiagrams(JSONFilterRules, keyFigure)
{
	jQuery.ajax ({
		url: "service/time-behaviour-keyfigures/" + keyFigure,
		type: "POST",
		data: JSON.stringify(JSONFilterRules),
		dataType: "json",
		contentType: "application/json",
	}).done(function( data2 ) {
		var dataPre = {
            labels : [data2.valuesX],
            datasets : [data2.valuesY]
        }
		
		alert(data2.valuesX);
		dataPre = {
	labels : data2.valuesX,
	datasets : [
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : data2.valuesY
		}
	]
}
		
        var ctx = $("#diagram-auslastung").get(0).getContext("2d");
        var x = new Chart(ctx).Bar(dataPre);
		
	});
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}