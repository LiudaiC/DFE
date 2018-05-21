package com.lpc.stage.web;

import com.lpc.stage.dto.request.ProductAttributeDto;
import com.lpc.stage.manager.ProductAttributeManager;
import com.lpc.stage.manager.ProductAttributeValueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Stefan on 2018/5/5.
 */
@RestController
@RequestMapping("/df/products/attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeManager attributeManager;

    @Autowired
    private ProductAttributeValueManager valueManager;

    public ResponseEntity createAttribute(List<ProductAttributeDto> attrs) {
        this.attributeManager.createAttribute(attrs);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
