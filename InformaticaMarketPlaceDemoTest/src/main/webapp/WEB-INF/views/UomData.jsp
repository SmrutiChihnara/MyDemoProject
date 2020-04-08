<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
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

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>WELCOME TO UOM DATA PAGE</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>MODEL</th>
								<th>DESCRIPTION</th>
								<th>OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="uom">
								<tr>
									<td><c:out value="${uom.uomId}" /></td>
									<td><c:out value="${uom.uomType}" /></td>
									<td><c:out value="${uom.uomModel}" /></td>
									<td><c:out value="${uom.dsc}" /></td>
									<td><a href="delete?id=${uom.uomId}" class="btn btn-danger">DELETE</a></td>
									<td><a href="edit?id=${uom.uomId}" class="btn btn-danger">EDIT</a></td>
								</tr>
							</c:forEach>
							<a href="excel">Excel Export</a> | <a href="pdf">PDF Export</a>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!-- card body end -->
			</div>


			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>


			<!-- card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</html>



