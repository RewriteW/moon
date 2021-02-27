package com.github.moon.ware.dao;

import com.github.moon.ware.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-26 16:16:04
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
