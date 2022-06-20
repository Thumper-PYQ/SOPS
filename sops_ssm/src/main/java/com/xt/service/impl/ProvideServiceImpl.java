package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.ProvideDao;
import com.xt.pojo.Provide;
import com.xt.service.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther PYQ
 * @createtime 2022/5/17 - 23:37
 */
@Service
public class ProvideServiceImpl extends ServiceImpl<ProvideDao, Provide> implements ProvideService {
    @Autowired
    private ProvideDao provideDao;

    @Override
    public IPage<Provide> getProvideByOpr(Page<Provide> page, String pname) {
        QueryWrapper<Provide> provideQueryWrapper = new QueryWrapper<>();

        //对参数pname做空判断
        if (!StringUtils.isEmpty(pname)) {
            provideQueryWrapper.like("pname",pname);
        }

        provideQueryWrapper.orderByAsc("pid");

        Page<Provide> providePage = provideDao.selectPage(page, provideQueryWrapper);

        return providePage;
    }
}
