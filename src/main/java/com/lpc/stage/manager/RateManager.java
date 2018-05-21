package com.lpc.stage.manager;

import com.lpc.stage.dto.request.RateDto;
import com.lpc.stage.model.Rate;
import com.lpc.stage.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Component
public class RateManager {

    @Autowired
    private RateService rateService;

    public List<Rate> getRates() {
        return this.rateService.getRates();
    }

    @Transactional
    public void saveRates(List<RateDto> rateDtos) {
        List<Rate> rates = new ArrayList<Rate>();
        for (RateDto r : rateDtos) {
            rates.add(new Rate(r.getRateLevel(), r.getRate()));
        }
        this.rateService.saveRates(rates);
    }

    @Transactional
    public void update(List<Rate> rates) {
        for (Rate rate : rates) {
            this.rateService.update(rate);
        }
    }
}
