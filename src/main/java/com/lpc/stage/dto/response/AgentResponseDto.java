package com.lpc.stage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/5/2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentResponseDto {

    private String nickName;

    private int totalQuantity;

    private BigDecimal totalAmount = BigDecimal.ZERO;

    private BigDecimal deduct = BigDecimal.ZERO;

    private int subQuantity;

    private BigDecimal subAmount = BigDecimal.ZERO;

    private BigDecimal subDeduct = BigDecimal.ZERO;

}
