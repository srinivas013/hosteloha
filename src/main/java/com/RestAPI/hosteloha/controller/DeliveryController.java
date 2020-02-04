package com.RestAPI.hosteloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.hosteloha.model.DeliveryFormat;
import com.RestAPI.hosteloha.service.DeliveryService;

@RestController
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@GetMapping("/delivery_format")
	public List<DeliveryFormat> getDeliveryFormats() {
		
		List<DeliveryFormat> deliveryFormat = deliveryService.getDeliveryFormat();
		return deliveryFormat;
	}
	
	@PostMapping("/add_delivery_format") 
	public ResponseEntity<Object> addDeliveryFormat(@RequestBody DeliveryFormat deliveryformat ) {
		
		DeliveryFormat addedDeliveryFormat = deliveryService.addDeliveryFormat(deliveryformat);
		return new ResponseEntity<Object>(addedDeliveryFormat, HttpStatus.CREATED);
	}
}
