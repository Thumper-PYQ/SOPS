package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:32
 */
//@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("provide")
public class Provide {
    @TableId(value = "pid",type = IdType.AUTO)
    private Integer pid;
    private String pname;
    private String address;
    private String tele;
}
