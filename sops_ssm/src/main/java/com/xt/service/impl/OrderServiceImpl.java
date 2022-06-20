package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.OrderDao;
import com.xt.pojo.Order;
import com.xt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 10:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public IPage<Order> getProvideByOpr(Page<Order> page, String ordertime, String overTime) {

        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();

        /*
        对前端传过来的时间做ordertime overtime做判断
         */
        if(!StringUtils.isEmpty(ordertime)){
            orderQueryWrapper.like("ordertime",ordertime);
        }
        if(!StringUtils.isEmpty(overTime)){
            orderQueryWrapper.like("overtime",overTime);
        }
        Page<Order> orderPage = orderDao.selectPage(page, orderQueryWrapper);

        return orderPage;
    }
}
