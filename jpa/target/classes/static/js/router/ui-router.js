myApp.config(function($locationProvider, $stateProvider, $urlRouterProvider) {

	// html5 모드
	$locationProvider.html5Mode(true).hashPrefix('!');
	$urlRouterProvider.otherwise("/");

	$stateProvider

	// 사용자
	.state('userList', {
		url : "/user/list",
		templateUrl : '/js/user/list.html',
		controller : 'userListCtrl'

	})
	// 상세보기
	.state('userDetail', {
		url : "^/user/detail/:id?page&offset",
		templateUrl : '/js/user/view.html',
		controller : 'userViewCtrl'
	})
	// 작성 페이지
	.state('userWrite', {
		url : "^/user/write",
		templateUrl : '/js/user/write.html',
		controller : 'userWriteCtrl'
	})
	.state('userUpdate',{
		url : "^/user/update/:id",
		templateUrl : '/js/user/update.html',
		controller : 'userUpdateCtrl'
	})

});
