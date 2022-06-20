package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 22:55
 */
@Data
@TableName("goods")
public class Goods {
    @TableId(value = "gid",type = IdType.INPUT)
    private Integer gid;
    private String gname;
    private Integer provideid;
    private Integer numbers;
    private String description;
}
