<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="false"%>
<link href="<c:url value='resources/css/paginas/publico/login/login.css'/>" rel="stylesheet">
<script src="<c:url value='resources/javascript/paginas/publico/login/login.js' />"></script>  
<div class="container">
	<form method="post" id="contact_form" action="<c:url value='authentication' />" class="well form-horizontal" >
		<fieldset>
			<legend>
				<span>Sign in</span><span>With your Account</span>
			</legend>
			<div class="form-group">
				<label class="col-md-4 control-label"><spring:message code='Placeholder.user' /></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
						<input id="username" name="username" placeholder="<spring:message code='Placeholder.user'/>" class="form-control" type="text" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label"><spring:message code='Placeholder.password' /></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span> 
						<input name="password" id="password" placeholder="<spring:message code='Placeholder.password'/>" class="form-control" type="password" />
					</div>
				</div>
			</div>


			<sec:csrfInput />
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-warning">
						<spring:message code='Button.login' />
						<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
		</fieldset>
	</form>
	<c:if test="${not empty param.login_error}">
  		<span class="help-block has-feedback  has-error"><font color="red">Your login attempt was not successful, try again.</font></span>
	</c:if>
</div>

