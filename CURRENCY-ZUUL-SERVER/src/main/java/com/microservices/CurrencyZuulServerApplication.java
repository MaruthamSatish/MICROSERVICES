package com.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class CurrencyZuulServerApplication {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
       public static void main(String[] args) {
		SpringApplication.run(CurrencyZuulServerApplication.class, args);
	}
     @Bean
       public CurrencyZuulFilter getCurrentFilter()
     {
    	   return new CurrencyZuulFilter();
    	   }
       @Bean
       public AlwaysSampler defaultSampler() {
         return new AlwaysSampler();
       }
}