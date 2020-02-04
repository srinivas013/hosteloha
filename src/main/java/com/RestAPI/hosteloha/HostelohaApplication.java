package com.RestAPI.hosteloha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class HostelohaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelohaApplication.class, args);
	}
	
	

}
