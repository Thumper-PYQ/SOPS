package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.Warehouse;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 0:34
 */
@Transactional
public interface WarehouseService extends IService<Warehouse> {
    IPage<Warehouse> getProvideByOpr(Page<Warehouse> page, String wid, String address);
}
