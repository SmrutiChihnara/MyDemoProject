<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Order Method</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Order Method Page</h2>
	<form:form action="update" method="POST" modelAttribute="ordermethod">
		<pre>
ID:<form:input path="orderId" readonly="true" />		
Order Mode:<form:radiobutton path="orderMode" value="Sale" />Sale  <form:radiobutton
				path="orderMode" value="Purchase" />Purchase
Order Code:<form:input path="orderCode" />
Order Method:<form:select path="orderMethod">
			 <form:option value="">--SELECT--</form:option>
			 <form:option value="FIFO">FIFO</form:option>
			 <form:option value="LIFO">LIFO</form:option>
			 <form:option value="FCFO">FCFO</form:option>
			 <form:option value="FEFO">FEFO</form:option>
			 </form:select>
Order Accept:<form:checkbox path="orderAccept" value="Multi-Model" />Multi-Model
		     <form:checkbox path="orderAccept" value="Accept Return" />Accept Return
Description:<form:textarea path="dsc" />
<input type="submit" value="Update">
</pre>
	</form:form>
	${message }
</body>
</html>