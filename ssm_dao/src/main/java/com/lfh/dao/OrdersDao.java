package com.lfh.dao;

import com.lfh.domain.Orders;

import java.util.List;

public interface OrdersDao {

    /**
     * 查询所有
     * @return
     */
    List<Orders> findAll();

    void save(Orders orders);
}
