package com.lpc.stage.manager;

import com.lpc.stage.dto.request.ProductAttributeDto;
import com.lpc.stage.model.ProductAttribute;
import com.lpc.stage.model.ProductAttributeValue;
import com.lpc.stage.service.ProductAttributeService;
import com.lpc.stage.service.ProductAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Stefan on 2018/4/26.
 */
@Component
public class ProductAttributeManager {

    @Autowired
    private ProductAttributeService attributeService;

    @Autowired
    private ProductAttributeValueService valueService;

    public void createAttribute(List<ProductAttributeDto> attrs) {
        List<ProductAttribute> attributes = new ArrayList<ProductAttribute>();
        List<ProductAttributeValue> attributeValues = new ArrayList<ProductAttributeValue>();
        Random random = new Random();
        ProductAttribute attribute = null;
        ProductAttributeValue value = null;
        for (ProductAttributeDto attr : attrs) {
            long attrId = random.nextInt();
            attribute = new ProductAttribute(attrId, attr.getAttr());
            attributes.add(attribute);
            for (String v : attr.getValues()) {
                value = new ProductAttributeValue();
                value.setAttId(attrId);
                value.setValue(v);
            }
            attributeValues.add(value);
        }
        this.attributeService.save(attributes);
        this.valueService.save(attributeValues);
    }

}
