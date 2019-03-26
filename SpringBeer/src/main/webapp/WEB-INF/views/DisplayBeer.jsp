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
<title>Beer Facts</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>

	<spring:url var="addBeerUrl" value="/addBeerForm" />
	<spring:url var="homeUrl" value="/home.html" />
	<spring:url var="beerListUrl" value="/beerList" />
	<spring:url var="updateBeerUrl" value="/updateBeer" />
	<spring:url var="displayBeerUrl" value="/displayBeer" />

	<h1>Beer Facts</h1>
	<hr />
	<a href="${homeUrl}">Home</a><br/>
	<a href="${addBeerUrl}">Add Beer</a><br/>
	<a href="${beerListUrl}">Beer List</a>
	<hr/>
	<!-- Fix this Once I learn REST  
	<form:form action="${displayBeerUrl}/${beer.id}" modelAttribute="beer">
		<form:label path="id">Get Beer with ID:</form:label>
		<form:input type="text" path="id" />
		<input type="submit" value="Go" />
	</form:form>
	-->
	<hr/>
	
	<form:form method="POST" action="${updateBeerUrl}"
		modelAttribute="beer">
		<fieldset>
			<legend>Add a Beer</legend>
			<p>
				<form:label path="id">Id</form:label>
				<form:input path="id" readonly="true" />
			</p>
			<p>
				<form:label path="style" cssErrorClass="error">Style</form:label>
				<form:input id="style" path="style" />
				<form:errors path="style" cssClass="errors" />
			</p>
			<p>
				<form:label path="volume">Volume</form:label>
				<form:input path="volume" />
			</p>
			<p>
				<form:label path="ibu">IBU</form:label>
				<form:input path="ibu" />
			</p>
			<p>
				<form:label path="srm">SRM</form:label>
				<form:input path="srm" />
			</p>
			<p>
				<form:label path="notes">Notes</form:label>
				<form:textarea path="notes" rows="5" />
			</p>
			<p id="buttons">
				<input id="submit" type="submit" value="Update" />
			</p>
		</fieldset>
		<fieldset>
			<legend>Status</legend>
			<c:if test="${isUpdateSuccessful == 'T'}">
				<p class="success">Update Successful!</p>
			</c:if>
			<c:if test="${isUpdateSuccessful == 'F'}">
				<p class="errors">Update Failed</p>
			</c:if>
		</fieldset>
	</form:form>


</body>
</html>