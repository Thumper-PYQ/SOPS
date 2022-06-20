package com.xt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt.pojo.Goods;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 23:00
 */
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {

/*    @Insert("insert into goods values(null,#{provideid},#{gname},#{numbers},#{description})")
    public int save(Goods goods);

    @Update("update goods set provideid=#{provideid},gname=#{name},numbers=#{numbers},description=#{description} where gid=#{id}")
    public int update(Goods goods);

    @Delete("delete from goods where gid=#{id}")
    public int delete(Integer id);

    @Select("select * from goods where gid=#{id}")
    public Goods selectById(Integer id);

    @Select("select * from goods")
    public List<Goods> selectAll();*/

}
