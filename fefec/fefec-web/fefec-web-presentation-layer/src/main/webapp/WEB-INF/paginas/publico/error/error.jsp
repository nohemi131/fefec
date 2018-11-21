<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="mainContentVPE">
<h1 style="text-align: center" ><spring:message code='label.error'/></h1>
<br>
<h2 style="text-align: center" ><spring:message code='label.error.back'/></h2>


<a href="<c:url value='/'/>"> <img src="<c:url value='/resources/images/pages/public/error/home2.png'/>" /></a>

</div>