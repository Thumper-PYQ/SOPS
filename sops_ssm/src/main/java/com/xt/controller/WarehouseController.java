package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.Provide;
import com.xt.pojo.Warehouse;
import com.xt.service.WarehouseService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 0:37
 */
@RestController
@RequestMapping("/warehouse")

public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    //条件查询的分页（多表联合）
    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllWarehouse(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @RequestParam("wid") String wid,
            @RequestParam("address") String address
    ){
        Page<Warehouse> page = new Page<>(pageNo, pageSize);

        IPage<Warehouse> pageRs = warehouseService.getProvideByOpr(page,wid,address);
        return Result.ok(pageRs);
    }

    @PostMapping()
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.saveOrUpdate(warehouse);
        return Result.ok();
    }

    @PutMapping("/update")
    public Result updateWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.saveOrUpdate(warehouse);
        return Result.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public Result deleteWarehouse(@PathVariable("ids") List<Integer> ids){
        warehouseService.removeByIds(ids);
        return Result.ok();
    }

}
