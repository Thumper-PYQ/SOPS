package com.xt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 15:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("province")
public class Province {
    private Integer id;
    private String name;
}
