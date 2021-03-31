/**
 * 
 */
package br.com.poc.multilaser.application.checkout.outbound.mongo.entity;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
public class ItemEntity {

	private String idProduct;
	private int quantity;
	private double totalPrice;
	
}
