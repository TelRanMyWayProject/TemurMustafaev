var sampleApp = angular.module("sampleApp", []);

sampleApp.controller("loginCtrl", function ($scope,$http,$window) {                
                $scope.addNewUser = function (userDetails, isvalid) {
                $scope.items = [];
         
                $scope.message = "Account crested successfully! Your Username is: "+userDetails.email+
            	", Password is: "+userDetails.password;
                
                	if (isvalid) {
         
                    $scope.items.push({
                     email: userDetails.email,
                     password: userDetails.password,
                     });     
                    
                    var post  =  {
                    		error:' ',
                    		username:$scope.items[0].email,
                    		password:$scope.items[0].password
                    		};
                   
                    $http.post('http://localhost/immigration-login/do_login', post).
                    success(function(data, status, headers, config) {
                    	if(data.error == "ERROR"){
                    		$scope.message = "This user doesn't exist!";
                    	}else{
                    		$window.location.reload();
                    		$window.location.href = "http://localhost/immigration-login/";
                    	}  	
                    }).
                    error(function(data, status, headers, config) {
                    	
                    });
                		                    
                    }
                    else {
                	
     				$scope.message = "Inserted data: Username - "+userDetails.email+" Password - "+userDetails.password+"Confirm password - "+userDetails.confirm;
                   
                    }
                }
                $scope.getError = function (error) {
                    if (angular.isDefined(error)) {    
                        if (error.email) {
                            return "Please insert email correctly";
                        }
                        if (error.required) {
                            return "The field shouldn't be empty";
                        }
                    }
                }
 });
 
sampleApp.controller("signupCtrl", function ($scope,$http) {                
        $scope.addNewUser = function (userDetails, isvalid) {
        $scope.items = [];
 
        $scope.message = "Account crested successfully! Your Username is: "+userDetails.email+
    	", Password is: "+userDetails.password;
        
        	if (isvalid) {
 
            $scope.items.push({
             email: userDetails.email,
             password: userDetails.password,
             });     
            
            var post  =  {
            		error:' ',
            		username:$scope.items[0].email,
            		password:$scope.items[0].password
            		};
           
            $http.post('http://localhost/immigration-login/do_signup', post).
            success(function(data, status, headers, config) {
            	if(data.error == "ERROR"){
            		$scope.message = "This user already exist!";
            	}
            }).
            error(function(data, status, headers, config) {
            	
            });
        		                    
            }
            else {
        	
				$scope.message = "Inserted data: Username - "+userDetails.email+" Password - "+userDetails.password+"Confirm password - "+userDetails.confirm;
           
            }
        }
        $scope.getError = function (error) {
            if (angular.isDefined(error)) {    
                if (error.email) {
                    return "Please insert email correctly";
                }
                if (error.required) {
                    return "The field shouldn't be empty";
                }
            }
        }
});

sampleApp.controller("adminLoginCtrl", function ($scope,$http,$window,$interval) {                
    $scope.addNewUser = function (userDetails, isvalid) {
        $scope.items = [];
 
        $scope.message = "Account crested successfully! Your Username is: "+userDetails.email+
    	", Password is: "+userDetails.password;
        
        	if (isvalid) {
 
            $scope.items.push({
             email: userDetails.email,
             password: userDetails.password,
             });     
            
            var post  =  {
            		error:' ',
            		username:$scope.items[0].email,
            		password:$scope.items[0].password
            		};
           
            $http.post('http://localhost/immigration-login/admin/checkLogin', post).
            success(function(data, status, headers, config) {
            	if(data.error == "ERROR"){
            		$scope.message = "This user doesn't exist!";
            	}else{
            		$interval(function(){
            			$window.location.reload();
            		},1000); 
            	}  	
            }).
            error(function(data, status, headers, config) {
            	
            });
        		                    
            }
            else {
        	
				$scope.message = "Inserted data: Username - "+userDetails.email+" Password - "+userDetails.password+"Confirm password - "+userDetails.confirm;
           
            }
        }
        $scope.getError = function (error) {
            if (angular.isDefined(error)) {    
                if (error.email) {
                    return "Please insert email correctly";
                }
                if (error.required) {
                    return "The field shouldn't be empty";
                }
            }
        }
});
