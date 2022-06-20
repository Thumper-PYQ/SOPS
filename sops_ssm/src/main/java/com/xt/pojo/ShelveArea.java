package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shelvearea")
public class ShelveArea {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer said;
    private Integer shelveid;
    private Integer warehouseid;
    private Integer goodid;
}
