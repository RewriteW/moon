package com.github.moon.product.dao;

import com.github.moon.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-27 09:56:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
