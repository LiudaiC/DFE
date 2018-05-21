package com.lpc.stage.model;

import com.lpc.stage.dto.request.ProductRequestDto;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
public class InitProduct {

    private String id;

    private String attIds;

    private String productName;

    private String description;

    private String express;

    private String remark;

    private Timestamp createdTime;

    private Timestamp updatedTime;

    private String imageUrl;

    public InitProduct(ProductRequestDto dto) {
        this.attIds = dto.getAttIds();
        this.productName = dto.getProductName();
        this.description = dto.getDescription();
        this.express = dto.getExpress();
        this.remark = dto.getRemark();
        this.imageUrl = dto.getImageUrl();
    }

}
