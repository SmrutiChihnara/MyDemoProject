<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
<h2>Welcome to Item Register Page!!</h2>
<form:form action="update" method="post" modelAttribute="item">
<pre>
Item Id   : <form:input path="id" readonly="true"/>
Item Code : <form:input path="itemCode"/>
Item Dimensions : W <form:input path="itemWdth" size="5"/> L <form:input path="itemLen" size="5"/> H <form:input path="itemHght" size="5"/>
Base Cost : <form:input path="baseCost"/>
Base Currency : <form:select path="baseCurrecy">
					<form:option value="">--SELECT--</form:option>
					<form:option value="INR">INR</form:option>
					<form:option value="USD">USD</form:option>
					<form:option value="AUD">AUD</form:option>
				</form:select>
				
Item Uom : <form:select path="uom.uomId">
				<form:option value="">-SELECT-</form:option>
				<form:options items="${uoms}" itemLabel="uomModel" itemValue="uomId"/>
			</form:select>	
Item Order Method:(Sale Type)
           <form:select path="saleType.orderId">
           	<form:option value="">-SELECT-</form:option>
           	<form:options items="${sales}" itemLabel="orderCode" itemValue="orderId"/>
           </form:select>
     Order Method:(Purchase Type)           
           				<form:select path="purchaseType.orderId">
           	<form:option value="">-SELECT-</form:option>
           	<form:options items="${purchases}" itemLabel="orderCode" itemValue="orderId"/>
           </form:select>						
Item Vendors:
<form:select path="venUsers" >
	<form:options items="${vendors}" itemLabel="userCode" itemValue="userId"/>
</form:select>

Item Customers:
<form:select path="custUsers">
	<form:options items="${customers}" itemLabel="userCode" itemValue="userId"/>
</form:select>

Description : <form:textarea path="itemDsc"/>	
				<input type="submit" value="Update"/>			
</pre>
</form:form>
${message}
</body>
</html>