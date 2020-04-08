<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Create</title>
<style type="text/css">
.err{
	color: purple;
}
</style>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Uom Create Page</h2>
	<form:form action="insert" method="POST" modelAttribute="uom">
		<pre>
Uom Type:<form:select path="uomType">
		 <form:option value="">--SELECT--</form:option>
		 <form:option value="PACKAGING">PACKAGING</form:option>
		 <form:option value="No PACKAGING">NO PACKAGING</form:option>
		 <form:option value="NA">--NA--</form:option>
		 </form:select>
		 <form:errors path="uomType" cssClass="err"/>
Uom Model:<form:input path="uomModel" />
		  <form:errors path="uomModel" cssClass="err"/>
Description:<form:textarea path="dsc" />
		    <form:errors path="dsc" cssClass="err"/>
			<input type="submit" value="Create Uom">		 		 

</pre>

	</form:form>
	${message}
</body>
</html>