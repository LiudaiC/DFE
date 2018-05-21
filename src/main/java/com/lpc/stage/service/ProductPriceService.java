package com.lpc.stage.service;

import com.lpc.stage.dao.ProductPriceDao;
import com.lpc.stage.model.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/5/3.
 */
@Service
public class ProductPriceService {

    @Autowired
    private ProductPriceDao priceDao;

    public void savePriceList(List<ProductPrice> prices) {
        this.priceDao.saveProductPrice(prices);
    }

    public ProductPrice getById(long priceId) {
        return this.priceDao.getById(priceId);
    }

    public List<ProductPrice> getPrices(String parentId) {
        return this.priceDao.getByParentId(parentId);
    }
}
