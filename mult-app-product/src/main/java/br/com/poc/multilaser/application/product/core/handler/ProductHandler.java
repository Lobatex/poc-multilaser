/**
 * 
 */
package br.com.poc.multilaser.application.product.core.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poc.multilaser.application.product.core.commons.dto.IncomingProductDTO;
import br.com.poc.multilaser.application.product.core.commons.dto.ProductDTO;
import br.com.poc.multilaser.application.product.core.port.inbound.ProductPortInbound;
import br.com.poc.multilaser.application.product.core.port.outbound.ProductPortOutbound;
import br.com.poc.multilaser.application.product.outbound.mongo.entity.ProductEntity;

/**
 * @author Lobato
 *
 */
@Service
public class ProductHandler implements ProductPortInbound {

	@Autowired
	private ProductPortOutbound productOutboundService;
	
	@Override
	public void addNewProduct(IncomingProductDTO newProduct) {
		//TODO: CHECK IF PRODUCT ALEARDY EXISTS
		ProductEntity productEntity = this.dtoToEntity(newProduct);
		productOutboundService.saveNewProduct(productEntity);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> allProducts = productOutboundService.listAllProducts()
															 .stream()
															 .map(entity ->{
																 ProductDTO productDTO = new ProductDTO();
																 productDTO.setId(entity.getId());
																 productDTO.setName(entity.getName());
																 productDTO.setPrice(entity.getPrice());
																 productDTO.setDescription(entity.getDescription());
																 return productDTO;
															 }).collect(Collectors.toList());
		return allProducts;
	}
	
	@Override
	public ProductDTO recoveryProduct(String idProduct) {
		ProductEntity product = productOutboundService.findOneProduct(idProduct);
		return entityToDTO(product);
	}
	
	private ProductEntity dtoToEntity(IncomingProductDTO newProduct) {
		// TODO: CHANGE TO MAPSTRUCT
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(newProduct.getId());
		productEntity.setDescription(newProduct.getDescription());
		productEntity.setName(newProduct.getName());
		productEntity.setPrice(newProduct.getPrice());
		return productEntity;
	}
	
	private ProductDTO entityToDTO(ProductEntity entity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(entity.getId());
		productDTO.setDescription(entity.getDescription());
		productDTO.setPrice(entity.getPrice());
		productDTO.setName(entity.getName());
		return productDTO;
	}

}
