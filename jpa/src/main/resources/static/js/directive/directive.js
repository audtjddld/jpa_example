//angular.module('routerApp')
myApp
.directive('userListBtn',function(){
	return {
		restrict : 'E',
		template :'<button type="button" class="btn btn-default" ng-click="list()">목록</button>'
	}
	
})
.directive('userDeleteBtn',function(){
	return {
		restrict : 'E',
		template :'<button type="button" class="btn btn-default" ng-click="deleteUser()">삭제</button>'
	}
	
})