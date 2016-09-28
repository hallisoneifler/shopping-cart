package br.com.shoppingcart.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationService extends Application {

	private final Set<Class<?>> resources = new HashSet<>();

    public ApplicationService() {
        resources.add(ProductService.class);
        resources.add(ShoppingCartService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resources;
    }
}
