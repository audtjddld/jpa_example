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
				$http.get('/rest/users',{params:params}).success(
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
		commonFnc($scope, $state);
		// 이메일 중복체크
		$scope.emailChk = function (){
			if($scope.user.email != undefined && $scope.user.email.length > 3){
				$http.get('/rest/email/exist',{params : $scope.user}).success(function(length){
					console.log(length);
					 if(length > 0){
						 $scope.duplicate = true;
						 $scope.emailTxt = '이미 등록되어있습니다.';
						 
					 }else{
						 $scope.duplicate = true;
						 $scope.emailTxt = '사용하실 수 있습니다.';
					 }
				});
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
			
			// 주소 담는 부분 추가
			var addressArr = [];
			
			for(var prop in params){
				if(prop == 'address1') addressArr.push(params[prop]);
				if(prop == 'address2') addressArr.push(params[prop]);
				if(prop == 'address3') addressArr.push(params[prop]);
			}
			
			$http.post('/rest/users',params).success(function(){
				alert('등록되었습니다');
				$state.go('userList');
			});
		}
		
	})
	// 상세조회
	.controller('userViewCtrl',function($scope, $state, $http,$stateParams){
		
		commonFnc($scope, $state, $http);
		
		$http.get('/rest/users/' + $stateParams.id)
							.success(function(data){
								
		    console.log(data);
			$scope.user = data;
			
			// 친구목록 가져오기
			userFriendList($scope);			
		});
		
		
		// 서브밋
		$scope.submitForm = function(form) {
			console.log('submit');
			if(form.$valid == false){
				alert('입력 오류');
				return ;
			}
			
			console.log($scope.user.friends);
			
			$http
				.put('/rest/users/'+$scope.user._id +"/friends", $scope.friend)
					.success(function(data){
		
				alert('등록되었습니다');
				$scope.friend='';
				userFriendList($scope);
			});
		}		

		// 친구목록 가져오기
		function userFriendList($scope){
			$http.get('/rest/users/'+$scope.user._id+"/friends")
					.success(function(data){
				
				$scope.user.friends = data;
				
			})
		}
	})
	// 정보 수정
	.controller('userUpdateCtrl',function($scope, $state, $http, $stateParams){
		$http.get('/rest/users/' + $stateParams.id)
							.success(function(data){
								
		    console.log(data);
			$scope.user = data;
		});		
		
		// 서브밋
		$scope.submitForm = function(form) {
			console.log('submit');
			if(form.$valid == false){
				alert('입력 오류');
				return ;
			}
			// 사용자 정보 수정
			$http.put('/rest/users',$scope.user)
				.success(function(){
				
				alert('수정하였습니다.');
				
				$state.go('userDetail',{id:$scope.user._id});
			})
		}			
	})
;

// 공통함수 선언
function commonFnc($scope, $state, $http){
	
	$scope.list = function(){
		$state.go('userList');
	}
	
	// 삭제 
	$scope.deleteUser = function(){
		$http.delete('/rest/users/' + $scope.user._id ).success(function(){
			alert('삭제되었습니다.');
			$state.go('userList');
	   });		
	}
	
}