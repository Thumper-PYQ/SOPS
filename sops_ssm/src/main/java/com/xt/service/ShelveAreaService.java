package com.xt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.ShelveArea;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 17:28
 */
@Transactional
public interface ShelveAreaService extends IService<ShelveArea> {
    IPage<ShelveArea> getProvideByOpr(Page<ShelveArea> page, String shelveid, String said, String goodid);
}
