package com.xt.controller;

import com.github.pagehelper.PageInfo;
import com.xt.pojo.Goods;
import com.xt.pojo.GoodsPlus;
import com.xt.pojo.Provide;
import com.xt.service.GoodsPlusService;
import com.xt.service.GoodsService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/11 - 21:41
 */
@RestController
@RequestMapping("/goodsplus")
public class GoodsPlusController {

    @Autowired
    private GoodsPlusService goodsPlusService;

    @Autowired
    private GoodsService goodsService;

    // 前端请求：goodsplus/1/10/?goodsId=xxx&goodsName=xxx&provideName=xxx&goodsDescription=xxx

    // 带条件的分页查询的实现
    @GetMapping("/{pageNo}/{pageSize}")
    public Result getGoods(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,

            @RequestParam("goodsId") Integer goodsId,
            @RequestParam("goodsName") String goodsName,
            @RequestParam("provideName") String provideName,
            @RequestParam("goodsDescription") String goodsDescription
            ){

        /*
         TODO 由于不知道怎么处理get中的请求参数可传可不传问题，所以前端用户没有输入按条件的搜索的话，就默认设置前端的各个
          搜索框中的值：数字类型的默认值为-1，字符串类型的默认值为null
         */
        GoodsPlus goodsPlus = new GoodsPlus();
        Provide provide = new Provide();
        if(goodsId!=-1){
            goodsPlus.setGid(goodsId);
        }
        if(!"null".equals(goodsName)){
            goodsPlus.setGname("%"+goodsName+"%");
        }
        if(!"null".equals(provideName)){
            provide.setPname("%"+provideName+"%");
            goodsPlus.setProvide(provide);
        }
        if(!"null".equals(goodsDescription)){
            goodsPlus.setDescription("%"+goodsDescription+"%");
        }

        PageInfo<GoodsPlus> pageRs = goodsPlusService.getGoodsByOpr(goodsPlus, pageNo, pageSize);

        System.out.println(pageRs);

        //封装Result对象并返回
        return Result.ok(pageRs);
    }


    //前端请求:前端添加和修改商品信息都是用post请求，put请求不被允许，暂时还没有解决
    @PostMapping
    public Result saveGoods(@RequestBody Goods goods){
        //接收参数
        //调用服务层方法完成添加或修改方法
        goodsService.saveOrUpdate(goods);
        return Result.ok();
    }

    //需要加上路径，如果不写二级路径就会出现405错误
    @PutMapping("/update")
    public Result updateGoods(@RequestBody Goods goods){

        goodsService.saveOrUpdate(goods);
        return Result.ok();
    }

    //删除商品,根据商品的id单个删除或批量删除商品
    @DeleteMapping("/delete/{ids}")
    public Result deleteGoods(@PathVariable("ids") List<Integer> gids){
        //调用service层方法
        goodsService.removeByIds(gids);
        return Result.ok();
    }

}
