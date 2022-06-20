package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.WarehouseOrderDao;
import com.xt.pojo.Warehouse;
import com.xt.pojo.WarehouseOrder;
import com.xt.service.WarehouseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:14
 */
@Service
public class WarehouseOrderServiceImpl extends ServiceImpl<WarehouseOrderDao, WarehouseOrder> implements WarehouseOrderService {
    @Autowired
    private WarehouseOrderDao warehouseOrderDao;

    @Override
    public IPage<WarehouseOrder> getProvideByOpr(Page<WarehouseOrder> page, String status) {

        QueryWrapper<WarehouseOrder> warehouseOrderQueryWrapper = new QueryWrapper<>();

        if(!StringUtils.isEmpty(status)&&!"all".equals(status)){
            warehouseOrderQueryWrapper.eq("status",status);
        }
        warehouseOrderQueryWrapper.orderByAsc("ordertime");

        Page<WarehouseOrder> warehouseOrderPage = warehouseOrderDao.selectPage(page, warehouseOrderQueryWrapper);

        return warehouseOrderPage;
    }
}
