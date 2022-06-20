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
@TableName("pu")
public class Pu {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String tele;
    private String loginname;
    private String password;
    private Integer warehouseid;
    private Integer manageid;
    private Integer totalcount;
    private Integer errorcount;
}
