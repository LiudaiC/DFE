package com.lpc.stage.dao;

import com.lpc.stage.model.Order;
import com.lpc.stage.util.MybatisProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Mapper
public interface OrderDao {

    @Insert("insert into df_order(id, agent_open_id, buyer_open_id, buyer_name, buyer_phone, province, city, county, " +
            "detail_info, postal_code, total_quantity, original_total, real_total, discount, order_status, remark) values(${id}, ${agentOpenId}, ${buyerOpenId}, ${buyerName}, ${buyerPhone}, " +
            "${province}, ${city}, ${county}, ${detailInfo}, ${postalCode}, ${totalQuantity}, ${originalTotal}, ${realTotal}, ${discount}, ${orderStatus}, ${remark})")
    void save(Order order);

    @Select("select * from df_order where agent_open_id=${openId} and created_time > ${startDate} and created_time < ${endDate}")
    List<Order> getByOpenId(String openId, String startDate, String endDate);


    @SelectProvider(type = MybatisProvider.class, method = "queryOrder")
    List<Order> queryOrder(@Param("query") String query,
                           @Param("startDate") String startDate,
                           @Param("endDate") String endDate);

    @Select("select * from df_order where agent_open_id in (${openIds}) and created_time > ${startDate} and created_time < ${endDate}")
    List<Order> getChildrenOrders(List<String> openIds, String startDate, String endDate);
}
