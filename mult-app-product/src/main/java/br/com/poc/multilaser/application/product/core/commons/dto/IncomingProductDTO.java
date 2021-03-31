/**
 * 
 */
package br.com.poc.multilaser.application.product.core.commons.dto;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
public class IncomingProductDTO {

	private String id;
	private String name;
	private String description;
	private double price;
	
}
