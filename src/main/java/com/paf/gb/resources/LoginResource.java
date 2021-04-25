package com.paf.gb.resources;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.paf.gb.models.Login;
//import com.paf.gb.models.User;
import com.paf.gb.repository.LoginRepository;

@Path("login")
public class LoginResource {
	
	LoginRepository loginRepo = new LoginRepository();
	
	@GET
	@Path("/{uname}/{pwd}/{utype}")
	@Produces(MediaType.APPLICATION_JSON)
	public int getLoginUserId(@PathParam("uname") String uname, @PathParam("pwd") String pwd, @PathParam("utype") String utype) {
		System.out.println(" * getLogin called...");
		return loginRepo.getUserId(uname, pwd, utype);
	}
	/*
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public User createCustomer(Login login) {
		System.out.println("Customer create data, came from Client side..."+login);
		
		//loginRepo.createCustomer(customer);
		//return customer;
	}*/
}
