package com.lfh.dao;

import com.lfh.domain.Product;

import java.util.List;

public interface ProductDao {
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
     * 根据id查询
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
     * 删除单个
     * @param id
     */
    void delById(Integer id);

    /**
     * 查询总条数
     * @return
     */
    Integer findTotalCount();

    /**
     * 根据分页参数查询数据
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Product> findByPage(Integer startIndex, Integer pageSize);
}
