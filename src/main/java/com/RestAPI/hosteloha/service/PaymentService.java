package com.RestAPI.hosteloha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.model.Coupons;
import com.RestAPI.hosteloha.model.PaymentOption;
import com.RestAPI.hosteloha.repository.CouponsRepository;
import com.RestAPI.hosteloha.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	private CouponsRepository couponRepo;

	public List<PaymentOption> getPaymentOptions() {
		
		List<PaymentOption> paymentoptions = paymentRepo.findAll();
		return paymentoptions;
	}

	public PaymentOption addPaymentOption(PaymentOption paymentoption) {
		
		PaymentOption addedPaymentOption = paymentRepo.save(paymentoption);
		return addedPaymentOption;
	}

	public List<Coupons> getCoupons() {
		
		List<Coupons> coupons = couponRepo.findAll();
		return coupons;
	}

	public Coupons addCoupon(Coupons coupon) {
		
		Coupons savedcoupon = couponRepo.save(coupon);
		return savedcoupon;
	}
	
}
