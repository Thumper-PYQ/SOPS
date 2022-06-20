package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.Order;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 10:53
 */
@Transactional
public interface OrderService extends IService<Order> {

    IPage<Order> getProvideByOpr(Page<Order> page, String ordertime, String overTime);
}
