package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.xt.pojo.*;
import com.xt.service.PuService;
import com.xt.service.WmuPlusService;
import com.xt.service.WmuService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/4 - 11:07
 */
@RestController
@RequestMapping()
public class StaffController {
    @Autowired
    private PuService puService;
    @Autowired
    private WmuService wmuService;
    @Autowired
    private WmuPlusService wmuPlusService;


    //按条件分页查询所有的仓库管理员信息
    @GetMapping("wmu/{pageNo}/{pageSize}")
    public Result getAllWmu(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,

            //仓库id
            @RequestParam("warehouseid") Integer warehouseid,
            //仓库地址
            @RequestParam("address") String address,
            @RequestParam("manageName") String manageName
    ){
        WmuPlus wmuPlus = new WmuPlus();
        Warehouse warehouse = new Warehouse();
        if(warehouseid!=-1){
            warehouse.setWid(warehouseid);
        }
        if(!"null".equals(address)){
            warehouse.setAddress("%"+address+"%");
            wmuPlus.setWarehouse(warehouse);
        }
        if(!"null".equals(manageName)){
            wmuPlus.setName("%"+manageName+"%");
        }


        PageInfo<WmuPlus> pageRs = wmuPlusService.getProvideByOpr(wmuPlus,pageNo,pageSize);

        return Result.ok(pageRs);
    }

    //普通分页查询（单表）
    @GetMapping("/single/{pageNo}/{pageSize}")
    public Result getWmu(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize
    ){
        Page<Wmu> wmuPage = new Page<>(pageNo, pageSize);
        IPage<Wmu> pageRs = wmuService.getWmuByOpr(wmuPage);

        return Result.ok(pageRs);
    }

    //按条件分页查询所有的拣货员信息
    @GetMapping("pu/{pageNo}/{pageSize}")
    public Result getAllPu(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,

            @RequestParam("warehouseid") String warehouseid,
            @RequestParam("name") String name,
            @RequestParam("manageType") String manageType
    ){

        Page<Pu> puPage = new Page<>(pageNo,pageSize);
        IPage<Pu> pageRs = puService.getProvideByOpr(puPage,warehouseid,name,manageType);

        return Result.ok(pageRs);
    }

    @PostMapping("/wmu")
    public Result saveWmu(@RequestBody Wmu wmu){
        //接收参数
        //调用服务层方法完成添加或修改方法
        wmuService.saveOrUpdate(wmu);
        return Result.ok();
    }

    @PostMapping("/pu")
    public Result savePu(@RequestBody Pu pu){
        //接收参数
        //调用服务层方法完成添加或修改方法
        puService.saveOrUpdate(pu);
        return Result.ok();
    }

    //需要加上路径，如果不写二级路径就会出现405错误
    @PutMapping("/wmu/update")
    public Result updateWmu(@RequestBody Wmu wmu){

        wmuService.saveOrUpdate(wmu);
        return Result.ok();
    }

    @PutMapping("/pu/update")
    public Result updatePu(@RequestBody Pu pu){

        puService.saveOrUpdate(pu);
        return Result.ok();
    }

    //删除商品,根据商品的id单个删除或批量删除商品
    @DeleteMapping("/wmu/delete/{ids}")
    public Result deleteWmu(@PathVariable("ids") List<Integer> gids){
        //调用service层方法
        wmuService.removeByIds(gids);
        return Result.ok();
    }

    @DeleteMapping("/pu/delete/{ids}")
    public Result deletePu(@PathVariable("ids") List<Integer> gids){
        //调用service层方法
        puService.removeByIds(gids);
        return Result.ok();
    }

}
