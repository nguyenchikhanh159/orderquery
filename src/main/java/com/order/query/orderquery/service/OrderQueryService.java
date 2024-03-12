package com.order.query.orderquery.service;

import com.order.query.orderquery.dao.entity.Order;
import com.order.query.orderquery.dao.entity.OrderDetail;
import com.order.query.orderquery.dao.repository.OrderRepository;
import com.order.query.orderquery.dto.OrderDetailDto;
import com.order.query.orderquery.dto.OrderDto;
import com.order.query.orderquery.dto.OrdersDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Cacheable("orders")
    public List<OrdersDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return mapToOrdersDto(orders);
    }

    private List<OrdersDto> mapToOrdersDto(List<Order> orders) {
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for(Order order: orders) {
            OrderDto orderDto = mapToOrderDto(order);
            List<OrderDetailDto> orderDetailDtoList = mapToOrderDetailDtoList(order.getOrderDetails());
            OrdersDto ordersDto = new OrdersDto(orderDto, orderDetailDtoList);
            ordersDtoList.add(ordersDto);
        }
        return ordersDtoList;
    }

    private OrderDto mapToOrderDto(Order order) {
        return OrderDto.builder()
                .orderId(order.getId())
                .userId(order.getUser().getId())
                .build();
    }

    private List<OrderDetailDto> mapToOrderDetailDtoList(Set<OrderDetail> orderDetailList) {
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        for(OrderDetail orderDetail : orderDetailList) {
            OrderDetailDto orderDetailDto = mapToOrderDetailDto(orderDetail);
            orderDetailDtoList.add(orderDetailDto);
        }
        return orderDetailDtoList;
    }

    private OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail) {
        return OrderDetailDto.builder()
                .orderDetailId(orderDetail.getId())
                .orderId(orderDetail.getOrder().getId())
                .ticketId(orderDetail.getTicket().getId())
                .quantity(orderDetail.getQuantity())
                .build();
    }
}
