package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xt.dao.GoodsPlusDao;
import com.xt.pojo.Goods;
import com.xt.pojo.GoodsPlus;
import org.springframework.transaction.annotation.Transactional;


/**
 * @auther PYQ
 * @createtime 2022/5/11 - 21:29
 */
@Transactional
public interface GoodsPlusService extends IService<GoodsPlus> {
    //自己写的分页功能

    //使用pagehelper实现的分页功能
    PageInfo<GoodsPlus> getGoodsByOpr(GoodsPlus goodsPlus,Integer pageNo,Integer pageSize);

}
