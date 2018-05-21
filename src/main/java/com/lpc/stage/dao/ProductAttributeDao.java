package com.lpc.stage.dao;

import com.lpc.stage.model.ProductAttribute;
import com.lpc.stage.util.MybatisProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Mapper
public interface ProductAttributeDao {

    @InsertProvider(type = MybatisProvider.class, method = "saveAttributes")
    void save(@Param("attributes") List<ProductAttribute> attributes);

    @Select("select * from df_product_attr where id=${id}")
    ProductAttribute getById(long id);
}
