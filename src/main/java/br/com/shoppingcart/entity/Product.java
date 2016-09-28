package br.com.shoppingcart.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.jongo.marshall.jackson.oid.MongoId;

@Entity
public class Product {

	
	private String id;
	private String name;
	private String imageUrl;
	private BigDecimal price;
	
	@MongoId
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
