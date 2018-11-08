package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class TbBrandController {

    @Reference
    private TbBrandService tbBrandService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll.do")
    public List<TbBrand> findAll(){
      return tbBrandService.findAll();
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/findPage.do")
    public PageResult findPage(int page,int rows){
        return tbBrandService.findPage(page,rows);
    }

    /**
     * 添加
     * @param tbBrand
     * @return
     */
    @RequestMapping("/findSave.do")
    public Result save(@RequestBody TbBrand tbBrand){
        try {
            tbBrandService.save(tbBrand);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public TbBrand findById(Long id){
        TbBrand byId = tbBrandService.findById(id);
        return byId;
    }

    /**
     * 修改
     * @param tbBrand
     * @return
     */
    @RequestMapping("/update.do")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            tbBrandService.update(tbBrand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */

    @RequestMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            tbBrandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除失败");
        }
    }

    /**
     * 模糊查询
     * @return
     */
    @RequestMapping("/search")
    public PageResult findPage(@RequestBody TbBrand tbBrand,int page,int rows){
        return tbBrandService.findPage(tbBrand,page,rows);
    }

    /**
     * 下拉列表
     * @return
     */
    @RequestMapping("/selectOptionList.do")
    List<Map> selectOptionList(){
        List<Map> maps = tbBrandService.selectOptionList();
        return maps;
    }
}
