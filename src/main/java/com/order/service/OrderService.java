package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.ProductEntity;
import com.order.service.client.ProductClientService;

@Service
public class OrderService {

	@Autowired
	ProductClientService productClientService;

	public ProductEntity getProductDetails(Integer pid) {
		return productClientService.getProduct(pid);
		
	}

}
