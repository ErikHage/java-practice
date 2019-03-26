<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beers</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

	<spring:url var="addBeerUrl" value="/addBeerForm" />
	<spring:url var="homeUrl" value="/home.html" />
	<spring:url var="beerListUrl" value="/beerList" />
	<spring:url var="displayBeerUrl" value="/displayBeer" />
	<spring:url var="testExceptionUrl" value="/testException" />

	<h1><spring:message code="beerme.list.title"/></h1>
	<hr/>
	<a href="${homeUrl}">Home</a><br/>
	<a href="${addBeerUrl}">Add Beer</a><br/>
	<a href="${beerListUrl}">Beer List</a><br/>
	<a href="${testExceptionUrl}">Test Exception</a>
	<hr/>	
	<table>
		<tr>
			<td>ID</td>
			<td>Style</td>
			<td>Volume</td>
			<td>IBU</td>
			<td>SRM</td>
			<td>Notes</td>
		</tr>
		<c:forEach var="beer" items="${beers}">
			<tr>
				<td><a href="${displayBeerUrl}/${beer.id}">${beer.id}</a></td>
				<td>${beer.style}</td>
				<td>${beer.volume}</td>
				<td>${beer.ibu}</td>
				<td>${beer.srm}</td>
				<td>${beer.notes}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
