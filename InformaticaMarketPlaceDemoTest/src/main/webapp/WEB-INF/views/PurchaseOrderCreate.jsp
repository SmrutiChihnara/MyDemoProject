<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseOrder Create</title>
<style type="text/css">
.err{
	color: purple;
}
</style>
</head>
<body style="font-family: consolas;font-size: 20px;color: red;text-align: center;">
<h2>Welcome to Purchase Order Create Page</h2>
<form:form action="insert" method="POST" modelAttribute="po">
<pre>
Order Code:<form:input path="orderCode"/>
		<form:errors path="orderCode" cssClass="err"/>
Shipment Code:<form:select path="shipmentcode.shipmentTypeId">
			  <form:option value="">--SELECT--</form:option>	
			  <form:options items="${sTypes}" itemLabel="shipmentTypeCode" itemValue="shipmentTypeId"/>
			  </form:select>
<form:errors path="shipmentcode" cssClass="err"/>
Vendor:<form:select path="vendor.userId">
		<form:option value="">--SELECT--</form:option>
		<form:options items="${userTypes}" itemLabel="userType" itemValue="userId"/>
	   </form:select>
	   		<form:errors path="vendor" cssClass="err"/>			  
Reference Number:<form:input path="referenceNo"/>
		    <form:errors path="referenceNo" cssClass="err"/>
Quality Check:<form:radiobutton path="qualityCheck" value="Required"/>Required  <form:radiobutton path="qualityCheck" value="Not Required"/>Not Required
	<form:errors path="qualityCheck" cssClass="err"/>
Default Status:<form:input path="defaultStatus" value="OPEN" readonly="true"/>
Description:<form:textarea path="dsc"/>
		 <form:errors path="dsc" cssClass="err"/>
<input type="submit" value="Create PurchaseOrder">
</pre>
</form:form>
${message}
</body>
</html>