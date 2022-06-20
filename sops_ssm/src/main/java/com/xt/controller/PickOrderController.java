package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.PickOrder;
import com.xt.pojo.WarehouseOrder;
import com.xt.service.PickOrderService;
import com.xt.service.WarehouseOrderService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 14:20
 */
@RestController
@RequestMapping("/pickorder")
public class PickOrderController {
    @Autowired
    private PickOrderService pickOrderService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllPickOrder(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @RequestParam("status") String status
    ){
        Page<PickOrder> page = new Page<>(pageNo, pageSize);

        IPage<PickOrder> pageRs = pickOrderService.getProvideByOpr(page,status);
        return Result.ok(pageRs);
    }

    @PostMapping()
    public Result addPickOrder(@RequestBody PickOrder pickOrder){
        pickOrderService.saveOrUpdate(pickOrder);
        return Result.ok();
    }

    @PutMapping("/update")
    public Result updatePickOrder(@RequestBody PickOrder pickOrder){
        pickOrderService.saveOrUpdate(pickOrder);
        return Result.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public Result deletePickOrder(@PathVariable("ids") List<Integer> ids){
        pickOrderService.removeByIds(ids);
        return Result.ok();
    }
}
