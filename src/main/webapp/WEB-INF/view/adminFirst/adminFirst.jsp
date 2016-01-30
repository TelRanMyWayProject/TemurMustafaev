<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="adminPage" tagdir="/WEB-INF/tags/admin" %>	
<adminPage:adminTemplate>
	<jsp:attribute name="title">Welcom Admin</jsp:attribute>
    <jsp:body>		
		<html lang="en" data-ng-app="AdminFirstApp">
	<body>
		<div class="panel-body">
			<div class="col-xs-2 form-group" id="AdminFirst">
				
				<c:if test="${sessionScope.adminname!=null}">
				<label>Select Operation</label><br/>
				<table class="table">
				<tbody>
									<tr>
						<td>		
							<c:url value="/admin/countries.html" var="countries" />
	            			<a class="btn btn-default" href="${countries}">Countries</a>
						</td>
						<td>
					    	<c:url value="/admin/stepsPage.html" var="steps" />
	            			<a class="btn btn-default" href="${steps}">Steps</a>
						</td>
						<td>
					    	<c:url value="/admin/fields.html" var="fieldNames" />
	            			<a class="btn btn-default" href="${fieldNames}">Fields</a>
						</td>
					</tr>	
					</tbody>
				</table>
				</c:if>
			</div>
		</div>
	</body>
</html>	
	</jsp:body>
</adminPage:adminTemplate> 
