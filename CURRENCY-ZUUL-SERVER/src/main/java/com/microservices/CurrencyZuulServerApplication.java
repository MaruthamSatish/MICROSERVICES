package com.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class CurrencyZuulServerApplication {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
       public static void main(String[] args) {
		SpringApplication.run(CurrencyZuulServerApplication.class, args);
	}
      
       @RequestMapping("/")
       public String home() {
    	 logger.info("HIIIII");
           return "Hello World";
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