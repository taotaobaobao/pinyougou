app.controller("loginController",function ($scope,$controller,loginService) {
    $scope.showLoginName=function () {
        loginService.loginName().success(
            function (respones) {
                $scope.loginName=respones.loginName;
            }
        )
    }
});