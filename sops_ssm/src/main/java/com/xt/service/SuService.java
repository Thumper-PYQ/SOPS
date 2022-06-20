package com.xt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xt.pojo.LoginFrom;
import com.xt.pojo.Su;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 11:01
 */
@Transactional
public interface SuService extends IService<Su> {
     Su login(LoginFrom loginFrom);

}
