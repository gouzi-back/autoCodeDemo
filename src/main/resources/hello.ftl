<html xmlns="http://www.w3.org/1999/html">
<head>

</head>
<body>
hello ${name}
</br>
你好 ${user.username}
</br>
<#list userList as item>
<#-- if条件判断-->
<#--  <#if item.username!='zzzz' >-->
<#--      ${item.username}-->

<#--  </#if>-->

<#-- if条件判断接下来是否还有元素_has_next-->
  <#if item_has_next >
      ${item.username},
  <#else >
      ${item.username}
  </#if>


</#list>

</body>

</html>