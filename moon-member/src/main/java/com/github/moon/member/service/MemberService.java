package com.github.moon.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.common.utils.PageUtils;
import com.github.moon.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-26 16:14:38
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

