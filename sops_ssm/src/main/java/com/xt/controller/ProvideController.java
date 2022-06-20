package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.Provide;
import com.xt.service.ProvideService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/17 - 23:39
 */
@RestController
@RequestMapping("/provide")
public class ProvideController {

    @Autowired
    private ProvideService provideService;

    /*
        http://localhost/provide/1/10?pname
     */
    //按条件分页查询商品
    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllProvide(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @RequestParam("pname") String pname
        ){
        //分页查询
        Page<Provide> page = new Page<>(pageNo, pageSize);
        //调用服务层提供的分页查询的方法
        IPage<Provide> pageRs = provideService.getProvideByOpr(page,pname);

        //封装Result对象并返回

        return Result.ok(pageRs);
    }

    //向数据库中添加数据
    /*
        http://localhost/provide   请求体：{
                                            "pid":12,
                                            "pname":"北大仓",
                                            "address":"黑龙江",
                                            "tele":13513513
                                        }
     */
    @PostMapping()
    public Result addProvide(@RequestBody Provide provid ){
        //调用服务处方法
        provideService.saveOrUpdate(provid);
        //封装结果集返回
        return Result.ok();
    }

    //修改商品信息
    /*
        http://localhost/provide/update
     */
    @PutMapping("/update")
    public Result updateProvide(@RequestBody Provide provide){

        provideService.saveOrUpdate(provide);

        return Result.ok();
    }

    //删除商品
    /*
        http://localhost/provide/delete/ids
     */
    @DeleteMapping("/delete/{ids}")
    public Result deleteProvide(@PathVariable("ids")List<Integer> ids){

        provideService.removeByIds(ids);
        return Result.ok();
    }
}
