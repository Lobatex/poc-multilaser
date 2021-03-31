/**
 * 
 */
package br.com.poc.multilaser.application.checkout.core.port.inbound;

import br.com.poc.multilaser.application.checkout.core.commons.dto.ItemDTO;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.CartEntity;

/**
 * @author Lobato
 *
 */
public interface CartPortInbound {

	CartEntity addItemCart(ItemDTO item, String id);

}
