package com.lpc.stage.dto.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class GoodsPrice {

    private String valIds;

    private String vals;

    private BigDecimal price;
}
