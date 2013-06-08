$(document).ready(function(){
    initDatabase();

    /*$.getJSON( "js/filterlist.json", function(jsonKennzahlenData) {
        setKennzahlenTableContent(jsonKennzahlenData);
    });*/
});

// show data with json input
/*function setKennzahlenTableContent(data)
{
    var cssBgFlag = true;
    var cssBgStyle;

    for(var i = 0; i < data.result.length; i++)
    {
        if(cssBgFlag) { cssBgStyle = 'dark'; } else { cssBgStyle = 'light'; }

        var newDiv = $('<div></div>', {
            "class": cssBgStyle,
            html: data.result[i].filtername,
            click: function(e){
                e.preventDefault();
                alert("test");
            }});
        newDiv.appendTo('#kennzahlen');

        cssBgFlag = !cssBgFlag;
    }
}*/