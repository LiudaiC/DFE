package com.lpc.stage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/4/27.
 */
@Data
@AllArgsConstructor
public class RateDto {

    private int rateLevel;

    private BigDecimal rate;
}
