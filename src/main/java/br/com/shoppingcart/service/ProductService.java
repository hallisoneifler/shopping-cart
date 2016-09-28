package br.com.shoppingcart.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.shoppingcart.entity.Product;
import br.com.shoppingcart.model.ProductManager;

@Path("/products")
public class ProductService {

	@Inject
	ProductManager productManager;
	
	@Path("/")
	@GET
	public Response getProducts() {
		List<Product> list = productManager.getAll();
		
		return Response.ok(list, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/save")
	@POST
	public Response insertProducts() {
		productManager.save();
		
		return Response.ok(MediaType.APPLICATION_JSON).build();
	}
}
