/**
 * 
 */
package br.com.poc.multilaser.application.product.core.port.outbound;

import java.util.List;

import br.com.poc.multilaser.application.product.outbound.mongo.entity.ProductEntity;

/**
 * @author Lobato
 *
 */
public interface ProductPortOutbound {

	void saveNewProduct(ProductEntity product);

	List<ProductEntity> listAllProducts();

	ProductEntity findOneProduct(String idProduct);
	
}
