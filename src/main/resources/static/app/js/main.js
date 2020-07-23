var myApp = angular.module('myApp');

//myApp.service('myService', function($http) {
	
//	this.getLinije = function() {
//		var url = "/api/linije"
//		$http.get(url).then(
//		function sucess(res) {
//			console.log(res.data)
//			return   res.data;
//		},
//		function error() {
//			alert("greska")
//		}
//		)
//	};
//});
	
myApp.controller("HomeCtrl", function($scope) {
	$scope.message = "JWD ispit 42";
});

//myApp.controller('PrikazCtrl', function($scope, myService) {
//	$scope.linije = [];
//	$scope.mojaFunkcija = function() {
//		$scope.podatci = myService.getLinije()
//	};
//	$scope.mojaFunkcija();
//	console.log($scope.podatci)
//});

myApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html'
		}).when('/prikaz', {
			templateUrl : '/app/html/prikaz.html'
		}).when('/dodavanje', {
			templateUrl : '/app/html/dodavanje.html'
		}).when('/izmena/:id', {
			templateUrl : '/app/html/izmena.html'
		}).when('/nalog', {
			templateUrl : '/app/html/nalog.html'
		}).when('/strana4', {
			templateUrl : '/app/html/strana4.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);