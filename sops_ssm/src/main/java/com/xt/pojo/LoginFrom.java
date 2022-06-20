package com.xt.pojo;

import lombok.Data;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 10:47
 */
@Data
public class LoginFrom {
    private String name;
    private String password;
    private String verifiCode;
    private String userProp;
}
