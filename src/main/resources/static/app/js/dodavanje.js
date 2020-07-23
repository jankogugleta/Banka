var myApp = angular.module('myApp');

myApp.controller("DodavanjeCtrl", function($scope, $http, $location ) {
	$scope.banke = [];
	$scope.tipovi = [];
	var urlB= "/api/banke"

			
	var nadjiB = function() {
		$http.get(urlB).then(
		function succes(res) {
			$scope.banke = res.data
			console.log(res.data)
			nadjiT();
		}, 
		function error() {
			alert("Greska banke")
		})
	}
	
	$scope.nadjiT = function(id) {
		console.log(id)
		var urlT = "/api/banke/" + id + "/tipovi"
		$http.get(urlT).then(
		function succes(res) {
			$scope.tipovi = res.data
			console.log(res.data)
		}, 
		function error() {
			alert("Greska tipovi")
		})
	}
	
	$scope.novA = {};
	
	var dodajA = function() {
		$http.post("/api/racuni", $scope.novA).then(
		function sucess(res) {
			$location.path("/prikaz")
		}, 
		function error() {
			alert("Greska")
		})
	}
	
	nadjiB();
	

		$scope.dodaj = function() {
		dodajA();
	}
});