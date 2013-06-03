{
<#list accounts as account>
	{
	"accountname":"${account.name}",
	"projectname":"${account.project.name}"
	},
</#list>  
}