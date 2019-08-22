package com.vivekchutke.microservice.promotion.pcforderservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.vivekchutke.microservice.promotion.pcforderservice")
@EnableDiscoveryClient
@EnableEurekaClient
public class PcfOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcfOrderServiceApplication.class, args);
	}

	@Bean
	public Sampler updateSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
