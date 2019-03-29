/**
 * 
 */
package com.microservices;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author AmmaNanaSatish
 *
 */
@RestController
public class CurrencyExchangeResource {
  @Autowired
  private Environment environment;
  @Autowired
  private ExchangeValueRepository exchangeValueRepository;
private Logger logger=LoggerFactory.getLogger(this.getClass());
 @GetMapping("/currency-exchange/from/{from}/to/{to}")
 public ExchangeValue retriveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
	    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	    logger.info("{}",exchangeValue);
	  return exchangeValue;
	 
 }
 
 
 @PostMapping("/save-currency-exchange")
 public void saveExchangeValue() {
		ExchangeValue exchangeValue = /* exchangeValueRepository.findByFromAndTo(from, to); */
				new ExchangeValue(100L,"USA1","IND1",BigDecimal.valueOf(55));
	 //exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		/* return exchangeValue; */
	 exchangeValueRepository.save(exchangeValue);
	 
 }
}
