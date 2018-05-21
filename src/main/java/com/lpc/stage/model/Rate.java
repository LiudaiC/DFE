package com.lpc.stage.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
@AllArgsConstructor
public class Rate {

    private long id;

    private int rateLevel;

    private BigDecimal rate;

    public Rate(int rateLevel, BigDecimal rate) {
        this.rateLevel = rateLevel;
        this.rate = rate;
    }
}
