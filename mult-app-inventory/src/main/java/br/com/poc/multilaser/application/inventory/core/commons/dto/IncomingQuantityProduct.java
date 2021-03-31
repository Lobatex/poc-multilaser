/**
 * 
 */
package br.com.poc.multilaser.application.inventory.core.commons.dto;

import br.com.poc.multilaser.application.inventory.core.commons.enums.OPERATION_TYPE;
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
