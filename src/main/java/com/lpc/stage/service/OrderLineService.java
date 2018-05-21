package com.lpc.stage.service;

import com.lpc.stage.dao.OrderLineDao;
import com.lpc.stage.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class OrderLineService {

    @Autowired
    private OrderLineDao orderLineDao;

    public void save(List<OrderLine> lineList) {
        this.orderLineDao.save(lineList);
    }

    public List<OrderLine> getByOrderId(String orderId) {
        return this.orderLineDao.getByOrderId(orderId);
    }


}
