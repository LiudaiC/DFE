package com.lpc.stage.dao;

import com.lpc.stage.model.Agent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Mapper
public interface AgentDao {

    @Insert("insert into df_agent(agent_name, agent_phone, gender, open_id, parent_open_id, ancestor_open_id, nick_name, " +
            "province, city, sender_name, sender_phone, remark) values(${agentName}, ${agentPhone}, ${gender}, ${openID}, " +
            "${parent_open_id}, ${ancestor_open_id}, ${nickName}, ${province}, ${city}, ${senderName}, ${senderPhone}, ${remark})")
    long save(Agent agent);

    @Select("select open_id from df_agent where parent_open_id=${openId}")
    List<String> getChildrenOpenIds(String openId);

    @Select("select open_id from df_agent where ancestor_open_id=${openId}")
    List<String> getSubOpenIds(String openId);

    @Select("select * from df_agent where open_id=${openId}")
    Agent getByOpenId(String openId);

    @Select("select * from df_agent where parent_open_id=${parentOpenId}")
    List<Agent> getAgentsByParentOpenId(String parentOpenId);

    @Select("select * from df_agent where ancestor_open_id=${ancestorOpenId}")
    List<Agent> getAgentsByAncestorOpenId(String ancestorOpenId);
}
