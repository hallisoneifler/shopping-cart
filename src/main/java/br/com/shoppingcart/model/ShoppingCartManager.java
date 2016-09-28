package br.com.shoppingcart.model;

import java.math.BigDecimal;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import br.com.shoppingcart.entity.CommerceItem;
import br.com.shoppingcart.entity.Product;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Stateless
public class ShoppingCartManager {

	private Jongo jongo;
	private MongoCollection shoppingCart;
	private MongoCollection commerceItens;
	
	public ShoppingCartManager() {
		DB db = new MongoClient().getDB("shopping_cart");
		this.jongo = new Jongo(db);
		this.shoppingCart = this.jongo.getCollection("shoppingCart");
		this.commerceItens = this.jongo.getCollection("commerceItem");
	}
	
	public void saveCommerceItem(String id_product, Integer quantity) {		
		Product product = this.getProduct(id_product);
		
		CommerceItem ci = new CommerceItem();
		ci.setProduct_id(product.getId());
		ci.setAmount(product.getPrice().multiply(new BigDecimal(quantity)));
		ci.setQuantity(quantity);
		
		commerceItens.save(ci);
	}
	
	public Product getProduct(String id) {
		MongoCollection products = this.jongo.getCollection("products");
		Product product = (Product) products.findOne(new ObjectId(id)).as(Product.class);
		
		return product;
	}

	public void removeCommerceItem(String id_commerceItem) {
		this.commerceItens.remove(new ObjectId(id_commerceItem));
	}
}
