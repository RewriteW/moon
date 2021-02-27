package com.github.moon.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.common.utils.PageUtils;
import com.github.moon.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-27 09:56:57
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

