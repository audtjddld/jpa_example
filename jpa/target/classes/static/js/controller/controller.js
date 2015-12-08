//angular.module('routerApp')
myApp
// 데이터 리스트 페이지
.controller(
		'userListCtrl',
		function($scope, $http, $stateParams, $location, $state, $rootScope) {
			// 리스트 검색
			$scope.search = function() {
				// 객체 복사
				var params = angular.copy($scope.pagingInfo);
				console.log(params);
				for(param in params) {
					
					if (param == 'page') {
						params[param]--;
						// 2015.12.03 추가
						if(!params[param]) params[param] = 0;	
					}
				}
				
				/**/
				$http.get('/rest/user/list',{params:params}).success(
						function(dataList) {
							console.log('success');
							console.log($scope.pagingInfo);
							console.log(dataList);
							// console.log('reload ' + $scope.pagingInfo.page);
							$scope.currentPage = $scope.pagingInfo.page;
							$scope.pagePerCnt = $scope.pagingInfo.pagePerCnt;
							
							$scope.totalCnt = dataList.length;
							$scope.offset = ($scope.currentPage -1)	* $scope.pagePerCnt;
							// console.log($scope.pagingInfo);

							// 로컬스토리지에 저장
							$scope.data = dataList;
							$location.search($scope.pagingInfo);
						})
				/**/

			}

			// 페이지 인포 객체가 없으면 한번 초기화
			if ($scope.pagingInfo == undefined) {
				
				$scope.pagingInfo = {
					page : 1,
					pagePerCnt : 10
				};
				
				// url 파라미터에 있는 내용에 따른 검색 파라미터 설정
				
				var obj = $location.search();
				if(obj.page != undefined){
					$scope.pagingInfo.page = obj.page;
				}
				
				$scope.search();
			}


			// 페이징 버튼 클릭시 이벤트
			$scope.pageChanged = function() {

				// console.log('query ' + $scope.query);
				$scope.pagingInfo.page = $scope.currentPage;
				
				$scope.search();
			};
		})
	.controller('userWriteCtrl', function($scope, $stateParams, $http, $compile, $state){

		// 이메일 중복체크
		function emailChk(){
			if($scope.email.length > 0){
				var emailAddr = $scope.email + '@' + $scope.emailDomain;
				
				$http.get('/rest/email/exist',{email: emailAddr}).success(function(length){
					 if(length > 0){
						 emailChk = true;
						 emailTxt = '이미 등록되어있습니다.';
						 
					 }else{
						 emailChk = true;
						 emailTxt = '사용하실 수 있습니다.';
					 }
				});
			}
		}
		
		// 친구 추가,삭제
		$scope.addFriend = function(){
			if($scope.user.friends.length < 5){
				$scope.user.friends.push({friend:''});	
			}else{
				alert('친구는 최고 5명까지 입력가능합니다.');
				return;
			}
			
		}
		
		// 친구 삭제 버튼
		$scope.minusFriend = function(){
			if($scope.user.friends.length >1 ){
				$scope.user.friends.pop();	
			}else{
				alert('친구는 최소 1개는 입력해야됩니다.');
				return;
			}
			
		}
		
		// 서브밋
		$scope.submitForm = function(form) {
			console.log('submit');
			if(form.$valid == false){
				alert('입력 오류');
				return ;
			}
			
			console.log($scope.user);
			var params = angular.copy($scope.user);
			
			$http.get('/rest/user/save',{params:params}).success(function(){
				
				alert('등록되었습니다');
				$state.go('user');
				
			});
					
			
		}
		
	})

;
