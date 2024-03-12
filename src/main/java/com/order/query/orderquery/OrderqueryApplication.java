package com.order.query.orderquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderqueryApplication.class, args);
	}

}
