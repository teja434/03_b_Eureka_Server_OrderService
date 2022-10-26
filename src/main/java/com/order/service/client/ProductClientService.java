package com.order.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	DiscoveryClient discoveryClient;
	

	public ProductEntity getProduct(Integer pid) {

		// we will get the instnaces of the required service
		List<ServiceInstance>instancesList= discoveryClient.getInstances("product-service");
		System.out.println("INSTANCES LIST: "+ instancesList.size());
		
		// We will get the instance base url
		String baseUrl=instancesList.get(0).getUri().toString();
		
		// Append the base url with the endpoint to form the actual url
		String url= baseUrl+"/products/"+pid;
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<ProductEntity> respProduct= restTemplate.exchange(url, HttpMethod.GET, httpEntity, ProductEntity.class);
		return respProduct.getBody();

	}

}
