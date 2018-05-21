package com.lpc.stage.dao;

import com.lpc.stage.model.ProductAttributeValue;
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
public interface ProductAttributeValueDao {

    @InsertProvider(type = MybatisProvider.class, method = "saveAttributeValues")
    void save(@Param("values") List<ProductAttributeValue> values);

    @Select("select * from df_product_attr_val where att_id=${attId}")
    List<ProductAttributeValue> getByAttId(@Param("attId") long attId);
}
