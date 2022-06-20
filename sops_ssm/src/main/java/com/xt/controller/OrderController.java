package com.xt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xt.pojo.Order;
import com.xt.pojo.Warehouse;
import com.xt.service.OrderService;
import com.xt.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/18 - 10:55
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Result getAllOrder(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @RequestParam("ordertime") String ordertime,
            @RequestParam("overtime") String overTime
            ){
        Page<Order> page = new Page<>(pageNo, pageSize);

        IPage<Order> pageRs = orderService.getProvideByOpr(page,ordertime,overTime);
        return Result.ok(pageRs);
    }

    @PostMapping()
    public Result addOrder(@RequestBody Order order){
        orderService.saveOrUpdate(order);
        return Result.ok();
    }

    @PutMapping("/update")
    public Result updateOrder(@RequestBody Order order){
        orderService.saveOrUpdate(order);
        return Result.ok();
    }

    @DeleteMapping("/delete/{ids}")
    public Result deleteOrder(@PathVariable("ids") List<Integer> ids){
        orderService.removeByIds(ids);
        return Result.ok();
    }
}
