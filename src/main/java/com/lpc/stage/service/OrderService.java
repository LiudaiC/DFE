package com.lpc.stage.service;

import com.lpc.stage.dao.OrderDao;
import com.lpc.stage.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public String save(Order order) {
        this.orderDao.save(order);
        return order.getId();
    }

    public List<Order> getByOpenId(String openId, String startDate, String endDate) {
        return this.orderDao.getByOpenId(openId, startDate, endDate);
    }

    public List<Order> queryOrder(String query, String startDate, String endDate) {
        return this.orderDao.queryOrder(query, startDate, endDate);
    }

    public List<Order> getChildrenOrders(List<String> childrenOpenIds, String startDate, String endDate) {
        return this.orderDao.getChildrenOrders(childrenOpenIds, startDate, endDate);
    }
}
