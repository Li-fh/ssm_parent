package com.lfh.controller;

import com.lfh.domain.Orders;
import com.lfh.domain.Product;
import com.lfh.service.OrdersService;
import com.lfh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        List<Orders> ordersList = ordersService.findAll();
        //添加数据到模型中
        modelAndView.addObject("ordersList",ordersList);
        //指定视图页面
        modelAndView.setViewName("order-list");
        //返回ModelAndView
        return modelAndView;
    }

    /**
     * 保存页面回显
     * @return
     */
    @Autowired
    ProductService productService;
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        //查询数据-查询所有的产品
        List<Product> productList = productService.findAll();
        //添加数据到模型中
        modelAndView.addObject("productList",productList);
        //指定视图页面
        modelAndView.setViewName("order-add");
        //返回ModelAndView
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Orders orders){
        //保存操作
        ordersService.save(orders);
        //重定向，查询全部
        return "redirect:/orders/findAll";
    }
}
