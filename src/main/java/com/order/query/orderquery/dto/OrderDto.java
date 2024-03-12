package com.order.query.orderquery.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private int orderId;
    private int userId;
}
