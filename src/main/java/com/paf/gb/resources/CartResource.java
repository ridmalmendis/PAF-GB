package com.paf.gb.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.gb.models.Cart;
import com.paf.gb.repository.CartRepository;

@Path("cart")
public class CartResource {

	CartRepository cartRepo = new CartRepository();
	
	/*----------------------------- resources of carts -------------------------------*/
	/*----------------------------- resources of carts -------------------------------*/
	
	
	@GET
	@Path("cart-items/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cart> getAllCarts(@PathParam("id") int id){
		System.out.println("id>> "+id);
		System.out.println("getAllCart called...");
		return cartRepo.getAllCartItemsBelongsToCustomer(id);
	}
	/*
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getSeller(@PathParam("id") int id) {
		System.out.println("getSeller called...");
		return userRepo.getSeller(id);
	}*/
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Cart createCart(Cart cartItem) {
		System.out.println("Cart create data, came from Client side..."+cartItem);
		
		cartRepo.createCart(cartItem);
		return cartItem;
	}
	
	@PUT
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Cart updateCart(Cart cartItem) {
		System.out.println("Cart update data, came from Client side..."+cartItem);
		
		cartRepo.updateCarts(cartItem);
		return cartItem;
	}
	
	@DELETE
    @Path("/{id}")
    public boolean deleteCartById(@PathParam("id") int id) {
		System.out.println("Cart delete data, came from Client side...id="+id);
        return cartRepo.deleteCart(id);
    }

}
