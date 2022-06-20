package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.PickOrderDao;
import com.xt.pojo.PickOrder;
import com.xt.service.PickOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.ParagraphView;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:14
 */
@Service
public class PickOrderServiceImpl extends ServiceImpl<PickOrderDao, PickOrder> implements PickOrderService {
    @Autowired
    private PickOrderDao pickOrderDao;
    @Override
    public IPage<PickOrder> getProvideByOpr(Page<PickOrder> page, String status) {
        QueryWrapper<PickOrder> pickOrderQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(status)&&!"all".equals(status)){
            pickOrderQueryWrapper.eq("status",status);
        }
        pickOrderQueryWrapper.orderByAsc("arrivetime");

        Page<PickOrder> pickOrderPage = pickOrderDao.selectPage(page, pickOrderQueryWrapper);

        return pickOrderPage;
    }
}
