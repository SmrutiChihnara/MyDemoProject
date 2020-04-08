<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
<style type="text/css">
.err{
	color: purple;
}
</style>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Wh User Create Page</h2>
	<form:form action="insert" method="POST" modelAttribute="userType">
		<pre>
User Type:<form:radiobutton path="userType" value="Vendor" />Vendor  <form:radiobutton
				path="userType" value="Customer" />Customer 
	<form:errors path="userType" cssClass="err"/>	 
User Code:<form:input path="userCode" />
	<form:errors path="userCode" cssClass="err"/>
User For:<form:select path="forType">
		 <form:option value="">--SELECT--</form:option>
		 <form:option value="Purchase">Purchase</form:option>
		 <form:option value="Sale">Sale</form:option>
		 </form:select>
	<form:errors path="forType" cssClass="err"/>
User Email:<form:input path="userEmail" />
	<form:errors path="userEmail" cssClass="err"/>
User Contact:<form:input path="usercontact" />
	<form:errors path="usercontact" cssClass="err"/>
User ID type:<form:select path="idType">
			 <form:option value="">--SELECT--</form:option>
			 <form:option value="PanCard">PANCARD</form:option>
			 <form:option value="Aadhar">AADHAR</form:option>
			 <form:option value="VoterId">VOTER ID</form:option>
			 <form:option value="Other">OTHER</form:option>
			 </form:select>
	<form:errors path="idType" cssClass="err"/> 
*If Other:<form:input path="ifOther" />
<%-- <form:errors path="ifOther" cssClass="err"/> --%>
ID Number:<form:input path="idNum" />
<form:errors path="idNum" cssClass="err"/>
					<input type="submit" value="Create User">			 		 
</pre>

	</form:form>
	${message }
</body>
</html>