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
public class IncomingProductDTO {

	private String id;
	private String name;
	private String description;
	private double price;
	
}
