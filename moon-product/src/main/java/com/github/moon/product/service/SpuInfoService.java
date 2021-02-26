package com.github.moon.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.common.utils.PageUtils;
import com.github.moon.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-24 14:03:06
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

