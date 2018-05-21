package com.lpc.stage.dao;

import com.lpc.stage.model.OrderLine;
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
public interface OrderLineDao {

    @InsertProvider(type = MybatisProvider.class, method = "saveLines")
    void save(@Param("lines") List<OrderLine> lines);

    @Select("select product_id, product_name, quantity, real_price from df_order_line where order_id=${orderId}")
    List<OrderLine> getByOrderId(String orderId);

}
