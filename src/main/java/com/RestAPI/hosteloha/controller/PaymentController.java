package com.RestAPI.hosteloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.hosteloha.model.Coupons;
import com.RestAPI.hosteloha.model.PaymentOption;
import com.RestAPI.hosteloha.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payment_option")
	public List<PaymentOption> getPaymentOptions() {
		
		List<PaymentOption> paymentOptions = paymentService.getPaymentOptions();
		return paymentOptions;
	}
	
	@PostMapping("/payment_option") 
	public ResponseEntity<Object> addPaymentOption(@RequestBody PaymentOption paymentoption) {
		PaymentOption addPaymentOption = paymentService.addPaymentOption(paymentoption);
		//return new ResponseEntity<Object>(HttpStatus.CREATED);
		return new ResponseEntity<Object>(addPaymentOption, HttpStatus.CREATED);
	}
	
	@GetMapping("/coupons")
	public List<Coupons> getCoupons( ) {
		
		List<Coupons> coupons = paymentService.getCoupons();
		return coupons;
	}
	
	@PostMapping("/coupons")
	public ResponseEntity<Object> addcouon(@RequestBody Coupons coupon) {
		
		Coupons addedCoupon = paymentService.addCoupon(coupon);
		return new ResponseEntity<Object>(addedCoupon, HttpStatus.CREATED);
	}
}
