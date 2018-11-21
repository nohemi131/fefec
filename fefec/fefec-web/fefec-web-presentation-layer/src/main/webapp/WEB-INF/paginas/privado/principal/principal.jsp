<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<tiles:insertAttribute name="MapNavPage" ignore="true" />
<script type="text/javascript">
<!--
	if(typeof $ != 'undefined' && $!= null  ){
		$.Principal.init();
	}else{
		window.location.href="<c:url value='/' />";
	}	
//--> 
</script>	
		<p >
		 	
			
			<center>
			 <md-input-container>
			        <label>Options Templates</label>
			        <md-select ng-model="selectedItem" md-selected-text="getSelectedText()">
			          <md-optgroup label="Options">
			            <md-option ng-value="listaCategory.categoryId" ng-repeat="listaCategory in entitiesCategoryTemplatesListData.listCategoryTemplateData">{{listaCategory.categoryTemplate}}</md-option>
			          </md-optgroup>
			        </md-select>
			      </md-input-container>&ensp;&ensp;&ensp;
			      <md-button ng-click="clickDesigner()" class="md-raised md-primary notLoading">Designer</md-button>
      		</center>
		</p>