package com.xt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.WarehouseDao;
import com.xt.pojo.Warehouse;
import com.xt.service.WarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 0:35
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao, Warehouse> implements WarehouseService {
    @Override
    public IPage<Warehouse> getProvideByOpr(Page<Warehouse> page, String wid, String address) {
        QueryWrapper<Warehouse> warehouseQueryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(wid)) {
            warehouseQueryWrapper.eq("wid",wid);
        }
        if (!StringUtils.isEmpty(address)) {
            warehouseQueryWrapper.like("address",address);
        }

        Page<Warehouse> warehousePage = baseMapper.selectPage(page, warehouseQueryWrapper);

        return warehousePage;
    }
}
