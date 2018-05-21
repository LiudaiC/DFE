package com.lpc.stage.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Created by Stefan on 2018/5/21.
 */
@Data
public class StageProductDto {

    private String id;

    private String productName;

    private String remark;

    private List<GoodsPrice> priceList;

    private String imageUrl;

}
