/**
 * 
 */
package br.com.poc.multilaser.application.checkout.core.commons.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Lobato
 *
 */
@Data
public class CartDTO {

	private int id;
	private List<ItemDTO> items;
}
