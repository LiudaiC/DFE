package com.lpc.stage.manager;

import com.lpc.stage.dto.request.AgentRequestDto;
import com.lpc.stage.dto.response.AgentResponseDto;
import com.lpc.stage.model.Agent;
import com.lpc.stage.model.Order;
import com.lpc.stage.model.Rate;
import com.lpc.stage.service.AgentService;
import com.lpc.stage.service.OrderService;
import com.lpc.stage.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static com.lpc.stage.util.Constants.RATE_SCALE;

/**
 * Created by Stefan on 2018/4/26.
 */
@Component
public class AgentManager {

    @Autowired
    private AgentService agentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RateService rateService;

    public long saveAgent(AgentRequestDto dto) {
        Agent agent = new Agent(dto);
        this.agentService.save(agent);
        return agent.getId();
    }

    public AgentResponseDto getAgent(String openId, String startDate, String endDate) {
        Agent self = this.agentService.getByOpenId(openId);
        List<Order> selfOrder = this.orderService.getByOpenId(openId, startDate, endDate);
        List<String> childrenOpenIds = this.agentService.getChildrenOpenIds(openId);
        List<Order> childrenOrders = this.orderService.getChildrenOrders(childrenOpenIds, startDate, endDate);
        AgentResponseDto res = new AgentResponseDto();
        BigDecimal originalAmount = BigDecimal.ZERO;
        BigDecimal realAmount = BigDecimal.ZERO;
        int totalQuantity = 0;
        for (Order o : selfOrder) {
            res.setTotalQuantity(res.getTotalQuantity() + o.getTotalQuantity());
            res.setTotalAmount(res.getTotalAmount().add(o.getRealTotal()));
            originalAmount.add(o.getOriginalTotal());
            realAmount.add(o.getRealTotal());
            totalQuantity += o.getTotalQuantity();
        }
        BigDecimal subOriginalAmount = BigDecimal.ZERO;
        for (Order o : childrenOrders) {
            res.setSubAmount(res.getSubAmount().add(o.getOriginalTotal()));
            res.setSubQuantity(res.getSubQuantity() + o.getTotalQuantity());
            subOriginalAmount.add(o.getOriginalTotal());
            totalQuantity += o.getTotalQuantity();
        }
        BigDecimal deduct = getRate(totalQuantity);
        deduct = deduct.add(realAmount).subtract(originalAmount)
                .add(subOriginalAmount.multiply(RATE_SCALE));
        res.setDeduct(deduct);
        return res;
    }

    private BigDecimal getRate(int quantity) {
        List<Rate> rates = this.rateService.getRates();
        int size = rates.size();
        if (quantity < rates.get(0).getRateLevel()) {
            return rates.get(0).getRate();
        } else if (quantity >= rates.get(size - 1).getRateLevel()) {
            return rates.get(size - 1).getRate();
        }
        for (int i = 1; i < size; i++) {
            if (rates.get(i - 1).getRateLevel() <= quantity &&
                    rates.get(i).getRateLevel() > quantity) {
                return rates.get(i-1).getRate();
            }
        }
        return BigDecimal.ZERO;
    }

}
