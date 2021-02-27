package com.github.moon.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.common.utils.PageUtils;
import com.github.common.utils.Query;

import com.github.moon.product.dao.CategoryDao;
import com.github.moon.product.entity.CategoryEntity;
import com.github.moon.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @Description: 查出所有分类以及子分类，以树结构组装列表
     * @Param: []
     * @return: java.util.List<com.github.moon.product.entity.CategoryEntity>
     * @Author: wsg
     * @Date: 2021/2/27
     */
    @Override
    public List<CategoryEntity> listWithThree() {
        //1、查出所有分类
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(null);
        //2、组装父子结构

        return categoryEntityList;
    }

}