package com.lpc.stage.model;

import com.lpc.stage.dto.request.ProductPriceDto;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/4/27.
 */
@Data
public class ProductPrice {

    private long id;

    private String parentId;

    private String parentName;

    private String valIds;

    private BigDecimal agentPrice;

    private BigDecimal salePrice;

    private String remark;

    private Timestamp updateTime;

    private Timestamp createdTime;

    private String imageUrl;

    public ProductPrice(ProductPriceDto dto) {
        this.agentPrice = dto.getAgentPrice() != null ? dto.getAgentPrice() : dto.getSalePrice();
        this.salePrice = dto.getSalePrice();
        this.remark = dto.getRemark();
    }
}
