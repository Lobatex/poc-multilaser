/**
 * 
 */
package br.com.poc.multilaser.application.product.outbound.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.poc.multilaser.application.product.outbound.mongo.entity.ProductEntity;

/**
 * @author Lobato
 *
 */
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}
