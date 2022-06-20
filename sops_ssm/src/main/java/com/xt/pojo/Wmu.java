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
@TableName("wmu")
public class Wmu {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String tele;
    private String loginname;
    private String password;
}
