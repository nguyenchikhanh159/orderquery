package com.order.query.orderquery.controller;

import com.order.query.orderquery.dto.OrdersDto;
import com.order.query.orderquery.service.OrderQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping(path = "/orders/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrdersDto>> getAllTickets() {
        List<OrdersDto> ordersDtoList = orderQueryService.getOrders();
        return new ResponseEntity<>(ordersDtoList, HttpStatus.OK);
    }
}
