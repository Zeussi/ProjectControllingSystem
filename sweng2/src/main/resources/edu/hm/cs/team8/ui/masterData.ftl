<#-- @ftlvariable name="" type="com.example.views.PersonView" -->
<html>
    <body>
        <!-- calls getPerson().getName() and sanitizes it -->
        
        <h1>Master-Data</h1>
        
        <table border="1">
        <tr>
        <th>Members</th>
        </tr>
	        <#list members as member>
	        	<tr>
	        		<td>${member.name}</td>
	        	</tr>
	        </#list>  
        </table>
        
        <table border="1">
        <tr>
        <th>Accounts</th>
        <th>Business Area</th>
        </tr>
	        <#list accounts as account>
	        	<tr>
	        		<td>${account.name}</td>
	        		<td>${account.project.name}</td>
	        	</tr>
	        </#list>  
        </table>
        
    </body>
</html>