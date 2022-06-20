package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.Warehouse;
import com.xt.pojo.WarehouseOrder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:12
 */
@Transactional
public interface WarehouseOrderService extends IService<WarehouseOrder> {
    IPage<WarehouseOrder> getProvideByOpr(Page<WarehouseOrder> page, String status);
}
