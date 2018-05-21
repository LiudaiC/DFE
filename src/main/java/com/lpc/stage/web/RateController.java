package com.lpc.stage.web;

import com.lpc.stage.dto.request.RateDto;
import com.lpc.stage.manager.RateManager;
import com.lpc.stage.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@RequestMapping("/df/rates")
@RestController
public class RateController {

    @Autowired
    private RateManager rateManager;

    @GetMapping
    public List<Rate> getRates() {
        return this.rateManager.getRates();
    }

    @PostMapping
    public ResponseEntity saveRates(List<RateDto> rates) {
        this.rateManager.saveRates(rates);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRates(List<Rate> rates) {
        this.rateManager.update(rates);
        return new ResponseEntity(HttpStatus.OK);
    }
}