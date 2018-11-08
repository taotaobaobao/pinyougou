app.controller("baseController",function ($scope) {
    //共性分页
    $scope.paginationConf = {
        currentPage:1,		//当前页码
        totalItems:10,		//总条数
        itemsPerPage:10,	//每页显示总记录数
        perPageOptions:[10,20,30,40,50],  //页码选项
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };
    //刷新
    $scope.reloadList=function () {
        $scope.search( $scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage)
    };


    //定义一个要删除的数组
    $scope.selectIds=[];
    $scope.updateSelection=function ($event,id) {
        if($event.target.checked){
            $scope.selectIds.push(id)
        }else {
            var number = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(number,1);
        }
    };

    //拼接新的字符串

    $scope.jsonToString=function (jsonString,key) {
        var json=JSON.parse(jsonString);
        var value="";
        for(var i=0;i<json.length;i++){

            if(i>0){
                value+=",";
            }
          value += json[i][key]

        }
        return value;

    }








});