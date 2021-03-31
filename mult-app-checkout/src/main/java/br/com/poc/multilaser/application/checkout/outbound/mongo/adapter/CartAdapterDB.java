/**
 * 
 */
package br.com.poc.multilaser.application.checkout.outbound.mongo.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;

import br.com.poc.multilaser.application.checkout.core.port.outbound.CartPortOutboundDB;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.CartEntity;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.ItemEntity;

/**
 * @author Lobato
 *
 */
@Component
public class CartAdapterDB implements CartPortOutboundDB{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public CartEntity insertNewItem(ItemEntity entity, String cartId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(cartId));
        Update update = new Update();
        update.addToSet("items", entity);
        UpdateResult result = mongoTemplate.upsert(query, update, CartEntity.class);
        return this.findCart(cartId == null ? result.getUpsertedId().toString() : cartId);
	}

	public CartEntity findCart(String cartId) {
        return mongoTemplate.findById(cartId, CartEntity.class);
    }
	
}
