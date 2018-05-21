package com.lpc.stage.service;

import com.lpc.stage.dao.ProductDao;
import com.lpc.stage.model.InitProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void save(List<InitProduct> productList) {
        this.productDao.save(productList);
    }

    public void update(InitProduct product) {
        this.productDao.update(product);
    }

    public InitProduct getById(String id) {
        return this.productDao.getById(id);
    }

    public List<InitProduct> getInitProducts() {
        return this.productDao.getInitProducts();
    }

}
