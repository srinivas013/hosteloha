package com.RestAPI.hosteloha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.model.DeliveryFormat;
import com.RestAPI.hosteloha.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepo;

	public List<DeliveryFormat> getDeliveryFormat() {
		
		List<DeliveryFormat> deliveryformats = deliveryRepo.findAll();
		return deliveryformats;
	}

	public DeliveryFormat addDeliveryFormat(DeliveryFormat deliveryformat) {
		
		DeliveryFormat addeedDeliveryFormat = deliveryRepo.save(deliveryformat);
		return addeedDeliveryFormat;
	}
	
	
}
