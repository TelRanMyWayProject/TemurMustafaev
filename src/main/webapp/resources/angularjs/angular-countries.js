var appl=angular.module('country_app',[]);
appl.controller('countrys_contr',function($scope,$http){
	$scope.Countrys = [];
	$scope.GetAllCountries=function(){
		$http({
			 	method: 'GET',
				url: '/'+window.location.href.split('/')[3]+'/admin/list_countries'
			  }).then(function successCallback(response) {
				   $scope.Countrys=response.data;
			  }, function errorCallback(response) {
				 console.log(response);
			  });
	}
	$scope.GetAllCountries();
	
	$scope.AddCountry=function(){
		var name = $scope.name;
		var name = $scope.value;
		var index=$scope.Countrys.length;
		var data={
				name :$scope.name ,
				link :$scope.value
		};
		if($scope.value!=null){
		$http({
			method:'POST',
			url:'/'+window.location.href.split('/')[3]+'/admin/country',
			data: data,
			headers:{'Content-Type' :'application/json'}
		}).success(function(response){
			if(response.name!="Error"){
				$scope.Countrys[index]=response;
			}else{
				alert("Country with this name already exists");
			}
			
		}).error(function(response){
				console.log(response);
		});
		}else
			alert("enter the name");
		for(i=0;i<values.length;i++){
			if(values[i].name!="button"&&values[i].name!="countryId"){
				values[i].value="";
			}
		}
	}
	
	$scope.SendEditRequest=function(event){
		var index=event.currentTarget.className;
		var values=document.getElementsByClassName(index);
		var data={
				name : values.name.value,
				link : values.link.value,
				countryId: values.countryId.value
		};
		if(values.name.value!=""){
		$http({
			method:'POST',
			url:'/'+window.location.href.split('/')[3]+'/admin/country_edit',
			data: data,
			headers:{'Content-Type' :'application/json'}
		}).success(function(response){
			if(response.name!="Error"){
				for(var i=0;i<$scope.Countrys.length;i++){
					if($scope.Countrys[i].countryId==response.countryId){
						index=i;
					}
				}
				$scope.Countrys[index].name=response.name;
				$scope.Countrys[index].link=response.link;
			}else{
				values.name.value=$scope.Countrys[index].name;
				values.link.value=$scope.Countrys[index].link;
				alert("Country with this name already exists");
			}
			
		}).error(function(response){
				console.log(response);
			});}else{
				values.name.value=$scope.Countrys[index].name;
				values.link.value=$scope.Countrys[index].link;
				alert("enter the name");
			}
	}
	
	$scope.sendEmbassyRequest=function(event){
		var className=event.currentTarget.className;
		var values=document.getElementsByClassName(className);
		var form = document.createElement("form");
		form.action='/'+window.location.href.split('/')[3]+'/admin/embassies';
		var element=document.createElement("input");
		element.type="hidden";
		element.name=values[values.length-1].name;
		element.value=values[values.length-1].value;
		form.appendChild(element);
		document.body.appendChild(form);
	    form.submit();
	}
	$scope.sendProgramsRequest=function(event){
		var className=event.currentTarget.className;
		var values=document.getElementsByClassName(className);
		var form = document.createElement("form");
		form.action='programs';
		var element=document.createElement("input");
		element.type="hidden";
		element.name=values[values.length-1].name;
		element.value=values[values.length-1].value;
		form.appendChild(element);
		document.body.appendChild(form);
	    form.submit();
	}
	$scope.sendMainPage=function(){
		var form = document.createElement("form");
		form.action='mainPage';
		document.body.appendChild(form);
	    form.submit();
	}
	
});