app.controller("logController",function ($scope,$controller,logService) {
    $scope.showLoginName=function () {
        logService.loginName().success(
            function (respones) {
               $scope.loginName=respones.loginName;
            }
        )
    }
});