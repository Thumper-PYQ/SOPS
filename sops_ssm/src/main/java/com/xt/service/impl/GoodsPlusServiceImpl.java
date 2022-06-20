package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.dao.GoodsPlusDao;
import com.xt.pojo.Goods;
import com.xt.pojo.GoodsPlus;
import com.xt.service.GoodsPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 21:31
 */
@Service
public class GoodsPlusServiceImpl extends ServiceImpl<GoodsPlusDao, GoodsPlus> implements GoodsPlusService {

    @Autowired
    private GoodsPlusDao goodsPlusDao;

    @Override
    public PageInfo<GoodsPlus> getGoodsByOpr(GoodsPlus goodsPlus, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<GoodsPlus> goods = goodsPlusDao.getGoods(goodsPlus);
        PageInfo<GoodsPlus> goodsPlusPageInfo = new PageInfo<>(goods,pageSize);
        return goodsPlusPageInfo;
    }

}
