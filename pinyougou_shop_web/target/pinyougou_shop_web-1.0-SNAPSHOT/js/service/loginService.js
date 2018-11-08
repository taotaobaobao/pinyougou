app.service("logService",function ($http) {
    this.loginName=function () {
      return $http.get("../login/name.do")
    }
});