package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("warehouse")
public class Warehouse {
    @TableId(value = "wid",type = IdType.AUTO)
    private Integer wid;
    private Integer managerid;
    private String address;
    private String tele;
    private String description;
}
