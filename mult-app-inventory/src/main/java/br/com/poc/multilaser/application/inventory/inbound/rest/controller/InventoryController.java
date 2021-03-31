/**
 * 
 */
package br.com.poc.multilaser.application.inventory.inbound.rest.controller;

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

import br.com.poc.multilaser.application.inventory.core.commons.dto.IncomingQuantityProduct;
import br.com.poc.multilaser.application.inventory.core.commons.dto.InventoryDTO;
import br.com.poc.multilaser.application.inventory.core.port.inbound.InventoryPortInbound;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lobato
 *
 */
@Api(value = "Inventory controller",
	 consumes = "application/json")
@RestController
@RefreshScope
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

	private InventoryPortInbound inventoryService;
	
	@Autowired
	public InventoryController(InventoryPortInbound inventoryPortInbound) {
		this.inventoryService = inventoryPortInbound;
	}
	
	@PostMapping
	public ResponseEntity<InventoryDTO> postAlterQuantity(@RequestBody IncomingQuantityProduct incQuantityProduct){
		InventoryDTO inventoryProduct = inventoryService.changeQuantityProduct(incQuantityProduct);
		return new ResponseEntity<InventoryDTO>(inventoryProduct,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InventoryDTO> getQuantity(@PathVariable(name = "id") String idProduct){
		InventoryDTO inventoryProduct = inventoryService.getQuantityOfProduct(idProduct);
		return new ResponseEntity<InventoryDTO>(inventoryProduct, HttpStatus.OK);
	}
	
}
