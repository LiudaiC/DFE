package com.lpc.stage.dto.request;

import com.lpc.stage.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Stefan on 2018/5/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

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

    private List<OrderLineDto> orderLines;

}
