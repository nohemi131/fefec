<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8, width=device-width, initial-scale=1" >
		<title><tiles:insertAttribute name="title" /></title>
		
		<!-- CSS from Sppiner, loading -->
		<link href="<c:url value='resources/css/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='resources/css/bootstrap/css/bootstrap-theme.min.css'/>" rel="stylesheet">
		<link href="<c:url value='resources/css/bootstrap/css/bootstrapValidator.min.css'/>" rel="stylesheet">
	
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="<c:url value='resources/javascript/lib/bootstrap/bootstrap.min.js' />"></script>    	
    	<script src="<c:url value='resources/javascript/lib/bootstrap/bootstrapvalidator.min.js' />"></script>
	</head>		
	<body>	
		<tiles:insertAttribute name="header" />			
	   	<tiles:insertAttribute name="body" />		   	
	    <tiles:insertAttribute name="footer" /> 
	</body>
</html>