package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.Shelve;
import com.xt.pojo.ShelveArea;
import com.xt.pojo.Warehouse;
import com.xt.service.ShelveAreaService;
import com.xt.service.ShelveService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 17:31
 */
@RestController
@RequestMapping("/shelvearea")
public class ShelveAreaController {
    @Autowired
    private ShelveService shelveService;
    @Autowired
    private ShelveAreaService shelveAreaService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllShelveArea(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,

            @RequestParam("shelveid") String shelveid,
            @RequestParam("said") String said,
            @RequestParam("goodid") String goodid
    ){

        Page<ShelveArea> page = new Page<>(pageNo, pageSize);

        IPage<ShelveArea> pageRs = shelveAreaService.getProvideByOpr(page,shelveid,said,goodid);
        return Result.ok(pageRs);
    }
    //添加货架
    @PostMapping("/shelve")
    public Result addShelve(@RequestBody Shelve shelve){
        shelveService.saveOrUpdate(shelve);
        return Result.ok();
    }

    //添加分区
    @PostMapping("/area")
    public Result addShelveArea(@RequestBody ShelveArea shelveArea){
        shelveAreaService.saveOrUpdate(shelveArea);
        return Result.ok();
    }

    //更新货架分区对应的商品
    @PutMapping("/update")
    public Result updateShelveArea(@RequestBody ShelveArea shelveArea){
        shelveAreaService.saveOrUpdate(shelveArea);
        return Result.ok();
    }

    //删除该货架分区
    //货架分区表中不可以批量删除
    @DeleteMapping("/delete/{ids}")
    public Result deleteShelveArea(@PathVariable("ids") List<Integer> ids){
        shelveAreaService.removeByIds(ids);
        return Result.ok();
    }

}
