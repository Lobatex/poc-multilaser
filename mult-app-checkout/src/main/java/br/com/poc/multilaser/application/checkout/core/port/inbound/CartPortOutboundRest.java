/**
 * 
 */
package br.com.poc.multilaser.application.checkout.core.port.inbound;

import br.com.poc.multilaser.application.checkout.outbound.rest.dto.InventoryDTO;
import br.com.poc.multilaser.application.checkout.outbound.rest.dto.ProductDTO;

/**
 * @author Lobato
 *
 */
public interface CartPortOutboundRest {

	ProductDTO getProductById(int idProduct);

	InventoryDTO findQuantity(String id);
	
}
