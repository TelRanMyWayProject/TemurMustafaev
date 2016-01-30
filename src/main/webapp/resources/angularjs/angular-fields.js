	angular.module('FieldNamesApp', [])
	.controller('FieldNamesAppCtrl', function($scope, $http) {
//		var jsonRes = JSON.parse('${result}');
//		$scope.itemsAll = jsonRes;
		$scope.itemedit = {};
        $scope.itemadd = {"id":0,"name":"","possibleValues":""};
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
	        $scope.itemadd = {"id":0,"name":"","possibleValues":""};
	    };
		
		$scope.editItem = function (item) {
	        $scope.itemedit = angular.copy(item);
	    };
		
		$scope.updateItem = function(item) {
			if ($scope.itemadd.name!= "") {
	 			$http({
					method:'POST',
					url: '/' + window.location.href.split('/')[3] + '/admin/fieldnamesedit',
					data: $scope.itemadd,
					headers:{'Content-Type' :'application/x-www-form-urlencoded'}
				}).success(function(responce) {
					// console.log(responce);
					$scope.resetItem();
					for (var i = 0; i< $scope.itemsAll.length; i++) {
						if ($scope.itemsAll[i].id == responce.id) {
							$scope.itemsAll[i].name = responce.name;
							$scope.itemsAll[i].possibleValues = responce.possibleValues;
							break;
						}
					}
				}).error(function(responce) {
				});
			}
		};
		
		$scope.addItem = function() {
			alert("Add Item function");
			if ($scope.itemadd.name!= "") {
				$http({
					method:'POST',
					url: '/' + window.location.href.split('/')[3] + '/admin/fieldnamesadd',
					data: $scope.itemadd,
					headers:{'Content-Type' :'application/x-www-form-urlencoded'}
				}).success(function(responce) {
					if (responce.length != 0) {
						if (responce.id > 0) {
							$scope.itemsAll.push(responce);
							$scope.itemadd.id = 0;
							$scope.itemadd.name = "";
							$scope.itemadd.possibleValues = "";
						}
					}
					else {
					}
				}).error(function(responce) {
				});
			}
		};
		
		$scope.deleteItem = function(item) {
		}
	});