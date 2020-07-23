var myApp = angular.module('myApp');

myApp.controller("IzmenaCtrl", function($scope, $http, $routeParams, $location) {
	$scope.auto = {};
	$scope.kompanije = []
		
		
	var urlA = "/api/racuni/" + $routeParams.id;
	
	
	
	
	var getA = function(){
		$http.get(urlA).then(
			function success(res){
				$scope.racun = res.data;
				console.log(res.data)
			},
			function error(){
				alert("Couldn't fetch");
			}
		);
	}
	
	$scope.uradiIzmenu = function(){
		$http.put(urlA, $scope.racun).then(
			function success(){
			$location.path("/prikaz")
				
			},
			function error(){
				alert("Something went wrong!!!!!");
			}
		);
	}

getA();
})