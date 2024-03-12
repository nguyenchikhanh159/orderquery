package com.order.query.orderquery.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {
    private OrderDto orderDto;
    private List<OrderDetailDto> orderDetailDtoList;
}
