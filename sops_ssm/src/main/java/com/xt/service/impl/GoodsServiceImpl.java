package com.xt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xt.dao.GoodsDao;
import com.xt.pojo.Goods;
import com.xt.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 23:06
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao,Goods> implements GoodsService {

/*    @Autowired
    private GoodsDao goodsDao;

    @Override
    public boolean save(Goods goods) {
        return goodsDao.save(goods)>0;
    }

    @Override
    public boolean update(Goods goods) {
        return goodsDao.update(goods)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return goodsDao.delete(id)>0;
    }

    @Override
    public Goods selectById(Integer id) {
        return goodsDao.selectById(id);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsDao.selectAll();
    }*/
}
