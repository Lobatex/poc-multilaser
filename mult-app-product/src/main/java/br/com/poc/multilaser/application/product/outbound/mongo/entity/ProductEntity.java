/**
 * 
 */
package br.com.poc.multilaser.application.product.outbound.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
@Document(collection = "productEntity")
public class ProductEntity {

	@Id
	private String id;
	private String name;
	private String description;
	private double price;
	
}
