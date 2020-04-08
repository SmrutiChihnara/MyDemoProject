<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Edit</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Wh User Edit Page</h2>
	<form:form action="update" method="POST" modelAttribute="whuser">
		<pre>
ID:<form:input path="userId" readonly="true"/>		
User Type:<form:radiobutton path="userType" value="Vendor" />Vendor  <form:radiobutton path ="userType" value="Customer" />Customer  
User Code:<form:input path="userCode" />
User For:<form:select path="forType">
		 <form:option value="">--SELECT--</form:option>
		 <form:option value="Purchase">Purchsae</form:option>
		 <form:option value="Sale">Sale</form:option>
		 </form:select>
User Email:<form:input path="userEmail" />
User Contact:<form:input path="usercontact" />
User ID type:<form:select path="idType">
			 <form:option value="">--SELECT--</form:option>
			 <form:option value="PanCard">PANCARD</form:option>
			 <form:option value="Aadhar">AADHAR</form:option>
			 <form:option value="VoterId">VOTER ID</form:option>
			 <form:option value="Other">OTHER</form:option>
			 </form:select>
*If Other:<form:input path="ifOther" />
ID Number:<form:input path="idNum" />
			<input type="submit" value="Update">			 		 
</pre>

	</form:form>
	${message }
</body>
</html>