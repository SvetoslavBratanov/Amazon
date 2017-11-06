
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<title>Create new product</title>
<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/css/css/styless.css" --%>
<!-- 	type="text/css"></link> -->
</head>
<body>
	<%-- 	<c:if --%>
	<%-- 		test="${ sessionScope.user == null || sessionScope.user.isAdmin == false}"> --%>
	<%-- 		<c:redirect url="login"></c:redirect> --%>
	<%-- 	</c:if> --%>

	<div>
		<fieldset>
			<legend class="legend">Create product</legend>
			<form action="/addProduct" method="post" method="post">
				<table>
					<tbody>
						<tr style="background: white;">
							<td><label for="productName">Product name:</label></td>
							<td><input id="productName" name="productName" type="text"
								minlength="3" required /></td>
						<tr style="background: white;">
							<td><label for="description">Description:</label></td>
							<td><input id="description" name="description" type="text"
								minlength="5" required /></td>
						</tr>
						<tr style="background: white;">
							<td><label for="price">Price:</label></td>
							<td><input id="price" name="price" type="text" step="0.01"
								min="0" /></td>
						</tr>
						<tr style="background: white;">
							<td><label for="quantity">Quantity:</label></td>
							<td><input id="quantity" name="quantity" type="text" min="1" /></td>
						<tr style="background: white;">
							<td><label for="poster">Poster:</label></td>
							<td><input type="file" name="poster"> 
						</tr>
						<tr style="background: white;">
							<td><label for="categoryId">Category id:</label></td>
							<td><input id="categoryId" name="categoryId" type="text"
								min="1" /></td>
							</form>
					</tbody>
				</table>
				<p>
					<input type="submit" value=" Create product " />
				</p>
			</form>
			<p>
				<a href="${pageContext.request.contextPath}/index">Home</a>
			</p>
		</fieldset>
	</div>
</body>
</html>
