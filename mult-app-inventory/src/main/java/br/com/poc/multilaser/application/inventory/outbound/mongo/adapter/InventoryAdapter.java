/**
 * 
 */
package br.com.poc.multilaser.application.inventory.outbound.mongo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import br.com.poc.multilaser.application.inventory.core.port.outbound.InventoryPortOutbound;
import br.com.poc.multilaser.application.inventory.outbound.mongo.entity.InventoryEntity;

/**
 * @author Lobato
 *
 */
@Service
public class InventoryAdapter implements InventoryPortOutbound{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public InventoryEntity insertQuantity(InventoryEntity entity) {
		InventoryEntity inserted = mongoTemplate.insert(entity);
		return inserted;
	}
	
	@Override
	public void changeQuantity(InventoryEntity entity) {
		mongoTemplate.save(entity);
	}

	@Override
	public InventoryEntity getQuantity(String idProduct) {
		return mongoTemplate.findById(idProduct, InventoryEntity.class);
	}
	


}
