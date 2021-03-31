/**
 * 
 */
package br.com.poc.multilaser.application.checkout.outbound.rest.dto;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
public class ProductDTO {

	private String id;
	private String name;
	private double price;
	private String description;
	
}
