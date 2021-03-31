/**
 * 
 */
package br.com.poc.multilaser.application.product.core.port.inbound;

import java.util.List;

import br.com.poc.multilaser.application.product.core.commons.dto.IncomingProductDTO;
import br.com.poc.multilaser.application.product.core.commons.dto.ProductDTO;

/**
 * @author Lobato
 *
 */
public interface ProductPortInbound {

	void addNewProduct(IncomingProductDTO newProduct);

	List<ProductDTO> getAllProducts();

	ProductDTO recoveryProduct(String idProduct);
	
}
