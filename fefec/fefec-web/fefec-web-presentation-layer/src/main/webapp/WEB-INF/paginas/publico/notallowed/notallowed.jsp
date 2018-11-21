<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page session="false"%>
<script type="text/javascript">
<!--
	if(typeof $ != 'undefined' && $!= null  ){
		
	}else{
		window.location.href="<c:url value='/' />";
	}	
//--> 
</script>
<h1> <spring:message code='label.notallowed.access'/> </h1>
<a href="<c:url value='/'/>"><spring:message code='label.notallowed.enter'/></a>