<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Order</title>
<style type="text/css">
.err{
	color: purple;
}
</style>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Order Method Page</h2>
	<form:form action="insert" method="POST" modelAttribute="ordermethod">
		<pre>
Order Mode:<form:radiobutton path="orderMode" value="Sale"/>Sale  <form:radiobutton
				path="orderMode" value="Purchase"/>Purchase
	<form:errors path="orderMode" cssClass="err"/>
Order Code:<form:input path="orderCode"/>
		<form:errors path="orderCode" cssClass="err"/>
Order Method:<form:select path="orderMethod">
			 <form:option value="">--SELECT--</form:option>
			 <form:option value="FIFO">FIFO</form:option>
			 <form:option value="LIFO">LIFO</form:option>
			 <form:option value="FCFO">FCFO</form:option>
			 <form:option value="FEFO">FEFO</form:option>
			 </form:select>
		<form:errors path="orderMethod" cssClass="err"/>
Order Accept:<form:checkbox path="orderAccept" value="Multi-Model" />Multi-Model
	       <form:checkbox path="orderAccept" value="Accept Return" />Accept Return
		  <form:errors path="orderAccept" cssClass="err"/>
Description:<form:textarea path="dsc" />
		<form:errors path="dsc" cssClass="err"/>
<input type="submit" value="Create Order Method">
</pre>
	</form:form>
	${message }
</body>
</html>