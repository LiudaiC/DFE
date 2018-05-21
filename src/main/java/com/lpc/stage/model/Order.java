package com.lpc.stage.model;

import com.lpc.stage.dto.request.OrderRequestDto;
import com.lpc.stage.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

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

    public Order(OrderRequestDto req) {
        this.agentOpenId = req.getAgentOpenId();
        this.buyerOpenId = req.getBuyerOpenId();
        this.buyerName = req.getBuyerName();
        this.buyerPhone = req.getBuyerPhone();
        this.province = req.getProvince();
        this.city = req.getCity();
        this.county = req.getCounty();
        this.detailInfo = req.getDetailInfo();
        this.postalCode = req.getPostalCode();
        this.remark = req.getRemark();
    }
}
