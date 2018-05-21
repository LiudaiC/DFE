package com.lpc.stage.model;

import com.lpc.stage.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
public class OrderLine {

    private long id;

    private String orderId;

    private long productId;

    private String productName;

    private int quantity;

    private BigDecimal originalPrice;

    private BigDecimal realPrice;

    private OrderStatus lineStatus;

    private Timestamp createdTime;
}
