/**
 * 
 */
package br.com.poc.multilaser.application.inventory.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poc.multilaser.application.inventory.core.commons.dto.IncomingQuantityProduct;
import br.com.poc.multilaser.application.inventory.core.commons.dto.InventoryDTO;
import br.com.poc.multilaser.application.inventory.core.port.inbound.InventoryPortInbound;
import br.com.poc.multilaser.application.inventory.core.port.outbound.InventoryPortOutbound;
import br.com.poc.multilaser.application.inventory.outbound.mongo.entity.InventoryEntity;

/**
 * @author Lobato
 *
 */
@Service
public class InventoryHandler implements InventoryPortInbound {

	@Autowired
	private InventoryPortOutbound inventoryPortOutboundDB;

	//@Autowired
	//private InventoryPortOutboundRest inventoryPortOutboundRest;

	@Override
	public InventoryDTO changeQuantityProduct(IncomingQuantityProduct incQuantityProduct) {
		this.validateProduct(incQuantityProduct);
		
		switch (incQuantityProduct.getOperation()) {
		case NEW:
			this.addNewQuantity(incQuantityProduct);
			break;
		case SELL:
			this.sellProductQuantity(incQuantityProduct);
			break;
		case BUY:
			this.buyProductQuantity(incQuantityProduct);
			break;
		default:
			break;
		}
		
		InventoryEntity entity = inventoryPortOutboundDB.getQuantity(incQuantityProduct.getIdProduct());
		return this.entityToDTO(entity);
	}
	
	@Override
	public InventoryDTO getQuantityOfProduct(String idProduct) {
		InventoryEntity inventory = inventoryPortOutboundDB.getQuantity(idProduct);
		return this.entityToDTO(inventory);
	}

	private InventoryDTO entityToDTO(InventoryEntity entity) {
		InventoryDTO inventoryDTO = new InventoryDTO();
		inventoryDTO.setIdProduct(entity.getIdProduct());
		inventoryDTO.setQuantity(entity.getQuantity());
		return inventoryDTO;
	}

	private void validateProduct(IncomingQuantityProduct incQuantityProduct) {
		//TODO: VALIDATE PRODUCT ON MICROSERVICE PRODUCT
	}

	private void buyProductQuantity(IncomingQuantityProduct incQuantityProduct) {
		// TODO Auto-generated method stub
		InventoryEntity quantity = inventoryPortOutboundDB.getQuantity(incQuantityProduct.getIdProduct());
		quantity.setQuantity(quantity.getQuantity() + incQuantityProduct.getQuantityChanged());
		inventoryPortOutboundDB.changeQuantity(quantity);

	}

	private void sellProductQuantity(IncomingQuantityProduct incQuantityProduct) {
		InventoryEntity quantity = inventoryPortOutboundDB.getQuantity(incQuantityProduct.getIdProduct());
		quantity.setQuantity(quantity.getQuantity() - incQuantityProduct.getQuantityChanged());
		inventoryPortOutboundDB.changeQuantity(quantity);
	}

	private void addNewQuantity(IncomingQuantityProduct incQuantityProduct) {
		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setIdProduct(incQuantityProduct.getIdProduct());
		inventoryEntity.setQuantity(incQuantityProduct.getQuantityChanged());
		inventoryPortOutboundDB.insertQuantity(inventoryEntity);
	}


}
