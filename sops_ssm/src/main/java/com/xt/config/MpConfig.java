package com.xt.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @auther PYQ
 * @createtime 2022/4/26 - 15:37
 */
@Configuration
public class MpConfig {

    //TODO 添加MyBatisPlus的sql语句的拦截器:MybatisPlus的分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义MP拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //2.添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //3.添加乐观锁拦截器
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    //TODO 添加Mybatis的Pagehelper拦截器:Pagehelper分页插件
    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("dialect","mysql");
//        properties.setProperty("offsetAsPageNum","false");
//        properties.setProperty("rowBoundsWithCount","false");
//        properties.setProperty("pageSizeZero","true");
//        properties.setProperty("reasonable","false");
//        properties.setProperty("supportMethodsArguments","false");
//        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
