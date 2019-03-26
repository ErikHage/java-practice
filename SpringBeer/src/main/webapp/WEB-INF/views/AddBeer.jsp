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
<title>Add Beer</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<spring:url var="addBeerUrl" value="/addBeerForm" />
	<spring:url var="homeUrl" value="/home.html" />
	<spring:url var="beerListUrl" value="/beerList" />
	<spring:url var="saveBeerUrl" value="/saveBeer" />

	<h1><spring:message code="beerme.add.title"/></h1>

	<hr/>
	<a href="${homeUrl}">Home</a><br/>
	<a href="${addBeerUrl}">Add Beer</a><br/>
	<a href="${beerListUrl}">Beer List</a>
	<hr/>
	
	<form:form method="POST" action="${saveBeerUrl}" modelAttribute="beer">
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
				<!-- IF update, change to update -->
				<input id="submit" type="submit" value="Save" />
				<input id="reset" type="reset"/> 
			</p>
		</fieldset>
	</form:form>



</body>
</html>