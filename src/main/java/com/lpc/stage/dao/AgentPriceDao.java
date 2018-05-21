package com.lpc.stage.dao;

import com.lpc.stage.model.AgentPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * Created by Stefan on 2018/5/3.
 */
@Mapper
public interface AgentPriceDao {

    @Insert("insert into df_agent_price(agent_open_id, product_id, agent_price) " +
            "value(${agentOpenId}, ${productId}, ${agentPrice})")
    void save(AgentPrice agentPrice);

    @Select("select * from df_agent_price where agent_open_id=${agentOpenId} and product_id=${productId}")
    AgentPrice getAgentPrice(String openId, long productId);

    @Update("update df_agent_price set agent_price=${agentPrice} where agent_open_id=${agentOpenId} and product_id=${productId}")
    AgentPrice updateAgentPrice(BigDecimal agentPrice, String openId, long productId);
}
