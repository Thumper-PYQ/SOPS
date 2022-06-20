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
@TableName("shelve")
public class Shelve {
    @TableId(value = "sid",type = IdType.INPUT)
    private Integer sid;
    private Integer warehouseid;
}
