<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer Not Found</title>
</head>
<body>
	<spring:url var="addBeerUrl" value="/addBeerForm" />
	<spring:url var="homeUrl" value="/home.html" />
	<spring:url var="beerListUrl" value="/beerList" />

	<h1>Beer Not Found</h1>
	<hr/>
	<a href="${homeUrl}">Home</a><br/>
	<a href="${addBeerUrl}">Add Beer</a><br/>
	<a href="${beerListUrl}">Beer List</a><br/>
	<hr/>
</body>
</html>