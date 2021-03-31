/**
 * 
 */
package br.com.poc.multilaser.application.product.outbound.mongo.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.poc.multilaser.application.product.core.port.outbound.ProductPortOutbound;
import br.com.poc.multilaser.application.product.outbound.mongo.entity.ProductEntity;

/**
 * @author Lobato
 *
 */
@Service
public class ProductAdapter implements ProductPortOutbound {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveNewProduct(ProductEntity product) {
		mongoTemplate.insert(product);
	}
	
	@Override
	public List<ProductEntity> listAllProducts() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "DESC"));
		return mongoTemplate.find(query, ProductEntity.class);
	}

	@Override
	public ProductEntity findOneProduct(String idProduct) {
		ProductEntity product = mongoTemplate.findById(idProduct, ProductEntity.class);
		return product;
	}

}
