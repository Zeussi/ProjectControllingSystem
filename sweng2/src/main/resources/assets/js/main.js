$(document).ready(function(){
    kendo.culture("de-DE");
});

$(document).ready(function() {
    $("#files").kendoUpload();
});

$(document).ready(function() {
    $("#tabstrip").kendoTabStrip({
        animation:  {
            open: {
                effects: "fadeIn"
            }
        }
    });
});

/*$(document).ready(function() {
 var window = $("#window"),
 undo = $("#import")
 .bind("click", function() {
 window.data("kendoWindow").open();
 //undo.hide();
 });

 var onClose = function() {
 undo.show();
 }

 if (!window.data("kendoWindow")) {
 window.kendoWindow({
 width: "600px",
 title: "Datei importieren",
 close: onClose
 });
 }
 });*/

$(document).ready(function(){
    var winImport = $("#window").kendoWindow({
        title: "Datei importieren",
        visible: false
    }).data("kendoWindow");
});

$("#import").click(function(){
    var win = $("#window").data("kendoWindow");
    win.center();
    win.open();
});

$(document).ready(function() {
    $("#vertical").kendoSplitter({
        orientation: "vertical",
        panes: [
            { collapsible: false }
        ]
    });

    $("#horizontal").kendoSplitter({
        panes: [
            { collapsible: true, size: "220px" },
            { collapsible: false }
        ]
    });
});