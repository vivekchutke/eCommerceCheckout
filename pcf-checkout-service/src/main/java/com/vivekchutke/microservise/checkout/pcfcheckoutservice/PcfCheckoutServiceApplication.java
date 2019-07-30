package com.vivekchutke.microservise.checkout.pcfcheckoutservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.vivekchutke.microservise.checkout.pcfcheckoutservice")
public class PcfCheckoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcfCheckoutServiceApplication.class, args);
	}

	/**
	 * This method is used for sleuth to capture common logging across calls
	 *
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
