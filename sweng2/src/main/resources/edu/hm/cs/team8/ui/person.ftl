<#-- @ftlvariable name="" type="com.example.views.PersonView" -->
<html>
    <body>
        <!-- calls getPerson().getName() and sanitizes it -->
        <h1>HALLO</h1>
        <#list person.name as i>${i} </#list>  
    </body>
</html>