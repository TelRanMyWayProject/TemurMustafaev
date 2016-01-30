angular.module('StepsApp', [])
	.controller('StepsCtrl', function($scope, $http) {
		var jsonRes = JSON.parse('${result}');
		$scope.itemsAll = jsonRes;
		$scope.itemedit = {};
        $scope.itemadd = {"id":0,"name":"","description":""};
		$scope.getTemplate = function (item) {
	        if (item.id === $scope.itemedit.id) {
				return 'edit';
			}
	        else {
	        	return 'display';
	        }
	    };
		
		$scope.resetItem = function () {
	        $scope.itemedit = {};
	    };
		
		$scope.resetAddItem = function () {
	        $scope.itemadd = {"id":0,"name":"","description":""};
	    };
		
		$scope.editItem = function (item) {
	        $scope.itemedit = angular.copy(item);
	    };
		
		$scope.updateItem = function(item) {
			if (item.name != "") {
	 			sendJson = item;
	 			$http({
					method:'POST',
					url: '/' + window.location.href.split('/')[3] + '/stepedit',
					data: sendJson,
					headers:{'Content-Type' :'application/x-www-form-urlencoded'}
				}).success(function(responce) {
					// console.log(responce);
					$scope.resetItem();
					for (var i = 0; i< $scope.itemsAll.length; i++) {
						if ($scope.itemsAll[i].id == responce.id) {
							$scope.itemsAll[i].name = responce.name;
							$scope.itemsAll[i].description = responce.description;
							break;
						}
					}
				}).error(function(responce) {
					// console.log("Error updating");
				});
			}
		}
		
		$scope.addItem = function(item) {
			if (item.name != "") {
	 			sendJson = item;
				$http({
					method:'POST',
					url: '/' + window.location.href.split('/')[3] + '/stepadd',
					data: sendJson,
					headers:{'Content-Type' :'application/x-www-form-urlencoded'}
				}).success(function(responce) {
					if (responce.length != 0) {
						if (responce.id > 0) {
							$scope.itemsAll.push(responce);
							$scope.itemadd.id = 0;
							$scope.itemadd.name = "";
							$scope.itemadd.description = "";
						}
					}
					else {
					}
				}).error(function(responce) {
				});
			}
		}
		$scope.deleteItem = function(item) {
		}
	});