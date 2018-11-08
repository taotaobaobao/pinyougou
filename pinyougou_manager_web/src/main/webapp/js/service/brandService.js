app.service("brandService",function ($http) {
    //查询所有
    this.findAll=function () {
        return $http.get("../brand/findAll.do")
    };
    //分页查询
    this.findPage=function (page,rows) {
        return $http.get("../brand/findPage.do?"+'page='+page+'&rows='+rows)
    };

    //根据id查询
    this.findById=function (id) {
        return $http.get("../brand/findById.do?id="+id)
    };
    //添加
    this.findSave=function (entity) {
        return $http.post("../brand/findSave.do",entity)
    }
    //修改
    this.update=function (entity) {
        return $http.post("../brand/update.do",entity)
    };
    //删除
    this.delete=function (selectIds) {
        return $http.get("../brand/delete.do?ids="+selectIds)
    };

    this.search=function (page, rows,searchEntity) {
        return $http.post("../brand/search.do?page="+page+"&rows="+rows,searchEntity)
    }

    //下拉列表
    this.selectOptionList=function () {
        return $http.get("../brand/selectOptionList.do")

    }

});
