package com.lpc.stage.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class ProductPriceDto {

    private String valIds;

    private List<String> vals;

    private BigDecimal agentPrice;

    private BigDecimal salePrice;

    private String remark;

    private String imageUrl;

}
