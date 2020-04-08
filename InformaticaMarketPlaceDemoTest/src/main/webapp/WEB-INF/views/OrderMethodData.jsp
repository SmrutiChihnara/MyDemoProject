<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Data</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="card">
	
	<!-- card header start -->
	<div class="card-header bg-info text-white">
	<h2>Welcome to Order Method Data Page</h2>
	</div>
	
	<!-- card body start -->
	<div class="card-body">
	<c:choose>
	<c:when test="${!empty list}">
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>MODE</th>
			<th>CODE</th>
			<th>METHOD</th>
			<th>ACCEPT</th>
			<th>DESCRIPTION</th>
			<th>OPERATION</th>
		</tr>
		<c:forEach items="${list}" var="om">
			<tr>
				<td><c:out value="${om.orderId}" /></td>
				<td><c:out value="${om.orderMode}" /></td>
				<td><c:out value="${om.orderCode}" /></td>
				<td><c:out value="${om.orderMethod}" /></td>
				<td><c:out value="${om.orderAccept}" /></td>
				<td><c:out value="${om.dsc}"/></td>
				<td><a href="delete?id=${om.orderId}" class="btn btn-danger">DELETE</a></td>
				<td><a href="edit?id=${om.orderId}" class="btn btn-danger">EDIT</a></td>
			</tr>
		</c:forEach>
				<a href="excel">Excel Export</a> | <a href="pdf">PDF Export</a>
	</table>
	</c:when>
	<c:otherwise>
	<div class="text-info">No Data Found in Database</div>
	</c:otherwise>
	</c:choose>
	</div> <!-- end of card body -->
	
	<!-- card footer start -->
	<c:if test="${message ne null}">
	<div class="card-footer bg-warning">${message}</div>
	</c:if>
	
	</div> <!-- end of card -->
	</div> <!-- end of container -->
</body>
</html>