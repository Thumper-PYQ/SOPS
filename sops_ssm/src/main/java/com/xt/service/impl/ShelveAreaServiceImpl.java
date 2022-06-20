package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.ShelveAreaDao;
import com.xt.pojo.ShelveArea;
import com.xt.service.ShelveAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 17:28
 */
@Service
public class ShelveAreaServiceImpl extends ServiceImpl<ShelveAreaDao,ShelveArea> implements ShelveAreaService {

    @Autowired
    private ShelveAreaDao shelveAreaDao;
    @Override
    public IPage<ShelveArea> getProvideByOpr(Page<ShelveArea> page, String shelveid, String said, String goodid) {
        QueryWrapper<ShelveArea> shelveAreaQueryWrapper = new QueryWrapper<>();
        if(!"".equals(shelveid)){
            shelveAreaQueryWrapper.eq("shelveid",shelveid);
        }
        if(!"".equals(said)){
            shelveAreaQueryWrapper.eq("said",said);
        }
        if(!"".equals(goodid)){
            shelveAreaQueryWrapper.eq("goodid",goodid);
        }

        Page<ShelveArea> shelveAreaPage = shelveAreaDao.selectPage(page, shelveAreaQueryWrapper);

        return shelveAreaPage;
    }
}
