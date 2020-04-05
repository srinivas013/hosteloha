package com.RestAPI.hosteloha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;

import com.RestAPI.hosteloha.configuration.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class HostelohaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelohaApplication.class, args);
	}

	
	

}
