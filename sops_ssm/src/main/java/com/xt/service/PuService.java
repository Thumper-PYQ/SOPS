package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Pu;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 20:15
 */
@Transactional
public interface PuService extends IService<Pu> {

    Pu login(LoginFrom loginFrom);

    IPage<Pu> getProvideByOpr(Page<Pu> puPage, String warehouseid, String name, String manageType);
}
