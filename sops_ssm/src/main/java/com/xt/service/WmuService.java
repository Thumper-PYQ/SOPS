package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Wmu;
import com.xt.pojo.WmuPlus;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 20:14
 */
@Transactional
public interface WmuService extends IService<Wmu> {
    Wmu login(LoginFrom loginFrom);

    IPage<Wmu> getWmuByOpr(Page<Wmu> wmuPage);
}
