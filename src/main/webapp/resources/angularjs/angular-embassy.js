var appl=angular.module('embassies_app',[]);
appl.controller('embassies_contr',function($scope,$http){

	var json = JSON.parse('${results}');
	$scope.id = json.CountryId;
	$scope.CountryName = json.name;
	
	$scope.selected_value;
	$scope.GetAllEmbassies=function () {
		$http({
		 	method: 'GET',
			url: '/'+window.location.href.split('/')[3]+'/admin/list_embassies'+'?countryId='+$scope.id
		  }).then(function successCallback(response) {
			   $scope.embassies=response.data;
		  }, function errorCallback(response) {
			 console.log(response);
		  });
	};
	
	$scope.GetAllEmbassies();

	$scope.GetAllCountries=function () {
		$http({
		 	method: 'GET',
			url: '/'+window.location.href.split('/')[3]+'/list_countries'
		  }).then(function successCallback(response) {
			  
			   $scope.Countrys=response.data;
			   $scope.Countrys[$scope.Countrys.length]={name: "Choose country", link: "", countryId: -1};
			   $scope.selected_value=$scope.Countrys[$scope.Countrys.length-1];
		  }, function errorCallback(response) {
			 console.log(response);
		  });
	};
	
	$scope.SendEditRequest=function(event){
		var index=event.currentTarget.className;
		var values=document.getElementsByClassName(index);
		var data={
			phone : values.phone.value,
			fax : values.fax.value,
			email : values.email.value,
			type : values.type.value,
			link : values.link.value,
			address: values.address.value,
			location: $scope.Countrys[values.location.selectedIndex].countryId,
			embassyID: values.embassyID.value			
		};
		
		if(values.phone.value!=""){
		$http({
			method:'POST',
			url:'/'+window.location.href.split('/')[3]+'/embassy_edit',
			data: data,
			headers:{'Content-Type' :'application/json'}
		}).success(function(response){
		if(response.phone!="Error"){
			$scope.embassies[index].phone=response.phone;
			$scope.embassies[index].fax=response.fax;
			$scope.embassies[index].email=response.email;
			$scope.embassies[index].type=response.type;
			$scope.embassies[index].link=response.link;
			$scope.embassies[index].address=response.address;
			$scope.embassies[index].location=response.location;
		}else{
			values.phone.value=$scope.embassies[index].phone;
			values.fax.value=$scope.embassies[index].fax;
			values.email.value=$scope.embassies[index].email;
			values.type.value=$scope.embassies[index].type;
			values.link.value=$scope.embassies[index].link;
			values.address.value=$scope.embassies[index].address;
				alert("Embassy with this phone already exists");
		}
		}).error(function(response){
			console.log(response);
			});
	}else{
		values.phone.value=$scope.embassies[index].phone;
		values.fax.value=$scope.embassies[index].fax;
		values.email.value=$scope.embassies[index].email;
		values.type.value=$scope.embassies[index].type;
		values.link.value=$scope.embassies[index].link;
		values.address.value=$scope.embassies[index].address;
		alert("enter the phone");
		}
	}
	
	$scope.AddEmbassy=function(){
		var values=document.getElementsByClassName("adding");
		var index=$scope.embassies.length;
		
		if(values.location.selectedIndex!=$scope.Countrys.length-1&&values.phone.value!=""){	
		var data={
			phone : values.phone.value,
			fax : values.fax.value,
			email : values.email.value,
			type : values.type.value,
			link : values.link.value,
			address: values.address.value,
			location: $scope.Countrys[values.location.selectedIndex].countryId,
			countryId: $scope.id			
		};
		$http({
			method:'POST',
			url:'/'+window.location.href.split('/')[3]+'/embassy',
			data: data,
			headers:{'Content-Type' :'application/json'}
		}).success(function(response){
			if(response.phone!="Error"){
			$scope.embassies[index]=response;
			$scope.embassies[index].location=response.location;
			}else{
			alert("Embassy with this phone already exists");
			}
			}).error(function(response){
			console.log(response);
			});
		}else
			alert("Select location and enter the phone");
		for(i=0;i<values.length;i++){
			if(values[i].name!="button"&&values[i].name!="embassyID"&&values[i].name!="location"){
				values[i].value="";
			}
		}
		$scope.selected_value=$scope.Countrys[$scope.Countrys.length-1];
	}
	
	$scope.sendRequestCountries=function(){
		var form = document.createElement("form");
		form.action='countries';
		document.body.appendChild(form);
	    form.submit();
	}
});