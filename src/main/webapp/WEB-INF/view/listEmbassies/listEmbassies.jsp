<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="adminPage" tagdir="/WEB-INF/tags/admin" %>	
<adminPage:adminTemplate>
	<jsp:body>
<style>
		[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
  			display: none !important;
		}
</style>

<body ng-app="embassies_app" >
<div ng-controller="embassies_contr" ng-init="GetAllCountries()" ng-cloak class="col-xs-90 form-group">

<p>{{CountryName}}</p> 
<button ng-click="sendRequestCountries()">back</button>
	<div class="col-xs-100 form-group">
	<table class="table table-hover table-condensed">
		<colgroup>
    		<col class="col-xs-1"/><!-- phone -->
    		<col class="col-xs-1"/><!--fax-->
    		<col class="col-xs-1"/><!--email-->
    		<col class="col-xs-1"/><!--type-->
    		<col class="col-xs-3"/><!--link-->
   			<col class="col-xs-3"/><!--address-->
  			<col class="col-xs-3"/><!--location-->
    		<col class="col-xs-1"/><!--action-->
    	</colgroup>
	<thead>
		<tr>
		<th>phone</th>
		<th>fax</th>
		<th>email</th>
		<th>type</th>
		<th>link</th>
		<th>address</th>
		<th>location</th>
		<th>action</th>
		</tr>
	</thead>
	<tbody>
	<tr ng-repeat="emb in embassies">
		<td><input type="text" name="phone" value="{{emb.phone}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="fax" value="{{emb.fax}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="email" value="{{emb.email}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="type" value="{{emb.type}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="link" value="{{emb.link}}" class='{{$index}} form-control input-sm'></td>
		<td><input type="text" name="address" value="{{emb.address}}" class='{{$index}} form-control input-sm'></td>
		<td>
			<select name="location" 
				ng-model="emb.location.countryId" 
				ng-options="country.countryId as country.name for country in Countrys" 
				class='{{$index}} form-control'>
			</select>
		</td>
		<td><button data-ng-click=SendEditRequest($event) name="button" class={{$index}}>Edit</button></td>
		<td><input type="hidden" name="embassyID" value={{emb.embassyID}} class={{$index}}></td>
		</tr>
		<tr>
		<td><input type="text" class="adding form-control input-sm" name="phone" placeholder="phone"></td>
		<td><input type="text" class="adding form-control input-sm" name="fax" placeholder="fax"></td>
		<td><input type="text" class="adding form-control input-sm" name="email" placeholder="email"></td>
		<td><input type="text" class="adding form-control input-sm" name="type" placeholder="type"></td>
		<td><input type="text" class="adding form-control input-sm" name="link" placeholder="link"></td>
		<td><input type="text" class="adding form-control input-sm" name="address" placeholder="address"></td>
				<td>
				<select name="location" 
				data-ng-options="country.name for country in Countrys track by country.countryId" 
				data-ng-model="selected_value" 
				class="adding form-control">
				</select>
				</td>
				<td><button data-ng-click=AddEmbassy() name="button">Add embassy</button></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
</body>
</html>
</jsp:body>
</adminPage:adminTemplate>