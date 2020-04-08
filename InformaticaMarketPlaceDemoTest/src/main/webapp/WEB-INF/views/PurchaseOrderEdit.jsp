<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseOrder Edit</title>
</head>
<body style="font-family: consolas;font-size: 20px;color: red;text-align: center;">
<h2>Welcome to Purchase Order Create Page</h2>
<form:form action="update" method="POST" modelAttribute="po">
<pre>
ID:<form:input path="poId" readonly="true"/>
Order Code:<form:input path="orderCode"/>
Reference Number:<form:input path="referenceNo"/>
Quality Check:<form:radiobutton path="qualityCheck" value="Required"/>Required  <form:radiobutton path="qualityCheck" value="Not Required"/>Not Required
Default Status:<form:input path="defaultStatus" value="OPEN" readonly="true"/>
Description:<form:textarea path="dsc"/>
<input type="submit" value="Update">
</pre>
</form:form>
${message}
</body>
</html>