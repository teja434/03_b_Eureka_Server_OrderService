package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.ProductEntity;
import com.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping(path="/orders/{oid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductEntity> getAllProductsByOrderId(@PathVariable("oid") Integer productId) {
		return ResponseEntity.ok(orderService.getProductDetails(productId));
	}

}
