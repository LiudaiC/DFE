package com.lpc.stage.dao;

import com.lpc.stage.model.InitProduct;
import com.lpc.stage.util.MybatisProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Mapper
public interface ProductDao {


    @InsertProvider(type = MybatisProvider.class, method = "saveProducts")
    void save(@Param("products") List<InitProduct> products);

    @Update("update df_product set product_name=${productName}, image_url=${imageUrl}, description=${description}, " +
            "updated_time=${updatedTime} where id=${id}")
    void update(InitProduct product);

    @Select("select * from df_product where id=${id}")
    InitProduct getById(String id);

    @Select("select * from df_product")
    List<InitProduct> getInitProducts();
}
