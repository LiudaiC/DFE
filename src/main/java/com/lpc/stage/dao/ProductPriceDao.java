package com.lpc.stage.dao;

import com.lpc.stage.model.ProductPrice;
import com.lpc.stage.util.MybatisProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Stefan on 2018/4/27.
 */
@Mapper
public interface ProductPriceDao {

    @InsertProvider(type = MybatisProvider.class, method = "saveProductPrices")
    void saveProductPrice(@Param("priceList") List<ProductPrice> priceList);

    @Select("select * from df_product_price where id=${id}")
    ProductPrice getById(long id);

    @Select("select * from df_product_price where parent_id=${parentId}")
    List<ProductPrice> getByParentId(String parentId);
}
