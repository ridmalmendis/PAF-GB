package com.paf.gb.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.gb.models.Product;
import com.paf.gb.repository.ProductRepository;

@Path("/products")
public class ProductResource {
	
	ProductRepository productRepo = new ProductRepository();
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> GetUserList() { //get all products

		ArrayList<Product> productList = new ArrayList<Product>();
		productList = productRepo.getAllProducts();
		System.out.println("productList === "+productList);
		return productList;
		
	}
	
	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> GetUserList(@PathParam("sid") int sid) {
		System.out.println("product with sid>>");

		ArrayList<Product> productList = new ArrayList<Product>();
		productList = productRepo.getAllProductsBelogsToSellerId(sid);
		//System.out.println("productList === "+productList);
		return productList;
		
	}
	
	@POST
	@Path("")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML})
	public boolean AddProduct(Product pro) {
		System.out.println("pro --->> "+pro);
		System.out.println("@POST awa");
		return productRepo.addProduct(pro);
		
	}
	
	@PUT
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product updateProduct(Product product) {
		System.out.println("Product update data, came from Client side..."+product);
		
		productRepo.updateProducts(product);
		return product;
	}
	
	@DELETE
    @Path("/{pid}")
    public boolean deleteProductById(@PathParam("pid") int pid) {
		System.out.println("Product delete data, came from Client side... pid="+pid);
        return productRepo.deleteProduct(pid);
    }

}
