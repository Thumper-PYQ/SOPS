package com.xt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.Goods;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 23:04
 */

@Transactional
public interface GoodsService extends IService<Goods>{
/*    public boolean save(Goods goods);

    public boolean update(Goods goods);

    public boolean delete(Integer id);

    public Goods selectById(Integer id);

    public List<Goods> selectAll();*/
}
