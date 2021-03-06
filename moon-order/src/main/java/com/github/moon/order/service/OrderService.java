package com.github.moon.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.common.utils.PageUtils;
import com.github.moon.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-26 16:11:43
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

