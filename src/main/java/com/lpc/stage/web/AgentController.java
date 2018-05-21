package com.lpc.stage.web;

import com.lpc.stage.dto.request.AgentRequestDto;
import com.lpc.stage.dto.response.AgentResponseDto;
import com.lpc.stage.manager.AgentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Stefan on 2018/4/26.
 */
@RestController
@RequestMapping("/df/agents")
public class AgentController {

    @Autowired
    private AgentManager agentManager;

    @PostMapping
    public ResponseEntity saveAgents(AgentRequestDto req) {
        this.agentManager.saveAgent(req);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{openId}")
    public ResponseEntity getAgent(String openId, String startDate, String endDate) {
        AgentResponseDto response = this.agentManager.getAgent(openId, startDate, endDate);
        return new ResponseEntity<AgentResponseDto>(HttpStatus.OK);
    }


}
