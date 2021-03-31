/**
 * 
 */
package br.com.poc.multilaser.application.inventory.core.port.inbound;

import br.com.poc.multilaser.application.inventory.core.commons.dto.IncomingQuantityProduct;
import br.com.poc.multilaser.application.inventory.core.commons.dto.InventoryDTO;

/**
 * @author Lobato
 *
 */
public interface InventoryPortInbound {

	InventoryDTO changeQuantityProduct(IncomingQuantityProduct incQuantityProduct);

	InventoryDTO getQuantityOfProduct(String idProduct);

	
}
