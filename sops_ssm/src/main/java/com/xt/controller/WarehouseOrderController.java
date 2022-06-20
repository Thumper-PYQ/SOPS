package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.Warehouse;
import com.xt.pojo.WarehouseOrder;
import com.xt.service.WarehouseOrderService;
import com.xt.service.WarehouseService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:20
 */
@RestController
@RequestMapping("/warehouseorder")
public class WarehouseOrderController {

    @Autowired
    private WarehouseOrderService warehouseOrderService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllWarehouseorder(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @RequestParam("status") String status
    ){
        Page<WarehouseOrder> page = new Page<>(pageNo, pageSize);

        IPage<WarehouseOrder> pageRs = warehouseOrderService.getProvideByOpr(page,status);
        return Result.ok(pageRs);
    }

    @PostMapping()
    public Result addWarehouseorder(@RequestBody WarehouseOrder warehouseOrder){
        warehouseOrderService.saveOrUpdate(warehouseOrder);
        return Result.ok();
    }

    @PutMapping("/update")
    public Result updateWarehouseorder(@RequestBody WarehouseOrder warehouseOrder){
        warehouseOrderService.saveOrUpdate(warehouseOrder);
        return Result.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public Result deleteWarehouseorder(@PathVariable("ids") List<Integer> ids){
        warehouseOrderService.removeByIds(ids);
        return Result.ok();
    }
}
