package com.lpc.stage.service;

import com.lpc.stage.dao.ProductAttributeValueDao;
import com.lpc.stage.model.ProductAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class ProductAttributeValueService {

    @Autowired
    private ProductAttributeValueDao valueDao;

    public void save(List<ProductAttributeValue> values) {
        this.valueDao.save(values);
    }

    public List<ProductAttributeValue> getByAttrId(long attrId) {
        return this.valueDao.getByAttId(attrId);
    }
}
