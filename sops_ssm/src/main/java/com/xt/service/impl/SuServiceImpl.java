package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.SuDao;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Su;
import com.xt.service.SuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 11:03
 */
@Service
public class SuServiceImpl extends ServiceImpl<SuDao, Su> implements SuService {

    @Autowired
    private SuDao suDao;

    @Override
    public Su login(LoginFrom loginFrom) {
        QueryWrapper<Su> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginFrom.getName());
        queryWrapper.eq("password",loginFrom.getPassword());
        Su su = suDao.selectOne(queryWrapper);
        return su;
    }
}
