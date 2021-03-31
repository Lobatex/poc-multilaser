/**
 * 
 */
package br.com.poc.multilaser.application.checkout.outbound.rest.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import br.com.poc.multilaser.application.checkout.core.port.inbound.CartPortOutboundRest;
import br.com.poc.multilaser.application.checkout.outbound.rest.dto.InventoryDTO;
import br.com.poc.multilaser.application.checkout.outbound.rest.dto.ProductDTO;

/**
 * @author Lobato
 *
 */
@Component
public class CartAdapterRest implements CartPortOutboundRest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient discoveryClient;
	
	@Override
	public ProductDTO getProductById(int idProduct) {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("app-product", false);
		String productCatalogUrl = instance.getHomePageUrl () + "/product/" + idProduct;
		ProductDTO itemProduct = restTemplate.getForObject(productCatalogUrl, ProductDTO.class);
		return itemProduct;
	}

	@Override
	public InventoryDTO findQuantity(String id) {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("app-inventory", false);
		String inventoryCatalogUrl = instance.getHomePageUrl () + "/inventory/" + id;
		InventoryDTO inventory = restTemplate.getForObject(inventoryCatalogUrl, InventoryDTO.class);
		return inventory;
	}
	
	
	
}
