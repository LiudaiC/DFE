package com.lpc.stage.web;

import com.lpc.stage.dto.response.Goods;
import com.lpc.stage.dto.request.ProductRequestDto;
import com.lpc.stage.manager.ProductManager;
import com.lpc.stage.model.InitProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@RestController
@RequestMapping("/df/products")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @PostMapping
    public ResponseEntity createProducts(@RequestBody ProductRequestDto products) {
        this.productManager.createProducts(Arrays.asList(products));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/inits")
    public List<InitProduct> getProducts() {
        return this.productManager.getInitProducts();
    }

    @GetMapping("/goods")
    public List<Goods> getGoods() {
        return this.productManager.getGoods();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") String id, ProductRequestDto product) {
        this.productManager.updateProduct(id, product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
