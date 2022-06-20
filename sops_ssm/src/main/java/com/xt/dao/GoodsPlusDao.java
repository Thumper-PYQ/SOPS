package com.xt.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt.pojo.GoodsPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 21:28
 */
@Mapper
public interface GoodsPlusDao extends BaseMapper<GoodsPlus> {


    //自己写的分页
    List<GoodsPlus> getAllGoods(@Param("goodsPlus") GoodsPlus goodsPlus , @Param("pageNo") Integer pageNo ,@Param("pageSize") Integer pageSize);

    //使用pagehelper实现的分页
    List<GoodsPlus> getGoods(@Param("goodsPlus") GoodsPlus goodsPlus );

}
