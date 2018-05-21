package com.lpc.stage.manager;

import com.lpc.stage.dto.request.ProductPriceDto;
import com.lpc.stage.dto.request.ProductRequestDto;
import com.lpc.stage.dto.response.Goods;
import com.lpc.stage.dto.response.GoodsAttr;
import com.lpc.stage.dto.response.GoodsAttrVal;
import com.lpc.stage.dto.response.GoodsPrice;
import com.lpc.stage.model.InitProduct;
import com.lpc.stage.model.ProductAttribute;
import com.lpc.stage.model.ProductAttributeValue;
import com.lpc.stage.model.ProductPrice;
import com.lpc.stage.service.ProductAttributeService;
import com.lpc.stage.service.ProductAttributeValueService;
import com.lpc.stage.service.ProductPriceService;
import com.lpc.stage.service.ProductService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Stefan on 2018/4/26.
 */
@Component
public class ProductManager {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPriceService productPriceService;

    @Autowired
    private ProductAttributeService attributeService;

    @Autowired
    private ProductAttributeValueService valueService;

    @Transactional
    public void createProducts(List<ProductRequestDto> dtos) {
        List<InitProduct> products = new ArrayList<InitProduct>();
        List<ProductPrice> prices = new ArrayList<ProductPrice>();
        InitProduct product = null;
        ProductPrice price = null;
        for (ProductRequestDto o : dtos) {
            product = new InitProduct(o);
            String pId = UUID.randomUUID().toString();
            product.setId(pId);
            List<String> attIds = new ArrayList<String>();
            String[] attValArr = null;
            for (ProductPriceDto priceDto : o.getPriceList()) {
                price = new ProductPrice(priceDto);
                List<String> valIds = new ArrayList<String>();
                for (String val: priceDto.getVals()) {
                    attValArr = val.split("-");
                    if (!attIds.contains(attValArr[0])) {
                        attIds.add(attValArr[0]);
                    }
                    if (!valIds.contains(attValArr[1])) {
                        valIds.add(attValArr[1]);
                    }
                }
                price.setValIds(StringUtils.join(valIds));
                price.setParentId(pId);
                price.setParentName(o.getProductName());
                price.setImageUrl(o.getImageUrl());
            }
            product.setAttIds(StringUtils.join(attIds));
            products.add(product);
            prices.add(price);
        }
        this.productService.save(products);
        this.productPriceService.savePriceList(prices);
    }

    public List<InitProduct> getInitProducts() {
        return this.productService.getInitProducts();
    }

    public InitProduct updateProduct(String id, ProductRequestDto dto) {
        InitProduct product = this.productService.getById(id);
        product.setProductName(dto.getProductName());
        product.setImageUrl(dto.getImageUrl());
        product.setDescription(dto.getDescription());
        product.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
        this.productService.update(product);
        return product;
    }

    public List<Goods> getGoods() {
        List<Goods> goods = new ArrayList<Goods>();
        List<InitProduct> products = this.productService.getInitProducts();
        Goods goods1 = null;
        for (InitProduct p : products) {
            goods1 = new Goods();
            goods1.setGoodName(p.getProductName());
            goods1.setDescription(p.getDescription());
            goods1.setId(p.getId());
            List<GoodsPrice> goodsPrices = new ArrayList<GoodsPrice>();
            GoodsPrice goodsPrice = null;
            List<ProductPrice> initPrices = this.productPriceService.getPrices(p.getId());
            for (ProductPrice price : initPrices) {
                goodsPrice = new GoodsPrice();
                goodsPrice.setValIds(price.getValIds());
                goodsPrice.setPrice(price.getAgentPrice());
                goodsPrices.add(goodsPrice);
            }
            List<GoodsAttrVal> vals = null;
            List<GoodsAttr> attrs = new ArrayList<GoodsAttr>();
            for (String attId : p.getAttIds().split(",")) {
                ProductAttribute att = this.attributeService.getById(Long.valueOf(attId));
                List<ProductAttributeValue> values = this.valueService.getByAttrId(att.getId());
                vals = new ArrayList<GoodsAttrVal>();
                for (ProductAttributeValue v:values) {
                    vals.add(new GoodsAttrVal(v.getId(), v.getValue()));
                }
                attrs.add(new GoodsAttr(att.getId(), att.getAttrName(), vals));
            }
            goods1.setPrices(goodsPrices);
            goods1.setDetails(attrs);
        }
        return goods;
    }

}
