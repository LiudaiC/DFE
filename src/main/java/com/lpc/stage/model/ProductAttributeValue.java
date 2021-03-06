package com.lpc.stage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeValue {

    private long id;

    private long attId;

    private String value;
}
