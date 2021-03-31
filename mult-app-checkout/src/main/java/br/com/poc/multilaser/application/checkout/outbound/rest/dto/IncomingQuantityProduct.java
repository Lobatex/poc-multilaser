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
public class IncomingQuantityProduct {

	private String idProduct;
	private int quantityChanged;
	private OPERATION_TYPE operation;
	
}
