package com.lpc.stage.service;

import com.lpc.stage.dao.ProductAttributeDao;
import com.lpc.stage.model.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeDao attributeDao;

    public void save(List<ProductAttribute> attributes) {
        this.attributeDao.save(attributes);
    }

    public ProductAttribute getById(long id) {
        return this.attributeDao.getById(id);
    }
}
