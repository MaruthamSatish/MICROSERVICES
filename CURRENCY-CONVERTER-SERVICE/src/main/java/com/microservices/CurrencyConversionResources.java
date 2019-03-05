/**
 * 
 */
package com.microservices;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author AmmaNanaSatish
 *
 */
@RestController
public class CurrencyConversionResources {
	@Autowired
	private CurrencyExchangeProxyService currencyExchangeProxy;

	@GetMapping("/currency-conversion-service/from/{fromExchange}/to/{toExchange}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("fromExchange") String fromExchange,
			@PathVariable("toExchange") String toExchange, @PathVariable("quantity") BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromExchange", fromExchange);
		uriVariables.put("toExchange", toExchange);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8092/currency-exchange/from/{fromExchange}/to/{toExchange}",
				CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), BigDecimal.TEN,
				quantity, quantity.multiply(BigDecimal.TEN),response.getPort());
	}

	@GetMapping("/currency-converter-service/currency-conversion-service-feign/from/{fromExchange}/to/{toExchange}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("fromExchange") String fromExchange,
			@PathVariable("toExchange") String toExchange, @PathVariable("quantity") BigDecimal quantity) {
		CurrencyConversionBean response = currencyExchangeProxy.retriveExchangeValue(fromExchange, toExchange);
		
		return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), BigDecimal.TEN,
				quantity, quantity.multiply(BigDecimal.TEN),response.getPort());
	}
}
