package com.order.entity;

import lombok.Data;

@Data
public class ProductEntity {
	
	private Integer productId;
	private String productCode;
	private String productDesc;
	private double price;
	private String quantity;
	private String imageUrl;
	
}
