package com.lpc.stage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private String id;

    private String goodName;

    private List<GoodsAttr> details;

    private List<GoodsPrice> prices;

    private String description;


}
