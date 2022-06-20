package com.xt.controller;

import com.xt.controller.ExceptionController.Code;
import com.xt.exception.BusinessException;
import com.xt.pojo.Goods;
import com.xt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther PYQ
 * @createtime 2022/5/3 - 23:11
 */

@RestController
@RequestMapping("/goods")
//@CrossOrigin
public class GoodsController {
/*    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public boolean save(@RequestBody Goods goods) {
        return goodsService.save(goods);
    }

    @PutMapping
    public boolean update(@RequestBody Goods goods) {
        return goodsService.update(goods);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return goodsService.delete(id);
    }

    @GetMapping("/{id}")
    public Goods selectById(@PathVariable Integer id) {
        if(id==1){
            throw new BusinessException(Code.BUSINESS_ERR,"请按照输入规范输入");
        }
        Goods goods = goodsService.selectById(id);
        return goods;
    }

    @GetMapping
    public List<Goods> selectAll(HttpServletRequest request) {

        List<Goods> goods = goodsService.selectAll();
        return goods;
    }*/


}
