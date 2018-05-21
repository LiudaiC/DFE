package com.lpc.stage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * Created by Stefan on 2018/5/2.
 */
@Data
@AllArgsConstructor
public class AgentRequestDto {

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

}
