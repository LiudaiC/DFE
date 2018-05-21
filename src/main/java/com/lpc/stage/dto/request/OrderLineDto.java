package com.lpc.stage.dto.request;

import com.lpc.stage.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/5/3.
 */
@Data
public class OrderLineDto {

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
