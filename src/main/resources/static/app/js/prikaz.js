var myApp = angular.module('myApp');

myApp.controller("PrikazCtrl", function($scope, $http, $location) {
	var url= "/api/racuni"
	$scope.racuni = [];
	$scope.pageNum=0;
	$scope.totalPages = 1;
	$scope.search = {};
	$scope.prikazi = false;
	$scope.banke = [];
	
	var getR = function() {
		
		var config = {params:{}};
		
		if($scope.search.jmbg != ""){
			config.params.jmbg = $scope.search.jmbg;
		}
		if($scope.search.bankaId != ""){
			config.params.bankaId = $scope.search.bankaId;
		}
		config.params.pageNum = $scope.pageNum
		$http.get(url, config).then(
		function sucess(res) {
			$scope.racuni = res.data;
			$scope.totalPages = res.headers("totalPages");
		},
		function error() {
			alert("Greska")
		}
		)
	}
	getR();
	
	$scope.potvrdiBrisanje = function(id) {
		if(confirm("Da li ste sigurni da zelite da obrisete ovaj entitet?")){
			brisi(id);
		}
	}
		var brisi = function(id) {
		var urlb = url + "/" + id
		
		$http.delete(urlb).then(
		function success() {
			alert("Uspesno ste obrisali entitet")
			getR()
		},
		function error() {	
		}
		)
	}
		
		var nadjiB = function() {
			$http.get("/api/banke").then(
			function succes(res) {
				$scope.banke = res.data
				console.log(res.data)
			}, 
			function error() {
				alert("Greska banke")
			})
		}
	nadjiB();
	$scope.changePage = function(direction) {
		$scope.pageNum += direction;
		getR();
	}
	$scope.goToIzmena = function(id) {
		$location.path("/izmena/" + id)
	}
	$scope.goToPretraga = function() {
		getR();
	}
	$scope.ponistiPretragu = function() {
		$scope.search = {};
		getR();
	}
	
});