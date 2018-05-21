package com.lpc.stage.service;

import com.lpc.stage.dao.AgentDao;
import com.lpc.stage.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class AgentService {

    @Autowired
    private AgentDao agentDao;

    public long save(Agent agent) {
        this.agentDao.save(agent);
        return agent.getId();
    }

    public Agent getByOpenId(String openId) {
        return this.agentDao.getByOpenId(openId);
    }

    public List<String> getChildrenOpenIds(String openId) {
        return this.agentDao.getChildrenOpenIds(openId);
    }

}
