package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.PickOrder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:12
 */
@Transactional
public interface PickOrderService extends IService<PickOrder> {
    IPage<PickOrder> getProvideByOpr(Page<PickOrder> page, String status);
}
