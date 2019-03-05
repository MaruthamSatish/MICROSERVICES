/**
 * 
 */
package com.microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author AmmaNanaSatish
 *
 */
@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
 ExchangeValue findByFromAndTo(String from,String to);
 
}
