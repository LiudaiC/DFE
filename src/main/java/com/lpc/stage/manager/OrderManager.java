package com.lpc.stage.manager;

import com.lpc.stage.dto.request.OrderLineDto;
import com.lpc.stage.dto.request.OrderRequestDto;
import com.lpc.stage.dto.response.OrderResponseDto;
import com.lpc.stage.model.AgentPrice;
import com.lpc.stage.model.Order;
import com.lpc.stage.model.OrderLine;
import com.lpc.stage.model.ProductPrice;
import com.lpc.stage.service.AgentPriceService;
import com.lpc.stage.service.OrderLineService;
import com.lpc.stage.service.OrderService;
import com.lpc.stage.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.lpc.stage.enums.OrderStatus.DRAFT;

/**
 * Created by Stefan on 2018/4/26.
 */
@Component
public class OrderManager {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private ProductPriceService productService;

    @Autowired
    private AgentPriceService agentPriceService;

    @Transactional
    public String createOrder(OrderRequestDto request) {
        Order order = new Order(request);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddhhmmss");
        String orderId = sdf.format(date) + formatSuffix(new Random().nextInt(1000000));
        order.setId(orderId);
        BigDecimal originalTotal = BigDecimal.ZERO;
        BigDecimal realTotal = BigDecimal.ZERO;
        int totalQuantity = 0;
        List<OrderLine> lineList = new ArrayList<OrderLine>();
        for (OrderLineDto dto : request.getOrderLines()) {
            ProductPrice productPrice = this.productService.getById(dto.getProductId());
            AgentPrice agentPrice = this.agentPriceService.getAgentPrice(request.getAgentOpenId(), dto.getProductId());
            OrderLine line = new OrderLine();
            line.setLineStatus(DRAFT);
            line.setOrderId(orderId);
            line.setOriginalPrice(productPrice.getAgentPrice().multiply(BigDecimal.valueOf(dto.getQuantity())));
            line.setRealPrice(agentPrice.getAgentPrice().multiply(BigDecimal.valueOf(dto.getQuantity())));
            line.setProductId(dto.getProductId());
            line.setProductName(productPrice.getParentName());
            line.setQuantity(dto.getQuantity());
            lineList.add(line);
            originalTotal.add(line.getOriginalPrice());
            realTotal.add(line.getRealPrice());
            totalQuantity += dto.getQuantity();
        }
        order.setTotalQuantity(totalQuantity);
        order.setOriginalTotal(originalTotal);
        order.setRealTotal(realTotal);
        order.setOrderStatus(DRAFT);
        this.orderLineService.save(lineList);
        this.orderService.save(order);
        return orderId;
    }

    public List<OrderResponseDto> getOrders(String openId, String startDate, String endDate){
        List<OrderResponseDto> orders = new ArrayList<OrderResponseDto>();
        List<Order> list = this.orderService.getByOpenId(openId, startDate, endDate);
        for (Order o : list) {
            List<OrderLine> lines = this.orderLineService.getByOrderId(o.getId());
        }
        return orders;
    }
    public List<OrderResponseDto> getAllOrders(String query, String startDate, String endDate){
        List<OrderResponseDto> orders = new ArrayList<OrderResponseDto>();
        List<Order> list = this.orderService.queryOrder(query, startDate, endDate);
        for (Order o : list) {
            List<OrderLine> lines = this.orderLineService.getByOrderId(o.getId());
        }
        return orders;
    }

    private String formatSuffix(int arg) {
        if (arg < 10) {
            return "00000" + arg;
        } else if (arg < 100) {
            return "0000" + arg;
        } else if (arg < 1000) {
            return "000" + arg;
        } else if (arg < 10000) {
            return "00" + arg;
        } else if (arg < 100000) {
            return "0" + arg;
        } else {
            return "" + arg;
        }
    }

}
