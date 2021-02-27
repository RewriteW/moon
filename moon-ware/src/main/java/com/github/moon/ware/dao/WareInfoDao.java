package com.github.moon.ware.dao;

import com.github.moon.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-26 16:16:04
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
