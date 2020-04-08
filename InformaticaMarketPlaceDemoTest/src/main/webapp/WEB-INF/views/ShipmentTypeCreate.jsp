<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Shipment Type</title>
<style type="text/css">
.err{
	color: purple;
}
</style>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Create Shipment Type Page</h2>
	<form:form action="insert" method="POST" modelAttribute="sType">
		<pre>
Shipment Mode:<form:select path="shipmentTypeMode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="Air">Air</form:option>
				<form:option value="Truck">Truck</form:option>
			    <form:option value="Ship">Ship</form:option>
				<form:option value="Train">Train</form:option>
				</form:select>
		<form:errors path="shipmentTypeMode" cssClass="err"/>
Shipment Code:<form:input path="shipmentTypeCode" />
		 <form:errors path="shipmentTypeCode" cssClass="err"/>
Enable Shipment:<form:checkbox path="enableShipment" value="Yes" />Yes
		<form:errors path="enableShipment" cssClass="err"/>
	Shipment Grade:<form:radiobutton path="grade" value="A" />A  <form:radiobutton
				path="grade" value="B" />B  <form:radiobutton path="grade"
				value="C" />C
					<form:errors path="grade" cssClass="err"/>					
Description:<form:textarea path="dsc" />
		 <form:errors path="dsc" cssClass="err"/>
	<input type="submit" value="Create Shipment">

</pre>
	</form:form>
	${message }
</body>
</html>