package com.lpc.stage.dto.request;

import lombok.Data;

import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class ProductAttributeDto {

    private String attr;

    private List<String> values;
}
