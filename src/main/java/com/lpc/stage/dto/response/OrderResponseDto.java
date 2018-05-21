package com.lpc.stage.dto.response;

import com.lpc.stage.enums.OrderStatus;
import com.lpc.stage.model.OrderLine;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class OrderResponseDto {

    private String id;

    private String agentOpenId;

    private String buyerOpenId;

    private String buyerName;

    private String buyerPhone;

    private String province;

    private String city;

    private String county;

    private String detailInfo;

    private String postalCode;

    private BigDecimal originalTotal;

    private BigDecimal realTotal;

    private BigDecimal discount;

    private int totalQuantity;

    private String remark;

    private OrderStatus orderStatus;

    private Timestamp createdTime;

    private List<OrderLine> lines;
}
