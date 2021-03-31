/**
 * 
 */
package br.com.poc.multilaser.application.checkout.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.poc.multilaser.application.checkout.core.commons.dto.ItemDTO;
import br.com.poc.multilaser.application.checkout.core.port.inbound.CartPortInbound;
import br.com.poc.multilaser.application.checkout.core.port.inbound.CartPortOutboundRest;
import br.com.poc.multilaser.application.checkout.core.port.outbound.CartPortOutboundDB;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.CartEntity;
import br.com.poc.multilaser.application.checkout.outbound.mongo.entity.ItemEntity;
import br.com.poc.multilaser.application.checkout.outbound.rest.dto.InventoryDTO;
import br.com.poc.multilaser.application.checkout.outbound.rest.dto.ProductDTO;

/**
 * @author Lobato
 *
 */
@Service
public class CartHandler implements CartPortInbound{
	
	private static final String WITHOUT_STOCK = "WITHOUT STOCK AVABIABLE";
	
	@Autowired
	private CartPortOutboundDB cartOutboundDB;
	
	@Autowired
	private CartPortOutboundRest cartOutboundRest;
	
	@Override
	public CartEntity addItemCart(ItemDTO item, String id) {
		CartEntity cartEntity = cartOutboundDB.insertNewItem(this.ItemDTOtoEntity(item), id);
		return cartEntity;
	}

	private ItemEntity ItemDTOtoEntity(ItemDTO item) {
		ProductDTO product = this.findProduct(item.getIdProduct());
		InventoryDTO quantity = this.findQuantity(product.getId());
		ItemEntity itemEntity = new ItemEntity();
		if(quantity.getQuantity() < item.getQuantity()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, WITHOUT_STOCK);
		}
		itemEntity.setTotalPrice(product.getPrice() * item.getQuantity());
		itemEntity.setIdProduct(product.getId());
		itemEntity.setQuantity(item.getQuantity());
		return itemEntity;
	}

	private InventoryDTO findQuantity(String id) {
		return cartOutboundRest.findQuantity(id);
	}

	private ProductDTO findProduct(int idProduct) {
		return cartOutboundRest.getProductById(idProduct);
	}

	
	
}
