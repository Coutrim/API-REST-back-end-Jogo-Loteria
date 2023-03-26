package br.com.coutrim.apostas.rest.impl;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.coutrim.apostas.model.Apostas;


@Stateless
@Path("apostas")
public class ApostasRest {


	@PersistenceContext
	EntityManager manager;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Apostas> buscarTodos() {
		return manager.createQuery("select c from Apostas c", Apostas.class).getResultList();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Apostas buscar(@PathParam("id") Long id) {
		Apostas aposta = manager.find(Apostas.class, id);
		return aposta;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criar(Apostas aposta){
		manager.persist(aposta);
		return Response.ok(aposta).build();

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Apostas atualizar(@PathParam("id") Long id, Apostas aposta ) {
		return manager.merge(aposta);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		Apostas aposta = manager.find(Apostas.class, id);
		if (aposta != null) {
			manager.remove(aposta);
		}
	}
	
	
}
