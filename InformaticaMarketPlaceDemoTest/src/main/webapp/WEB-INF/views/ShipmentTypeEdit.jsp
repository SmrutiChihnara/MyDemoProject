<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Type Edit</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Edit Shipment Type Page</h2>
	<form:form action="update" method="POST" modelAttribute="sType">
		<pre>
ID:<form:input path="shipmentTypeId" readonly="true"/>		
Shipment Mode:<form:select path="shipmentTypeMode">
				<form:option value="">--SELECT--</form:option>
				<form:option value="Air">Air</form:option>
				<form:option value="Truck">Truck</form:option>
			    <form:option value="Ship">Ship</form:option>
				<form:option value="Train">Train</form:option>
				</form:select>
Shipment Code:<form:input path="shipmentTypeCode" />
Enable Shipment:<form:checkbox path="enableShipment" value="Yes" />Yes
Shipment Grade:<form:radiobutton path="grade" value="A" />A  <form:radiobutton
				path="grade" value="B" />B  <form:radiobutton path="grade"
				value="C" />C				
Description:<form:textarea path="dsc" />
			<input type="submit" value="Update">

</pre>
	</form:form>
	${message }
</body>
</html>