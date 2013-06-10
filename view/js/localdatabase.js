/**
 * Creates a new local database if its not available, otherwise open it.
 */
function initDatabase()
{
    try
    {
        if (!window.openDatabase)
        {
            alert('Databases are not supported in this browser.');
        }
        else
        {
            var shortName = 'DEMODB';
            var version = '1.0';
            var displayName = 'DEMO Database';
            var maxSize = 100000; //  bytes
            DEMODB = openDatabase(shortName, version, displayName, maxSize);
            createTables();
            //selectAll();
            selectAllFilterNames();
        }
    }
    catch(e)
    {
        if (e == 2)
            // Version number mismatch.
            console.log("Invalid database version.");
        else
            console.log("Unknown error "+e+".");
        return;
    }
}

function createTables()
{
    DEMODB.transaction(
        function (transaction)
        {
            transaction.executeSql('CREATE TABLE IF NOT EXISTS filter(id INTEGER NOT NULL PRIMARY KEY, filtername TEXT NOT NULL,name TEXT NOT NULL, selector TEXT NOT NULL, value TEXT NOT NULL);', [], nullDataHandler, errorHandler);
            console.log("Creating new tables done.");
        }
    );
    //prePopulate();
}

function prePopulate()
{
    /*DEMODB.transaction(
        function (transaction) {
            //Optional Starter Data when page is initialized
            var data = ['1','none','#B3B4EF','Helvetica','Porsche 911 GT3'];
            transaction.executeSql("INSERT INTO page_settings(id, fname, bgcolor, font, favcar) VALUES (?, ?, ?, ?, ?)", [data[0], data[1], data[2], data[3], data[4]]);
            console.log("insert done");
        }
    );*/
}

function selectAllFilterNames()
{
    DEMODB.transaction(
        function (transaction) {
            transaction.executeSql("SELECT DISTINCT filtername FROM filter;", [],
                selectAllFilterNamesHandler, errorHandler);
        }
    );
    //SELECT * FROM filter GROUP BY filtername
}

function selectAll()
{
    DEMODB.transaction(
        function (transaction) {
            transaction.executeSql("SELECT * FROM filter;", [],
                dataSelectHandler, errorHandler);
        }
    );
}

function selectAllFilterNamesHandler(transaction, results)
{
    // Handle the results
    displayFilterNames(results);
}

function displayFilterNames(data)
{
    var cssBgFlag = true;
    var cssBgStyle;

    for(var i=0; i<data.rows.length; i++)
    {
        var row = data.rows.item(i);
        if(cssBgFlag) { cssBgStyle = 'dark'; } else { cssBgStyle = 'light'; }

        var newDiv = $('<div></div>', {
            "id": 'filter'+i,
            "class": cssBgStyle,
            html: row.filtername,
            click: function(e){
                e.preventDefault();
                var filtername = e.target.textContent;
                //displayChartsByFiltername(filtername);
                connectToChartsPage(encodeURIComponent(filtername));
            }});
        newDiv.appendTo('#kennzahlen');

        cssBgFlag = !cssBgFlag;
    }
}

function connectToChartsPage(filtername)
{
    window.location = "diagramme.html?filtername="+filtername;
}

function displayChartsByFiltername(filtername)
{
    DEMODB.transaction(
        function (transaction) {
            transaction.executeSql("SELECT * FROM filter WHERE filtername = '"+filtername+"';", [],
                displayChartsHandler, errorHandler);
        }
    );
}

function displayChartsHandler(transaction, results)
{
    // Checking, if filter rules are available
    if(results.rows.length > 0)
    {
        var data = new Object();
        for (var i=0; i<results.rows.length; i++) {

            data[i] = results.rows.item(i);
        }
        // convert JS object to JSON string by json2.js plugin
        data = JSON.stringify(data);
        createPostForDisplay(data);
        console.log(data);
    }
}

function createPostForDisplay(jsonData)
{
    var form, inputForJSON;
    // Start by creating a <form>
    form = document.createElement('form');
    form.action = 'diagramme.html';
    form.method = 'post';
    // Next create the <input>s in the form and give them names and values
    inputForJSON = document.createElement('input');
    inputForJSON.type = 'hidden';
    inputForJSON.name = 'json';
    inputForJSON.value = jsonData;
    // Now put everything together...
    form.appendChild(inputForJSON);
    // ...and it to the DOM...
    document.getElementById('json-form-container').appendChild(form);
    // ...and submit it
    form.submit();
}

function dataSelectHandler(transaction, results)
{


    console.log("rowlength: "+results.rows.length);

    // Handle the results
    for (var i=0; i<results.rows.length; i++) {

        var row = results.rows.item(i);
        console.log("datensatz: ");
        console.log(row);
    }

}

/*issetFiltername({
    read: function(filtername) {

        DEMODB.transaction(function(tx) {

            tx.executeSql("SELECT * FROM filter WHERE filtername = " + filtername +";", [], function(tx, result) {

                var data = [];
                // copy the rows to a regular array
                for (var i = 0; i < result.rows.length; i++) {
                    data[i] = result.rows.item(i);
                }
                return data.length;
                //options.success(data); // return the data back to the data source
            });
        });
    }
});*/
function issetFiltername(filtername_original, filtername, counter, insertData)
{
    //console.log(counter);
    DEMODB.transaction(
        function (transaction) {
            //counter++;

            transaction.arguments = new Array(filtername_original, filtername, counter, insertData);

            transaction.executeSql(

                "SELECT * FROM filter WHERE filtername = '" + filtername +"';",
                [],
                insertDataHandler,
                errorHandler
            );
        }
    );
}

function insertDataHandler(transaction, data)
{
    var insertData = transaction.arguments[3];
    if(data.rows.length != 0)
    {
        var counter = transaction.arguments[2];
        counter++;
        var filtername_original = transaction.arguments[0];
        var filtername = filtername_original + ' (' + counter + ')';

        issetFiltername(filtername_original,filtername, counter, insertData);
    }
    else
    {
        insertData['0']['filtername'] = transaction.arguments[1];
        insertFilter(insertData);
    }
}

function insertFilter(filter)
{
    var lastFilter = filter.length - 1; // last element
    var lastFlag = false;
    for(var i = 0; i < filter.length; i++)
    {
        if (i == lastFilter)
            lastFlag = true;
        insertRule(filter['0']['filtername'],filter[i]['name'],filter[i]['selector'],filter[i]['value'], lastFlag);
    }
}

function insertRule(filtername, name, selector, value, last)
{
    DEMODB.transaction(
        function (transaction) {
            transaction.executeSql("INSERT INTO filter(filtername, name, selector, value) VALUES (?, ?, ?, ?)", [filtername, name, selector, value]);
            if(last)
                window.location = "kennzahlen.html";
        }
    );
}

function nullDataHandler()
{
    console.log("Keine Daten zum verarbeiten in der Datenbank. (null data)");
}

function errorHandler()
{
    console.log("Datenbank Input/Output Fehler. (db error)");
}