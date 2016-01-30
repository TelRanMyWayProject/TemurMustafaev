<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="adminPage" tagdir="/WEB-INF/tags/admin" %>	
<adminPage:adminTemplate>
	<jsp:body>	
	<html lang="en" data-ng-app="FieldNamesApp">
	<style type="text/css">
		[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
  			display: none !important;
		}
	</style>
</head>
<body ng-controller="FieldNamesAppCtrl">
	<div class="panel-body" >
		<div class="col-xs-4 form-group">
			<label>List FieldNames</label>
			<table class="table table-bordered table-hover table-condensed">
		        <colgroup>
          			<col class="col-xs-4"/>
          			<col class="col-xs-6"/>
          			<col class="col-xs-1"/>
          			<col class="col-xs-1"/>
        		</colgroup>
				<thead>
					<th>Name</th>
					<th>Possible values</th>
					<th style="text-align:center" colspan="2">Actions</th>
				</thead>
				<tbody>
					<tr ng-repeat="item in itemsAll | orderBy : 'name'" ng-include="getTemplate(item)">
						
						<script type="text/ng-template" id="display">
							<td>{{item.name}}</td>
							<td>{{item.possibleValues}}</td>
							<td><button type="button" class="btn btn-primary" ng-click="editItem(item)"><span class="glyphicon glyphicon-pencil"></button></td>
							<td><button type="button" class="btn btn-default disabled" ng-click="deleteItem(item)"><span class="glyphicon glyphicon-trash"></button></td>
						</script>
						
						<script type="text/ng-template" id="edit">
							<td><input type="text" ng-model=itemedit.name class="form-control input-sm" required/></td>
							<td><input type="text" ng-model=itemedit.possibleValues class="form-control input-sm"/></td>
							<td><button type="button" class="btn btn-primary" ng-click="updateItem(itemedit)"><span class="glyphicon glyphicon-ok"></button></td>
							<td><button type="button" class="btn btn-default" ng-click="resetItem()"><span class="glyphicon glyphicon-remove"></button></td>
						</script>
					</tr>
					<tr>
						<td><input type="text" ng-model="itemadd.name" placeholder="Insert name" class="form-control input-sm"/></td>
						<td><input type="text" ng-model="itemadd.possibleValues" placeholder="Insert possible values" class="form-control input-sm"/></td>
						<td><button type="button" class="btn btn-info" ng-click="addItem()"><span class="glyphicon glyphicon-plus"></span></button></td>
						<td><button type="button" class="btn btn-default" ng-click="resetAddItem()"><span class="glyphicon glyphicon-remove"></span></button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
</jsp:body>
</adminPage:adminTemplate>