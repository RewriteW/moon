package com.github.moon.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.common.utils.PageUtils;
import com.github.moon.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-27 09:56:57
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * @Description: 查出所有分类以及子分类，以树结构组装列表
     * @Param: []
     * @return: java.util.List<com.github.moon.product.entity.CategoryEntity>
     * @Author: wsg
     * @Date: 2021/2/27
     */
    List<CategoryEntity> listWithThree();
}

