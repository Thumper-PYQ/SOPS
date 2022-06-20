package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pickorder")
public class PickOrder {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    private Integer orderid;
    private Integer pickid;
    private Integer orderleve;
    private String goodslist;
    private String arrivetime;
    private String overtime;
    private Integer status;
}
