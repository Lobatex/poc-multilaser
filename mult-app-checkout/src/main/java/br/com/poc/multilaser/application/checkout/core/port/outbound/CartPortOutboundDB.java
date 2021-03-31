/**
 * 
 */
package br.com.poc.multilaser.application.checkout.core.port.outbound;

import org.springframework.stereotype.Component;

import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.CartEntity;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.ItemEntity;

/**
 * @author Lobato
 *
 */
@Component
public interface CartPortOutboundDB {

	CartEntity insertNewItem(ItemEntity entity, String cartId);
	
}
