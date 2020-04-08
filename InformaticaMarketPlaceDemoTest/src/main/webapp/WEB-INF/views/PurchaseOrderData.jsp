<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseOrder Data</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; color: red; text-align: center;">
	<h2>Welcome to Purchase Order Data Page</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>REF NUMBER</th>
			<th>QUALITY CHECK</th>
			<th>DEFAULT STATUS</th>
			<th>DESCRIPTION</th>
			<th>OPREATION</th>
		</tr>
		<c:forEach items="${list}" var="po">
			<tr>
				<td><c:out value="${po.poId}" /></td>
				<td><c:out value="${po.orderCode}" /></td>
				<td><c:out value="${po.referenceNo}" /></td>
				<td><c:out value="${po.qualityCheck}" /></td>
				<td><c:out value="${po.defaultStatus}" /></td>
				<td><c:out value="${po.dsc}" /></td>
				<td><a href="delete?id=${po.poId}">DELETE</a></td>
				<td><a href="edit?id=${po.poId}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>