<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags"%>
<p:template>
	<jsp:attribute name="title">Immigration program</jsp:attribute>
	<jsp:body>		
		<script>
			angular
					.module("sampleApp", [])
					.controller(
							"defaultCtrl",
							function($scope, $http, $window) {
								$scope.addNewUser = function(userDetails, isvalid) {
									$scope.items = [];

									if (isvalid) {

										$scope.items.push({
											firstname : userDetails.firstname,
											lastname : userDetails.lastname,
											gender : userDetails.gender,
											citizenship : userDetails.citizenship,
											birthplace : userDetails.birthplace,
											familyStatus : userDetails.status,
											education : userDetails.education,
											occupation : userDetails.occupation,
											homePhone : userDetails.home,
											workPhone : userDetails.work,
											mobilePhone : userDetails.mobile,
											address : userDetails.address,
										});

										var post = {
											error : ' ',
											firstName : $scope.items[0].firstname,
											lastName : $scope.items[0].lastname,
											gender : $scope.items[0].gender,
											citizenship : $scope.items[0].citizenship,
											birthplace : $scope.items[0].birthplace,
											familyStatus : $scope.items[0].familyStatus,
											education : $scope.items[0].education,
											occupation : $scope.items[0].occupation,
											homePhone : $scope.items[0].homePhone,
											workPhone : $scope.items[0].workPhone,
											mobilePhone : $scope.items[0].mobilePhone,
											address : $scope.items[0].address,
											
										};

										$http
												.post(
														'http://localhost/immigration-login/do_setprofile',
														post)
												.success(
														function(data, status,headers, config) {
															if (data.error == "ERROR") {
																$scope.message = "Some thing wrong, please try again!";
															} else {
																$window.location.href = "${pageContext.request.contextPath}";
															}
														})
												.error(function(data, status,headers, config) {
													
												});

									} else {

										$scope.message = "Inserted data: Firstname - "
												+ userDetails.firstname
												+ " Lastname - "
												+ userDetails.lastname
												+ " Gender - "
												+ userDetails.gender
												+ " Citizenship - "
												+ userDetails.citizenship
												+ " Birthplace - "
												+ userDetails.birthplace
												+ " Family status - "
												+ userDetails.status
												+ " Education - "
												+ userDetails.education
												+ " Occupation - "
												+ userDetails.occupation
												+ " Home phone - "
												+ userDetails.home
												+ " Work phone - "
												+ userDetails.work										
												+ " Mobile phone - "
												+ userDetails.mobile
												+ " Addresss - "
												+ userDetails.address;												
									}
								}
								$scope.getError = function(error) {
									if (angular.isDefined(error)) {
					                       if (error.required) {
					                            return "The field shouldn't be empty";
					                        }
					                       if (error.number) {
					                            return "Use only integers";
					                        }
									}
								}
							});
		</script>		
<html ng-app="sampleApp">
<body ng-controller="defaultCtrl">
    <div class="panel" style="width: 500px;">
        <form name="myForm" novalidate ng-submit="addNewUser(newUser, myForm.$valid)">
            <div class="well">
                <div class="form-group">
                    <label>Firstname:</label>
                    <input name="userFirstname" type="text"	class="form-control" required ng-model="newUser.firstname">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userFirstname.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Lastname:</label>
                    <input name="userLastname" type="text" class="form-control" required ng-model="newUser.lastname">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userLastname.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label> Gender:</label><br/>
                  MALE:  <input name="userGender" type="radio" class="form-control" value="MALE" required ng-model="newUser.gender">
                  FEMALE:<input name="userGender" type="radio" class="form-control" value="FEMALE" required ng-model="newUser.gender">
                  OTHER:  <input name="userGender" type="radio" class="form-control" value="OTHER" required ng-model="newUser.gender">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userGender.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Citizenships:</label>
                    <textarea name="userCitizenship" cols="10" rows="3" type="text" class="form-control" ng-minlength="1"
                     ng-maxlength="500" required ng-model="newUser.citizenship" 
                     title="If you have more then one citizenship, use '( ; )' after each of them! "></textarea>         
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userCitizenship.$error)}}
                    </div>
                </div>

                <div class="form-group">
                    <label>Birthplace:</label>
                    <input name="userBirthplace" type="text" class="form-control" ng-minlength="1"
                     ng-maxlength="20" required ng-model="newUser.birthplace" 
                     title="Inser only one full name of the country where you were born.">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userBirthplace.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label> Family status:</label><br/>
                  MARRIED:  <input name="userStatus" type="radio" class="form-control" value="MALE" required ng-model="newUser.status">
                  SINGLE:<input name="userGender" type="radio" class="form-control" value="FEMALE" required ng-model="newUser.status">
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userStatus.$error)}}
                    </div>
                </div>
                 <div class="form-group">
                    <label>Education:</label>
                    <input name="userEducation" type="text" class="form-control" ng-minlength="1"
                     ng-maxlength="30" required ng-model="newUser.education" 
                     title="Inser only one full name of the country where you were born.">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userEducation.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Occupation:</label>
                    <input name="userOcupation" type="text" class="form-control" ng-minlength="1"
                     ng-maxlength="30" required ng-model="newUser.occupation" 
                     title="Inser only one full name of the country where you were born.">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userOcupation.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Home phone N:</label>
                    <input name="userHome" type="number" class="form-control" ng-minlength="6"
                     ng-maxlength="30" required ng-model="newUser.home">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userHome.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Work phone N:</label>
                    <input name="userWork" type="number" class="form-control" ng-minlength="6"
                     ng-maxlength="30" required ng-model="newUser.work">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userWork.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Mobile phone N:</label>
                    <input name="userMobile" type="number" class="form-control" ng-minlength="6"
                     ng-maxlength="30" required ng-model="newUser.mobile">
                      <div class="error" ng-show="showError">
                        {{getError(myForm.userMobile.$error)}}
                    </div>
                </div>
                <div class="form-group">
                    <label>Address list:</label>
                    <textarea name="userAddress" cols="10" rows="3" type="text" class="form-control" ng-minlength="1"
                     ng-maxlength="500" required ng-model="newUser.address" 
                     title="If you have more then one address, use '( ; )' after each of them! "></textarea>         
                    <div class="error" ng-show="showError">
                        {{getError(myForm.userAddress.$error)}}
                    </div>
                </div>       
                <button type="submit" class="btn btn-primary btn-block">
                    Set profile!
                </button>
                <div class="well"
					style="margin-top: 50px; width: 450px;">
                	Message: {{message}}
                </div>
            </div>
        </form>
    </div>
    <div id="tasksPanel" class="panel "></div>
</body>
</html>
<button class="btn btn-danger">
		</button>		
	</jsp:body>

</p:template>
