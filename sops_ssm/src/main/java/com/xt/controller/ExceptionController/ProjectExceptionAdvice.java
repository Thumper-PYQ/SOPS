package com.xt.controller.ExceptionController;


import com.xt.exception.BusinessException;
import com.xt.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther PYQ
 * @createtime 2022/4/26 - 11:25
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    @ExceptionHandler(SystemException.class)
//    public Result doSystemException(SystemException ex){
//        //记录日志
//        //发消息给运维
//        //发送邮件给开发人员，ex对象发送给开发人员
//        return new Result(ex.getCode(),null,ex.getMessage());
//    }
//
//
//    @ExceptionHandler(BusinessException.class)
//    public Result doBusinessException(BusinessException ex){
//        return new Result(ex.getCode(),null, ex.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    public Result doOtherException(Exception ex){
//        //记录日志
//        //发消息给运维
//        //发送邮件给开发人员，ex对象发送给开发人员
//        return new Result(Code.SYSTEM_UNKONW_ERR,null,"系统繁忙，请稍后重试！");
//    }



}
