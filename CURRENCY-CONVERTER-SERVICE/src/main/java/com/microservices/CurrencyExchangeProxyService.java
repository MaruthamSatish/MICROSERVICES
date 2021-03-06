package com.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*@FeignClient(name="currency-exchange-service",url="localhost:8092")*/
@FeignClient(name="currency-zuul-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxyService {
	/*
	 * @GetMapping(
	 * "/currency-conversion-service/currency-exchange/from/{from}/to/{to}")
	 */
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	 public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
