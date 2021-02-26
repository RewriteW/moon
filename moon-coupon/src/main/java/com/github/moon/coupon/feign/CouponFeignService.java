package com.github.moon.coupon.feign;

import com.github.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wsg
 * @Date: 2021/02/24/20:39
 * @Description:
 */
@FeignClient("moon-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
