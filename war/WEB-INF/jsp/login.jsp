<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="WARNING" value="${warning}"/>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
  <h1><fmt:message key="welcome"/></h1> 
  <table>
  <tr>
  <c:if test="${!empty WARNING}">
    	<td>
    	<font color="red"><c:out value="${WARNING}"/></font>
    	</td>
    	</c:if>	
  </tr>
  </table>
  <form:form method="post" commandName="loginInfo">
    <table>
   <tr>
    	<td>
    	<fmt:message key="username"/>:
    	</td>
    	<td>
    	<form:input path="userName" size="20"/>
    	</td>
    	<td>
    	<form:errors path="userName" cssClass="error"/>
    	</td>
    </tr>
    <tr>
    	<td>
    	<fmt:message key="password"/>:
    	</td>
    	<td>
    	<form:input path="password" size="20"/>
    	</td>
    	<td>
    	<form:errors path="password" cssClass="error"/>
    	</td>
    </tr>
    <tr>
    	<td>
    	<fmt:message key="validation"/>:	
    	</td>
    	<td>
    	<form:input path="validationCode" size="20" onkeydown="loginSubmit()"/>
    	</td>
    	<td>
    	    <img src="getcaptcha.sl" alt="验证码" name="checkImg" id="checkImg" style="position:relative; top:5px; left:20px; " onClick="document.getElementById('checkImg').src='getcaptcha.sl?temp='+ (new Date().getTime().toString(36)); return false"/>  
		</td>    
    </tr>
    <tr>
    <td>
    <input type="submit" align="center" value="Login"/>
    </td>
    </tr>
    </table>
  </form:form>
  </body>
</html>
<script language="javascript">
function checkIfNull(){
	
}
function loginSubmit(){
	if(event.Keycode==13)
	{
	  document.form.submit();
	}
}
</script>