<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>	
<p:template>
	<jsp:attribute name="title">Immigration program</jsp:attribute>
    <jsp:body>				
<html ng-app="sampleApp">
<body ng-controller="loginCtrl">
    <div class="panel" style="width: 300px;">
        <form name="myForm" novalidate
					ng-submit="addNewUser(newUser, myForm.$valid)">
            <div class="well" style="height: 210px">
                <div class="form-group">
                    <label>Username:</label>
                    <input name="userEmail" type="email"
								class="form-control" required ng-model="newUser.email">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userEmail.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input name="userPassword" type="password"
								ng-minlength="5" ng-maxlength="10" class="form-control" required
								ng-model="newUser.password">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userPassword.$error)}}
                    </div>
                </div>            
                <button type="submit" class="btn btn-primary btn-block">
                    Click me if Ok!
                </button>
                <div class="well" style="margin-top: 20px;width: 300px;">
                	Message: {{message}}
                </div>
            </div>
        </form>
    </div>
    <div id="tasksPanel" class="panel "></div>
</body>
</html>
	</jsp:body>
</p:template>   		