package com.lfh.service.impl;

import com.lfh.dao.OrdersDao;
import com.lfh.domain.Orders;
import com.lfh.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    public void save(Orders orders) {
        ordersDao.save(orders);
    }
}
