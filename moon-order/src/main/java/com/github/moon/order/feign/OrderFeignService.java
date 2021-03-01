package com.github.moon.order.feign;

import com.github.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wsg
 * @Date: 2021/02/24/20:39
 * @Description:
 */
@FeignClient("moon-order")
public interface OrderFeignService {

    /**
     * 信息
     */
    @RequestMapping("/order/order/info/{id}")
    public R info(@PathVariable("id") Long id);
}
