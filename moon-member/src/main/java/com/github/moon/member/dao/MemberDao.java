package com.github.moon.member.dao;

import com.github.moon.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-26 16:14:38
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
