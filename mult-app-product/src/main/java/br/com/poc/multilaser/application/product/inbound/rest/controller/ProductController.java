/**
 * 
 */
package br.com.poc.multilaser.application.product.inbound.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.multilaser.application.product.core.commons.dto.IncomingProductDTO;
import br.com.poc.multilaser.application.product.core.commons.dto.ProductDTO;
import br.com.poc.multilaser.application.product.core.port.inbound.ProductPortInbound;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lobato
 *
 */
@Api(value = "Product controller",
	 consumes = "application/json")
@RestController
@RefreshScope
@RequestMapping("/product")
@Slf4j
public class ProductController {

	private ProductPortInbound productService;
	
	@Autowired
	public ProductController(ProductPortInbound productPortInbound) {
		this.productService = productPortInbound;
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> postAddProduct(@RequestBody IncomingProductDTO newProduct){
		ProductDTO productAdded = new ProductDTO();
		productService.addNewProduct(newProduct);
		return new ResponseEntity<ProductDTO>(productAdded, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getOneProduct(@PathVariable(name = "id") String idProduct){
		ProductDTO product = productService.recoveryProduct(idProduct);
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(allProducts, HttpStatus.OK);
	}
	
}
