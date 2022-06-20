package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.PuDao;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Pu;
import com.xt.service.PuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 20:19
 */
@Service
public class PuServiceImpl extends ServiceImpl<PuDao, Pu> implements PuService {

    @Autowired
    private PuDao puDao;

    @Override
    public Pu login(LoginFrom loginFrom) {
        QueryWrapper<Pu> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("loginname",loginFrom.getName());
        QueryWrapper.eq("password",loginFrom.getPassword());
        Pu pu = puDao.selectOne(QueryWrapper);
        return pu;
    }

    @Override
    public IPage<Pu> getProvideByOpr(Page<Pu> puPage, String warehouseid, String name, String manageType) {
        QueryWrapper<Pu> puQueryWrapper = new QueryWrapper<>();
        if(!"".equals(warehouseid)){
            puQueryWrapper.eq("warehouseid",warehouseid);
        }
        if(!StringUtils.isEmpty(name)){
            puQueryWrapper.like("name",name);
        }
        if(!"".equals(manageType)){
            puQueryWrapper.eq("manageid",manageType);
        }

        puQueryWrapper.orderByAsc("id");

        Page<Pu> page = puDao.selectPage(puPage, puQueryWrapper);
        return page;
    }
}
