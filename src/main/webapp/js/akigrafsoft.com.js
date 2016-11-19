'use strict';

var akigrafsoft = angular.module('akigrafsoft', [ 'ngRoute', 'ngCookies',
		'fmkServices', 'fmkControllers', 'akigrafsoftControllers' ]);

akigrafsoft.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/company', {
		templateUrl : 'partials/company.html'
	}).when('/contact', {
		templateUrl : 'partials/contact.html'
	}).when('/home', {
		templateUrl : 'partials/home.html'
	}).when('/legal', {
		templateUrl : 'partials/legal.html'
	}).when('/portfolio', {
		templateUrl : 'partials/portfolio.html'
	}).when('/products', {
		templateUrl : 'partials/products.html'
	}).when('/technology', {
		templateUrl : 'partials/technology.html'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);

var akigrafsoftControllers = angular.module('akigrafsoftControllers', []);

akigrafsoftControllers.controller('MainController', [ '$rootScope', '$scope',
		'$timeout', '$filter', '$cookieStore',
		function($rootScope, $scope, $timeout, $filter, $cookieStore) {
			$rootScope.currentUser = null;
			$scope.LANG = 'fr';
			$scope.setLang = function(lang) {
				$scope.LANG = lang;
			};
		} ]);

