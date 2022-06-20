package com.xt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.org.apache.xpath.internal.operations.Plus;
import com.xt.pojo.GoodsPlus;
import com.xt.pojo.Pu;
import com.xt.pojo.PuPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 10:59
 */
@Mapper
public interface PuPlusDao extends BaseMapper<PuPlus> {

    //使用pagehelper实现的分页
    List<PuPlus> getPu(@Param("puPlus") PuPlus puPlus );
}
