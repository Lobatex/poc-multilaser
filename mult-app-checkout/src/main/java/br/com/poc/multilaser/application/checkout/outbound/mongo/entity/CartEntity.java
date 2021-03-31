/**
 * 
 */
package br.com.poc.multilaser.application.checkout.outbound.mongo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
@Document(collection = "cartEntity")
public class CartEntity {

	@Id
	private String id;
	private List<ItemEntity> items;
	
}
