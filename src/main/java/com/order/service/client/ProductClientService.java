package com.order.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.ProductEntity;

@Service
public class ProductClientService {
	
	@Autowired
	RestTemplate restTemplate;
	

	public ProductEntity getProduct(Integer pid) {

		String uri= "http://product-service/products/"+pid;
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<ProductEntity> respProduct= restTemplate.exchange(uri, HttpMethod.GET, httpEntity, ProductEntity.class);
		return respProduct.getBody();

	}

}
