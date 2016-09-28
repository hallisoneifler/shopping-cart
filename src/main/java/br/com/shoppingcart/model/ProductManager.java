package br.com.shoppingcart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import br.com.shoppingcart.entity.Product;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Stateless
@Named
public class ProductManager {

	private Jongo jongo;
	private MongoCollection products;
	
	public ProductManager() {
		DB db = new MongoClient().getDB("shopping_cart");
		this.jongo = new Jongo(db);
		this.products = this.jongo.getCollection("products");
	}
	
	public void save() {
		Product product = new Product();
    	product.setName("Cuia Média");
    	product.setImageUrl("http://www.artega.com.br/11354-6575-large/cuia-160-fp.jpg");
    	product.setPrice(new BigDecimal(32.50));
    	products.save(product);
    	
    	product = new Product();
    	product.setName("Cuia Prata");
    	product.setImageUrl("http://www.artega.com.br/6466-5975-large/cuia-bocal-prata-1-pedra.jpg");
    	product.setPrice(new BigDecimal(75.90));
    	products.save(product);
    	
    	product = new Product();
    	product.setName("Cuia Gremio");
    	product.setImageUrl("http://www.artega.com.br/8239-2602-large/cuia-c-bocal-aluminio-c-pe-gremio.jpg");
    	product.setPrice(new BigDecimal(50.90));
    	products.save(product);
    	
		product = new Product();
    	product.setName("Espeto inox");
    	product.setImageUrl("http://www.artega.com.br/10681-4518-large/espeto-inox-cabo-madeira-55x11cm-duplo.jpg");
    	product.setPrice(new BigDecimal(50));
    	products.save(product);
    	
    	product = new Product();
    	product.setName("Grelha");
    	product.setImageUrl("http://www.artega.com.br/6038-317-large/grelha-cantoneira-esmaltada-40x50.jpg");
    	product.setPrice(new BigDecimal(100));
    	products.save(product);
    	
	}
	
	public Product get(String id) {
		Product product = (Product) products.findOne(new ObjectId(id)).as(Product.class);
		return product;
	}
	
	public List<Product> getAll() {
		MongoCursor<Product> mongoProducts = products.find().as(Product.class);
		List<Product> list = new ArrayList<Product>();
		mongoProducts.forEach(product->{
			list.add(product);
		});
		return list;
	}
	
	public void remove(String id) {
		products.remove(id);
	}

}
