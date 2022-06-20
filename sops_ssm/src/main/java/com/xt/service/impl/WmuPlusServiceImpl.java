package com.xt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.dao.WmuPlusDao;
import com.xt.pojo.WmuPlus;
import com.xt.service.WmuPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 17:02
 */
@Service
public class WmuPlusServiceImpl extends ServiceImpl<WmuPlusDao, WmuPlus> implements WmuPlusService {
    @Autowired
    private WmuPlusDao wmuPlusDao;

    @Override
    public PageInfo<WmuPlus> getProvideByOpr(WmuPlus wmuPlus, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<WmuPlus> wmus = wmuPlusDao.getWmu(wmuPlus);
        PageInfo<WmuPlus> wmuPlusPageInfo = new PageInfo<>(wmus, pageSize);
        return wmuPlusPageInfo;
    }
}
