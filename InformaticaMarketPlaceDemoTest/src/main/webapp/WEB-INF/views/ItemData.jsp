<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Data</title>
</head>
<body style="font-family: consolas;font-size: 20px;color: red;text-align: center;">
<h2>Welcome to Item Data Page</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>CODE</th>
		<th>DIMENSIONS</th>
		<th>COST</th>
		<th>CURRENCY</th>
		<th>UOM </th>
		<th>SALE</th>
		<th>PURCHASE</th>
		<th>VENDORS</th>
		<th>CUSTOMERS</th>
		<th>DESCRIPTION</th>
		<th colspan="2">OPERATIONS</th>
	</tr>
	<c:forEach items="${items}" var="itm">
		<tr>
			<td><c:out value="${itm.id}"/> </td>
			<td><c:out value="${itm.itemCode}"/> </td>
			<td>W: <c:out value="${itm.itemWdth}"/>, 
			L: <c:out value="${itm.itemLen}"/>, 
			H: <c:out value="${itm.itemHght}"/> </td>
			<td><c:out value="${itm.baseCost}"/> </td>
			<td><c:out value="${itm.baseCurrecy}"/> </td>
			<td><c:out value="${itm.uom.uomModel}"/> </td>
			<td><c:out value="${itm.saleType.orderCode}"/> </td>
			<td><c:out value="${itm.purchaseType.orderCode}"/> </td>
			<td>
			<c:forEach items="${itm.venUsers}" var="ven">
				<c:out value="${ven.userCode}"/>,
			</c:forEach>
			</td>
			<td>
			<c:forEach items="${itm.custUsers}" var="cust">
				<c:out value="${cust.userCode}"/>,
			</c:forEach>
			</td>
			<td><c:out value="${itm.itemDsc}"/> </td>
			<td>
				<a href="delete?id=${itm.id}">DELETE</a>
			</td>
			<td>
				<a href="edit?id=${itm.id}">EDIT</a>
			</td>
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>



