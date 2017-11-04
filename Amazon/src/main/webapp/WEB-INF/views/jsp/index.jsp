<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Amazon</title>

<link href= "<c:url value="/resources/static/css/bootstrap.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/static/css/style.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/static/css/fasthover.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/static/css/popuo-box.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Glegoo:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link c:url value="/resources/static/css/font-awesome.css"/>
<script src="<c:url value="/resources/static/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/static/js/bootstrap-3.1.1.min.js"/>"></script>
</head>
<body>
	<c:choose>
    <c:when test="${user != null}">
    <form method = "get" action = "/logout">
		   <button>Logout</button>
    </form>
        <br />
    </c:when>    
    <c:otherwise>
			 <a href="login"><img src="<c:url value="/resources/static/images/login.jpeg"/>" width="60" height="60"></a>
        <br />
    </c:otherwise>
</c:choose>

			<div class="w3l_logo">
				<h1><a href="index.html">The best shop ever<span>Your stores. Your place.</span></a></h1>
			</div>
			<div class="search">
				<input class="search_box" type="checkbox" id="search_box">
				<label class="icon-search" for="search_box"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></label>
				<div class="search_form">
				<!-- 	<form action="/products" method="get"> -->
					
						<input type="text" name="input" placeholder="Search...">
						<input type="submit" value="Send">
					</form>
				</div>
			</div>
			<div class="cart cart box_1">
				<form action="#" method="post" class="last">
					<input type="hidden" name="cmd" value="_cart" />
					<input type="hidden" name="display" value="1" />
					<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
				</form>
			</div>
		</div>
	</div>
	<!-- //header -->
	<!-- navigation -->
	<div class="navigation">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header nav_2">
					<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav">
						<li><a href="index.html" class="act">Home</a></li>
						<!-- Mega Menu -->
						<!-- Mega Menu -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Products <b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-3">
								<div class="row">
									<div class="col-sm-3">
										<ul class="multi-column-dropdown">
											<h6><a href="books">Books</h6>
										</ul>
									</div>
									<div class="col-sm-3">
										<ul class="multi-column-dropdown">
											<h6><a href="computers">Computers</h6>
										</ul>
									</div>
									<div class="col-sm-2">
										<ul class="multi-column-dropdown">
											<h6><a href="movies">Movies</h6>
										</ul>
									</div>
									
									<div class="clearfix"></div>
								</div>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<!-- //navigation -->
	<!-- banner -->
	<div class="banner">
		<div class="container">
		</div>

</body>
</html>
