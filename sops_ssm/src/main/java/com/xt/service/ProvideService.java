package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.Provide;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/17 - 23:36
 */
@Transactional
public interface ProvideService extends IService<Provide> {
    IPage<Provide> getProvideByOpr(Page<Provide> page, String pname);
}
