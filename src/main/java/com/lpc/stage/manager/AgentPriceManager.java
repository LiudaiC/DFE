package com.lpc.stage.manager;

import com.lpc.stage.model.AgentPrice;
import com.lpc.stage.service.AgentPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Stefan on 2018/5/3.
 */
@Component
public class AgentPriceManager {

    @Autowired
    private AgentPriceService agentPriceService;

    public void save(AgentPrice price) {
        this.agentPriceService.save(price);
    }
}
