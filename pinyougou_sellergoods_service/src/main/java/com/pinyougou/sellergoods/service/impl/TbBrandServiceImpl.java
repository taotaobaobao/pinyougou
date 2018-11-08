package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.TbBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service()
public class TbBrandServiceImpl implements TbBrandService {
    @Autowired
    private TbBrandMapper mapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        List<TbBrand> tbBrands = mapper.selectByExample(null);
        return tbBrands;
    }

    /**
     * 分页查询
     * @param page  总页码
     * @param rows  当前的条数
     * @return
     */
    @Override
    public PageResult findPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        Page<TbBrand> pages = (Page<TbBrand>) mapper.selectByExample(null);
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    /**
     * 添加
     * @param tbBrand
     */
    @Override
    public void save(TbBrand tbBrand) {
        mapper.insert(tbBrand);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public TbBrand findById(Long id) {
        TbBrand tbBrand = mapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    /**
     * 修改
     * @param tbBrand
     */
    @Override
    public void update(TbBrand tbBrand) {
        mapper.updateByPrimaryKey(tbBrand);
    }

    /**
     * 根据id删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 模糊查询
     * @param tbBrand
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult findPage(TbBrand tbBrand, int page, int size) {
        PageHelper.startPage(page,size);
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(tbBrand!=null){
            if(tbBrand.getName()!=null && tbBrand.getName().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }

            if(tbBrand.getFirstChar()!=null && tbBrand.getFirstChar().length()>0){
            criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
            }
        }
        Page<TbBrand> pages = (Page<TbBrand>) mapper.selectByExample(example);

        return new PageResult(pages.getTotal(),pages.getResult());
    }

    /**
     * 下拉列表
     * @return
     */
    @Override
    public List<Map> selectOptionList() {
        List<Map> maps = mapper.selectOptionList();
        return maps;
    }
}
