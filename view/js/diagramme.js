var getParam = getUrlVars()["filtername"];

$.post("services/time-behavier-keyfigure", getParam, function(data) {


    var dataPre = {
        labels : ["Projekt 1","Projekt 2","Projekt 3","Projekt 4","Projekt 5","Projekt 6","Projekt 7"],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
            }/*,
             {
             fillColor : "rgba(151,187,205,0.5)",
             strokeColor : "rgba(151,187,205,1)",
             pointColor : "rgba(151,187,205,1)",
             pointStrokeColor : "#fff",
             data : [28,48,40,19,96,27,100]
             }*/
        ]
    }

    //Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#diagram-auslastung").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    //var auslastung = new Chart(data);

    new Chart(ctx).Bar(data);


    var ctx2 = $("#diagram-ertrag").get(0).getContext("2d");
    new Chart(ctx2).Bar(data);

    var ctx3 = $("#diagram-krankheitsauslastung").get(0).getContext("2d");
    new Chart(ctx3).Bar(data);

    var ctx4 = $("#diagram-auslastung-zeit").get(0).getContext("2d");
    new Chart(ctx4).Line(data);
});





function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}