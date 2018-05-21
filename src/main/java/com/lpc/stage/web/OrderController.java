package com.lpc.stage.web;

import com.lpc.stage.dto.request.OrderRequestDto;
import com.lpc.stage.dto.response.OrderResponseDto;
import com.lpc.stage.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@RestController
@RequestMapping("/df/orders")
public class OrderController {

    @Autowired
    private OrderManager orderManager;

    @PostMapping
    public ResponseEntity createOrder(OrderRequestDto requestDto) {
        this.orderManager.createOrder(requestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public List<OrderResponseDto> getOrders(@RequestParam("openId") String openId,
                                            @RequestParam(name = "page", defaultValue = "1") int page,
                                            @RequestParam("startDate") String startDate,
                                            @RequestParam("endDate") String endDate) {
        return this.orderManager.getOrders(openId, startDate, endDate);
    }

    @GetMapping("/all")
    public List<OrderResponseDto> getAllOrders(@RequestParam(name = "query", required = false) String query,
                                            @RequestParam(name = "startDate", required = false) String startDate,
                                            @RequestParam(name = "endDate", required = false) String endDate) {
        return this.orderManager.getAllOrders(query, startDate, endDate);
    }

}
