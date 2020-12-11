package com.lfh.service;

import com.lfh.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    /**
     * 查询所有
     * @return
     */
    List<Orders> findAll();

    void save(Orders orders);
}
