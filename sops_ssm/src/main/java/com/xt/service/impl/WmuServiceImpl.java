package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.WmuDao;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Su;
import com.xt.pojo.Wmu;
import com.xt.service.WmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 20:16
 */
@Service
public class WmuServiceImpl extends ServiceImpl<WmuDao, Wmu> implements WmuService {

    @Autowired
    private WmuDao wmuDao;

    @Override
    public Wmu login(LoginFrom loginFrom) {
        QueryWrapper<Wmu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname",loginFrom.getName());
        queryWrapper.eq("password",loginFrom.getPassword());
        Wmu wmu = wmuDao.selectOne(queryWrapper);
        return wmu;
    }

    @Override
    public IPage<Wmu> getWmuByOpr(Page<Wmu> wmuPage) {
        QueryWrapper<Wmu> wmuQueryWrapper = new QueryWrapper<>();
        Page<Wmu> wmuPage1 = wmuDao.selectPage(wmuPage, wmuQueryWrapper);
        return  wmuPage1;
    }
}
