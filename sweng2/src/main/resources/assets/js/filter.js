$(document).ready(function () {
    var winMitarbeiterfilter = $("#mitarbeiterfilter-window").kendoWindow({
        title: "Mitarbeiterfilter",
        visible: false
    }).data("kendoWindow");

    var winBereichsfilter = $("#bereichsfilter-window").kendoWindow({
        title: "Bereichsfilter",
        visible: false
    }).data("kendoWindow");

    var winZeitfilter = $("#zeitfilter-window").kendoWindow({
        title: "Zeitfilter",
        visible: false
    }).data("kendoWindow");

    var windSubmit = $("#filter-window").kendoWindow({
        title: "Result",
        visible: false
    }).data("kendoWindow");
});

$("#mitarbeiterfilter-type").kendoDropDownList();
$("#mitarbeiterfilter-selector").kendoDropDownList();
$("#mitarbeiterfilter-submit").click(function (e) {
    $("#mitarbeiterfilter-window").data("kendoWindow").close();

    // selected option value of the select / input value
    var mitarbeiterfilterType = $("#mitarbeiterfilter-type").val();
    var mitarbeiterfilterSelector = "ist gleich"; //$("#mitarbeiterfilter-selector").val();
    var mitarbeiterfilterValue = $("#mitarbeiterfilter-value").val();

    $('#filter-table').data('kendoGrid').dataSource.add({
        name: mitarbeiterfilterType,
        selector: mitarbeiterfilterSelector,
        value: mitarbeiterfilterValue
    });
});

$("#bereichsfilter-type").kendoDropDownList();
$("#bereichsfilter-selector").kendoDropDownList();
$("#bereichsfilter-submit").click(function (e) {
    $("#bereichsfilter-window").data("kendoWindow").close();

    // selected option value of the select / input value
    var bereichsfilterType = $("#bereichsfilter-type").val();
    var bereichsfilterSelector = "ist gleich"; //$("#bereichsfilter-selector").val();
    var bereichsfilterValue = $("#bereichsfilter-value").val();

    $('#filter-table').data('kendoGrid').dataSource.add({
        name: bereichsfilterType,
        selector: bereichsfilterSelector,
        value: bereichsfilterValue
    });
});

$("#zeitfilter-type").kendoDropDownList();
$("#zeitfilter-submit").click(function (e) {
    $("#zeitfilter-window").data("kendoWindow").close();

    // selected option value of the select / input value
    var zeitfilterStart = $("#zeitfilter-start").val();
    /*var zeitfilterEnd = $("#zeitfilter-end").val();
    var zeitfilterSelector = "von / bis";*/
    var zeitfilterValue = zeitfilterStart; //+' bis '+zeitfilterEnd;
    var addData = true;
    /*if(zeitfilterStart.length == 0 && zeitfilterEnd.length != 0)
    {
        zeitfilterSelector = "bis";
        zeitfilterValue = zeitfilterEnd;

    }
    else if(zeitfilterStart.length != 0 && zeitfilterEnd.length == 0)
    {
        zeitfilterSelector = "von";
        zeitfilterValue = zeitfilterStart;
    }
    else if(zeitfilterStart.length == 0 && zeitfilterEnd == 0)
    {
        zeitfilterValue = '';
        addData = false;
    }*/
    if (addData) {
        $('#filter-table').data('kendoGrid').dataSource.add({
            name: "Zeitpunkt",
            selector: 'ist', //zeitfilterSelector,
            value: zeitfilterValue
        });
    }
});

$("#mitarbeiterfilter").click(function () {
    var win = $("#mitarbeiterfilter-window").data("kendoWindow");

    $("#bereichsfilter-window").data("kendoWindow").close();
    $("#zeitfilter-window").data("kendoWindow").close();

    win.center();
    win.open();
});

$("#bereichsfilter").click(function () {
    var win = $("#bereichsfilter-window").data("kendoWindow");

    $("#mitarbeiterfilter-window").data("kendoWindow").close();
    $("#zeitfilter-window").data("kendoWindow").close();

    win.center();
    win.open();
});

$("#zeitfilter").click(function () {
    var win = $("#zeitfilter-window").data("kendoWindow");

    $("#bereichsfilter-window").data("kendoWindow").close();
    $("#mitarbeiterfilter-window").data("kendoWindow").close();

    win.center();
    win.open();
});

$("#filter-submit").click(function () {
    var win = $("#filter-window").data("kendoWindow");
    win.center();
    win.open();
});

$(document).ready(function () {
    /*function startChange() {
        var startDate = start.value(),
            endDate = end.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate());
            end.min(startDate);
        } else if (endDate) {
            start.max(new Date(endDate));
        } else {
            endDate = new Date();
            start.max(endDate);
            end.min(endDate);
        }
    }

    function endChange() {
        var endDate = end.value(),
            startDate = start.value();

        if (endDate) {
            endDate = new Date(endDate);
            endDate.setDate(endDate.getDate());
            start.max(endDate);
        } else if (startDate) {
            end.min(new Date(startDate));
        } else {
            endDate = new Date();
            start.max(endDate);
            end.min(endDate);
        }
    }*/

    var start = $("#zeitfilter-start").kendoDatePicker({
        /*change: startChange,*/
        format: "MM.yyyy"
    }).data("kendoDatePicker");
    /*)
    var end = $("#zeitfilter-end").kendoDatePicker({
        change: endChange,
        format: "MM.yyyy"
    }).data("kendoDatePicker");

    start.max(end.value());
    end.min(start.value());*/


    $.getJSON("js/filterdata.json", function (jsonFilterData) {
        setTableContent(jsonFilterData);
    });

    function setTableContent(jsonFilterData) {
        $("#filter-table").kendoGrid({
            /*dataSource: {
                //data: createRandomData(50)
                data: jsonFilterData['result']
            },*/
            groupable: false,
            sortable: true,

            columns: [{
                field: "name",
                width: 110,
                title: "Name"
            }, {
                field: "selector",
                width: 130,
                title: "Bedingung"
            }, {
                width: 120,
                field: "value",
                title: "Wert"
            }]
        });
    }

    //changes the text of the "And" and "Or" of the filter menu
    $("select[name='logic']").each(function () {
        //changes the dataSource of the "And/Or" dropdown
        $(this).data("kendoDropDownList").dataSource.data([{
                text: "CustomAnd",
                value: "and"
            }, //sets the text of the "And" option
            {
                text: "CustomOr",
                value: "or"
            } //sets the text of the "Or" option
        ]);
        //sets the default selected list option
        $(this).data("kendoDropDownList").select(0);
    });
});