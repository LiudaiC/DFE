package com.lpc.stage.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/5/3.
 */
@Data
public class AgentPrice {

    private String agentOpenId;

    private String productId;

    private BigDecimal agentPrice;
}
