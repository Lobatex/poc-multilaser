/**
 * 
 */
package br.com.poc.multilaser.application.inventory.core.port.outbound;

import br.com.poc.multilaser.application.inventory.outbound.mongo.entity.InventoryEntity;

/**
 * @author Lobato
 *
 */
public interface InventoryPortOutbound {

	public InventoryEntity getQuantity(String string);

	InventoryEntity insertQuantity(InventoryEntity entity);

	void changeQuantity(InventoryEntity entity);
}
