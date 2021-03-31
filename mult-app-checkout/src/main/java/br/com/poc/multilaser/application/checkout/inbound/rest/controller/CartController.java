/**
 * 
 */
package br.com.poc.multilaser.application.checkout.inbound.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.multilaser.application.checkout.core.commons.dto.CartDTO;
import br.com.poc.multilaser.application.checkout.core.commons.dto.ItemDTO;
import br.com.poc.multilaser.application.checkout.core.port.inbound.CartPortInbound;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.CartEntity;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lobato
 *
 */
@Api(value = "Cart controller",
	 consumes = "application/json")
@RestController
@RefreshScope
@RequestMapping("/cart")
@Slf4j
public class CartController {

	private CartPortInbound cartPortInbound;
	
	@Autowired
	public CartController(CartPortInbound cartPortInbound) {
		this.cartPortInbound = cartPortInbound;
	}
	
	@PostMapping("/{id}/item")
	public ResponseEntity<CartDTO> addItemCart(@RequestBody ItemDTO item, @PathVariable(name = "id") String id){
		CartDTO cartDTO = new CartDTO();
		CartEntity addItemCart = cartPortInbound.addItemCart(item, id);
		return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
	}
	
	
}
