package com.lpc.stage.service;

import com.lpc.stage.dao.RateDao;
import com.lpc.stage.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Service
public class RateService {

    @Autowired
    private RateDao rateDao;

    public void saveRate(Rate rate) {
        this.rateDao.saveRate(rate);
    }

    public void update(Rate rate) {
        this.rateDao.update(rate);
    }

    public void saveRates(List<Rate> rates) {
        this.rateDao.saveRates(rates);
    }

    public Rate getRateById(long id) {
        return this.rateDao.getRateById(id);
    }

    public List<Rate> getRates() {
        return this.rateDao.getRates();
    }

}
