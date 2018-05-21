package com.lpc.stage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@Data
@AllArgsConstructor
public class GoodsAttr {

    private long id;

    private String name;

    private List<GoodsAttrVal> vals;

}
