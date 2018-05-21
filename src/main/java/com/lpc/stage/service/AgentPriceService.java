package com.lpc.stage.service;

import com.lpc.stage.dao.AgentPriceDao;
import com.lpc.stage.model.AgentPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stefan on 2018/5/3.
 */
@Service
public class AgentPriceService {

    @Autowired
    private AgentPriceDao priceDao;

    public void save(AgentPrice price) {
        this.priceDao.save(price);
    }

    public AgentPrice getAgentPrice(String openId, long productId) {
        return this.priceDao.getAgentPrice(openId, productId);
    }
}
