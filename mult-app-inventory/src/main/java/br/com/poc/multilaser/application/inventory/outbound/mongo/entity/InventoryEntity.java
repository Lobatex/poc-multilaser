/**
 * 
 */
package br.com.poc.multilaser.application.inventory.outbound.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
@Document(collection = "inventoryEntity")
public class InventoryEntity {

	@Id
	private String idProduct;
	private int quantity;
	
}
