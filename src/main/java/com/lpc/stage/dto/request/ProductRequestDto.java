package com.lpc.stage.dto.request;

import lombok.Data;

import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
public class ProductRequestDto {

    private String productName;

    private String attIds;

    private List<ProductPriceDto> priceList;

    private String description;

    private String express;

    private String remark;

    private String imageUrl;

}
