package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface TbBrandService {

    /**
     * 查询所有
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    public PageResult findPage(int page,int rows);

    /**
     * 添加
     * @param tbBrand
     */
    public void save(TbBrand tbBrand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public TbBrand findById(Long id);

    /**
     * 修改
     * @param tbBrand
     */
    public void update(TbBrand tbBrand);

    /**
     * 根据ids删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 模糊查询
     * @param tbBrand
     * @param page
     * @param size
     * @return
     */
    public PageResult findPage(TbBrand tbBrand,int page,int size);

    /**
     * 下拉列表
     * @return
     */
    public List<Map> selectOptionList();
}
