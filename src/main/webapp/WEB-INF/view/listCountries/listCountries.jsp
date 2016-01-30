<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="adminPage" tagdir="/WEB-INF/tags/admin" %>	
<adminPage:adminTemplate>
	<jsp:body>	
	<style type="text/css">
		[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
  		display: none !important;
		}
	</style>
	
		<div ng-app="country_app" ng-controller="countrys_contr" ng-cloak class="col-xs-90 form-group">
	<button ng-click=sendMainPage()>Main page</button>
	<p style="max-width:15%;">Filter by name: <input type="text" ng-model="search.name" class="form-control input-sm"></p>
	<div class="col-xs-100 form-group">
	<table class="table table-hover table-condensed">
	<colgroup>
    <col class="col-xs-5"/>
    <col class="col-xs-5"/>
    <col class="col-xs-1"/>
    <col class="col-xs-2"/>
    <col class="col-xs-2"/>
    </colgroup>
	<thead>
		<tr>
		<th>name</th>
		<th>link</th>
		<th>action</th>
		<th>Embassies</th>
		<th>Programs</th>
		</tr>
	</thead>
	<tbody>
	<tr ng-repeat="cr in Countrys|filter:search">
		<td><input type="text" name="name" value="{{cr.name}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="link" value="{{cr.link}}" class='{{$index}} form-control input-sm'></td>
		<td><button ng-click=SendEditRequest($event) name="button" class='{{$index}}'>Edit</button></td>
		<td><button ng-click=sendEmbassyRequest($event) name="button" class={{$index}}>Embassies</button></td>
		<td><button ng-click=sendProgramsRequest($event) name="button" class={{$index}}>Programs</button></td>
		<td><input type="hidden" name="countryId" value={{cr.countryId}} class={{$index}}></td>
	</tr>
	<tr>
		<td><input type="text" class="adding form-control input-sm" ng-model="name"  name="name" placeholder="name"></td>
		<td><input type="text" class="adding form-control input-sm" ng-model="value" name="link" placeholder="link"></td>
		<td><button ng-click=AddCountry() name="button">Add</button></td>
	</tr>
	</tbody>
</table>
</div>
</div>
</jsp:body>
</adminPage:adminTemplate>