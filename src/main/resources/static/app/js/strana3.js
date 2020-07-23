var myApp = angular.module('myApp');

myApp.controller("NalogCtrl", function($scope, $http, $location) {
	
	$scope.nalog = {};
				
		
	var getR = function() {
		
		var config = {params:{}};
		config.params.uplatioc = $scope.nalog.uplatioc;
		config.params.primaoc = $scope.nalog.primaoc;
		config.params.iznos = $scope.nalog.iznos;
		
		console.log($scope.nalog.uplatioc, $scope.nalog.primaoc, $scope.nalog.iznos )
		
		$http.get("/api/racuni/nalog", config).then(
		function sucess() {
			$location.path("/prikaz")
			
		},
		function error() {
			alert("Greska")
		}
		)
	}
	
	$scope.prenesi  = function() {
		getR()
	} 
	
})
