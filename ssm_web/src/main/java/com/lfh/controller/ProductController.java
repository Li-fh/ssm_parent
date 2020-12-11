package com.lfh.controller;

import com.github.pagehelper.PageInfo;
import com.lfh.domain.PageBean;
import com.lfh.domain.Product;
import com.lfh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 查询所有--没有分页
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        List<Product> productList = productService.findAll();
        //添加数据到模型中
        modelAndView.addObject("productList",productList);
        //指定视图页面
        modelAndView.setViewName("product-list");
        //返回ModelAndView
        return modelAndView;
    }

    @RequestMapping("/findAll3")
    /**
     * 查询所有--手动分页
     */
        public ModelAndView findAll3(@RequestParam(value = "currPage",required = false,defaultValue="1") Integer currPage,
                @RequestParam(value = "pageSize",required = false,defaultValue="5") Integer pageSize){
            //创建ModelAndView对象
            ModelAndView modelAndView = new ModelAndView();
            //根据分页参数查询数据
            PageBean<Product> pageBean = productService.findByPage(currPage,pageSize);
            //添加数据到模型中
            modelAndView.addObject("pageBean",pageBean);
            //指定视图页面
            modelAndView.setViewName("product-list");
            //返回ModelAndView
            return modelAndView;
    }

    @RequestMapping("/findAll")
    /**
     * 查询所有--分页助手
     * @RequestParam：请求参数绑定
     * value:指定页面参数名称
     * required：是否必须传参
     * defaultValue：默认值
     *
     */
    public ModelAndView findAll(@RequestParam(value = "currPage",required = false,defaultValue="1") Integer currPage,
                                @RequestParam(value = "pageSize",required = false,defaultValue="5") Integer pageSize){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //根据分页参数查询数据
        PageInfo<Product> pageInfo = productService.findByPageHelper(currPage,pageSize);
        //添加数据到模型中
        modelAndView.addObject("pageInfo",pageInfo);
        //指定视图页面
        modelAndView.setViewName("product-list");
        //返回ModelAndView
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product){

        productService.save(product);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        Product product = productService.findById(id);
        //添加数据到模型中
        modelAndView.addObject("product",product);
        //指定视图页面
        modelAndView.setViewName("product-update");
        //返回ModelAndView
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Product product){
        //修改操作
        productService.update(product);
        //查询全部
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delOne")
    public String delOne(Integer id){
        //删除操作
        productService.delById(id);
        //查询全部
        return "redirect:/product/findAll";
    }
    @RequestMapping("/delMany")
    public String delMany(Integer[] ids){

        productService.delMany(ids);

        return "redirect:/product/findAll";
    }
}
