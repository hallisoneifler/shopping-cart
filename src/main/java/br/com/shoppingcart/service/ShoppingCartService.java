package br.com.shoppingcart.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.shoppingcart.entity.CommerceItem;
import br.com.shoppingcart.model.ShoppingCartManager;

@Path("/shopping-carts")
public class ShoppingCartService {

	@Inject
	ShoppingCartManager shopManager;
	
	@POST
	@Consumes("application/vnd.api+json")
	public Response shoppingCartItemsPost(CommerceItem item) {
		
		this.shopManager.saveCommerceItem(item.getProduct_id(), item.getQuantity());			

		return Response.ok(true, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/{id_CommerceItem}")
	@GET
	public Response shoppingcartItemsIdDelete(@PathParam("id_CommerceItem") String id_CommerceItem) {
		
		this.shopManager.removeCommerceItem(id_CommerceItem);
		
		return Response.ok(MediaType.APPLICATION_JSON).build();
	}
}
