package com.xt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt.pojo.PuPlus;
import com.xt.pojo.Wmu;
import com.xt.pojo.WmuPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 10:59
 */
@Mapper
public interface WmuPlusDao extends BaseMapper<WmuPlus> {
    //使用pagehelper实现的分页
    List<WmuPlus> getWmu(@Param("wmuPlus") WmuPlus wmuPlus );
}
