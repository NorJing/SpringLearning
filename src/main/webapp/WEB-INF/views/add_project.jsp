<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Manager</title>

<script>
var ctx = "${pageContext.request.contextPath}"
</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/project.js"/>"></script>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl"/>
			<form:form modelAttribute="project" action="${formUrl}" method="post" cssClass="col-md-8 col-md-offset-2" enctype="multipart/form-data">
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input id="project-name" 
							cssClass="form-control" path="name"/>
					<form:errors path="name"/>
				</div>

				<div class="form-group">
					<label for="project-type">Type</label>
					<form:select path="type" cssClass="selectpicker" items="${types}"></form:select>
				</div>

				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input id="sponsor-name" cssClass="form-control" path="sponsor.name"/>
				</div>

				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input id="sponsor-phone" 
							cssClass="form-control" path="sponsor.phone"/>
				</div>

				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input id="sponsor-email" 
							cssClass="form-control" path="sponsor.email"/>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds"
						cssClass="form-control" path="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" cssClass="form-control" path="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea cssClass="form-control" path="description" rows="3"></form:textarea>
					<form:errors path="description"/>
				</div>
				
				<div class="form-group">
					<label for="julian-date">Julian Date</label>
					<form:input id="julian-date" cssClass="form-control" path="startDate"/>
				</div>
				
				<div class="form-group">
					<label for="poc">POC</label>
					<form:input id="poc" cssClass="form-control" path="pointsOfContact[0]"/>
				</div>

				<div class="form-group">
					<label for="poc2">POC2</label>
					<form:input id="poc2" 
							cssClass="form-control" path="pointsOfContact[1]"/>
				</div>

				<div class="form-group">
					<label for="poc3">POC3</label>
					<form:input id="poc3" 
							cssClass="form-control" path="pointsOfContact[2]"/>
				</div>
				
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" path="special"/>
				</div>
			
				<div class="form-group">
					<a id="request-link" href="<spring:url value="/project/request" />">Send Request</a> 
				</div>
				
				<div class="form-group">
					<label for="inputfile">File input</label>
					<input type="file" name="file">
				</div>
					
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
			
	</div>
</body>
</html>