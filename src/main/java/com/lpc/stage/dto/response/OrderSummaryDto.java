package com.lpc.stage.dto.response;

import com.lpc.stage.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class OrderSummaryDto {

    private BigDecimal originalTotal;

    private BigDecimal realTotal;

    private BigDecimal discount;

    private int totalQuantity;

    private OrderStatus orderStatus;

    private Timestamp createdTime;
}
