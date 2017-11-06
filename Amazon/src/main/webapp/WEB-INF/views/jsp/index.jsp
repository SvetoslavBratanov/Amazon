<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<!--
Template Name: Pleeness
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
<head>
<title>Amazing</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href= "<c:url value="/resources/static/css/layout.css"/>" rel="stylesheet" type="text/css" media="all" />

</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row0">
  <div id="topbar" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="fl_left">
      <ul class="nospace inline pushright">
        <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
        <li><i class="fa fa-envelope-o"></i> deniittalents@gmail.com</li>
      </ul>
    </div>
    <div class="fl_right">
      <ul class="nospace inline pushright">
      <c:choose>
    <c:when test="${user != null}">
    <form method = "get" action = "/logout">
        <li> <a href="/logout">Logout</a></li>
    </form>
        <br />
    </c:when>    
    <c:otherwise>

        <li><i class="fa fa-sign-in"></i> <a href="/login">Login</a></li>
        <li><i class="fa fa-user"></i> <a href="/login">Register</a></li>        <br />
    </c:otherwise>
</c:choose>		
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Amazing</a></h1>
    </div>
    <div id="search" class="fl_right">
      <form class="clear" method="get" action="/products">
        <fieldset>
          <legend>Search:</legend>
			<input type="text" name="input" placeholder="Search...">
          <button class="fa fa-search" type="submit" title="Search"><em>Search</em></button>
        </fieldset>
      </form>
    </div>
    <!-- ################################################################################################ -->
  </header>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="index.html">Home</a></li>
     
     
      <li><a href="/computers">Computers</a></li>
      <li><a href="/books">Books</a></li>
      <li><a href="/movies">Movies</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </nav>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script type="text/javascript" src="<c:url value="/resources/static/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/static/js/jquery.backtotop.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/static/js/jquery.mobilemenu.js"/>"></script>


<!-- IE9 Placeholder Support -->
<script type="text/javascript" src="<c:url value="/resources/static/js/jquery.placeholder.min.js"/>"></script>

<!-- / IE9 Placeholder Support -->
</body>
</html>