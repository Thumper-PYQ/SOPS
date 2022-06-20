package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 22:55
 */

@Data
@TableName("goods")
public class GoodsPlus {
    @TableId(value = "gid",type = IdType.AUTO)
    private Integer gid;
    private String gname;
    private Integer provideid;
    private Integer numbers;
    private String description;
    //多表链接查询

    private Provide provide;
}
