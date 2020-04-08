<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Uom</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Uom Page</h2>
	<form:form action="update" method="POST" modelAttribute="uom">
		<pre>
ID:<form:input path="uomId" readonly="true" />		
Uom Type:<form:select path="uomType">
		 <form:option value="">--SELECT--</form:option>
		 <form:option value="PACKAGING">PACKAGING</form:option>
		 <form:option value="No PACKAGING">NO PACKAGING</form:option>
		 <form:option value="NA">--NA--</form:option>
		 </form:select>
Uom Model:<form:input path="uomModel" />
Description:<form:textarea path="dsc" />
			<input type="submit" value="Update">		 		 

</pre>

	</form:form>
	${message}
</body>
</html>