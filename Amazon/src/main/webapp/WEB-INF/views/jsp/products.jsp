<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<link href= "<c:url value="/resources/static/css/products.css"/>" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
<form action="productsByPrice" method = get >
<table style="width:20%"  style="width:30%">
  <tr>
    <th>from</th> 
    <th>to</th>
  </tr>
  <tr>
    <td>Price</td>
    <td><input type="text" name="from" ></td>
    <td><input type="text" name="to" ></td>
		<input type="submit" value="Send">
    
  </tr>
</table>
<c:if test="${not empty errorMessage}">
			<h1>
<c:out value="${errorMessage}"  />
			</h1>

</c:if>
</form>
  	<c:if test="${not empty products}">
  		<ul>
  			<c:forEach var="product" items="${products}">
  				
  			<img src="<c:url value="${product.poster}"/>" height="420" width="420">
			<br>
			<h1>
			<c:out value="${product.productName}" />
			</h1>
			
			<h1>
			<c:out value="${product.price}" />
			</h1>
			<br>
			<p>
  			</c:forEach>
  		</ul>	

  	</c:if> 
</body>
</html>