package com.github.moon.coupon.dao;

import com.github.moon.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-24 20:32:51
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
