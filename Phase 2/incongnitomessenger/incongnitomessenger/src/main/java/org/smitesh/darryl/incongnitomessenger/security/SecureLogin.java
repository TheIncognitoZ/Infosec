package org.smitesh.darryl.incongnitomessenger.security;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.smitesh.darryl.incongnitomessenger.model.Credentials;
import org.smitesh.darryl.incongnitomessenger.model.Response;
import org.smitesh.darryl.incongnitomessenger.service.AuthService;

@Path("auth")
public class SecureLogin {
	
	public AuthService authService = new AuthService(); 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("register")
	public Response NewRegister(Credentials creds)
	{
		return authService.NewUser(creds);
	}
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Login(Credentials creds)
	{
		return authService.Login(creds);
	}
	@POST
	@Path("emailcheck")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response EmailCheck(Credentials email)
	{
		return authService.AccountCheck(email);
	}
	@GET
	@Path("initialize")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Initialize()
	{
		return authService.Initialize();
	}
}
