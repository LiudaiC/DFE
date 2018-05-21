package com.lpc.stage.model;

import com.lpc.stage.dto.request.AgentRequestDto;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Stefan on 2018/4/26.
 */
@Data
public class Agent {

    private long id;

    private String openId;

    private String parentOpenId;

    private String ancestorOpenId;

    private String agentName;

    private String agentPhone;

    private String nickName;

    private String gender;

    private String province;

    private String city;

    private String senderName;

    private String senderPhone;

    private String remark;

    private Timestamp joinTime;

    public Agent(AgentRequestDto dto) {
        this.agentName = dto.getAgentName();
        this.agentPhone = dto.getAgentPhone();
        this.openId = dto.getOpenId();
        this.parentOpenId = dto.getParentOpenId();
        this.ancestorOpenId = dto.getAncestorOpenId();
        this.nickName = dto.getNickName();
        this.gender = dto.getGender();
        this.province = dto.getProvince();
        this.city = dto.getCity();
        this.senderName = dto.getSenderName();
        this.senderPhone = dto.getSenderPhone();
        this.remark = dto.getRemark();
    }

}
