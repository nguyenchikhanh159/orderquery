package com.order.query.orderquery.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "userx")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy="user")
    private Set<Order> orders;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public User(int id) {
        this.id = id;
    }
}
