app.controller("brandController",function ($scope,$http,brandService,$controller) {

    $controller("baseController",{$scope:$scope});
    //查询所有
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        )
    };

    //分页

    $scope.findPage=function (page,rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            })
    };

    //添加和修改
    $scope.save=function () {
        var object=null;
        if($scope.entity.id!=null){
            object=brandService.update($scope.entity);
        }else {
            object=brandService.findSave($scope.entity);
        }
        object.success(
            function (response) {
                if(response.success){
                    $scope.reloadList;
                }else {
                    alert(response.message);
                }
            }
        )
    }
    //根据id查询
    $scope.findById=function (id) {
        brandService.findById(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    };



    //删除
    $scope.delete=function () {
        if(confirm("确定删除吗")){
            brandService.delete($scope.selectIds).success(
                function (response) {
                    if(response.success){
                        $scope.reloadList()
                    }else {
                        alert("删除失败")
                    }
                }
            )
        }
    };

    //模糊查询
    $scope.searchEntity={};
    $scope.search=function (page,rows) {

        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total;
                $scope.list=response.rows;
            }
        )
    }

});