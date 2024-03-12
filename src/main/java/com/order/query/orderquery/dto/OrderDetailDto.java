package com.order.query.orderquery.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private int orderDetailId;
    private int orderId;
    private int ticketId;
    private int quantity;
}
