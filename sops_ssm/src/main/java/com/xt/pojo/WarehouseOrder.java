package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("warehouseorder")
public class WarehouseOrder {
    @TableId(value = "id" ,type = IdType.INPUT)
    private Integer id;
    private Integer orderleve;
    private String goodslist;
    private String address;
    private String ordertime;
    private String overtime;
    private Integer status;
}
