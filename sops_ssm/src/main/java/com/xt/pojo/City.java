package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("city")
public class City {
    private Integer id;
    private Integer provinceid;
    private String name;
}
