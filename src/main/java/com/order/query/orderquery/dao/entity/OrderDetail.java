package com.order.query.orderquery.dao.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name="ticket_id")
    private Integer ticketId;

    @Column(name = "quantity")
    private Integer quantity;
}
