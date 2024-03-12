package com.order.query.orderquery.dao.repository;

import com.order.query.orderquery.dao.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {
}
