package com.lfh.service;

import com.github.pagehelper.PageInfo;
import com.lfh.domain.PageBean;
import com.lfh.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有
     * @return
     */
    List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */
    void save(Product product);

    /**
     * 查找产品
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 更新产品
     * @param product
     */
    void update(Product product);

    /**
     * 删除单个产品
     * @param id
     */
    void delById(Integer id);

    /**
     * 删除多个产品
     * @param ids
     */
    void delMany(Integer[] ids);

    /**
     * 根据分页参数查询
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

/*    *//**
     * 测试分页助手
     * @param currPage
     * @param pageSize
     *//*
    public void testPageHelper(Integer currPage, Integer pageSize);*/

    /**
     * 根据分页参数查询（分页助手）
     * @param currPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize);
}
