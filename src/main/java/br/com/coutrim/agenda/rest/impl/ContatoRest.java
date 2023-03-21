package br.com.coutrim.agenda.rest.impl;

import java.util.List;

import javax.ejb.Local;
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

import br.com.coutrim.agenda.dto.ContatoDto;
import br.com.coutrim.agenda.model.Contato;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

@Stateless
@Path("contato")
public class ContatoRest {


	@PersistenceContext
	EntityManager manager;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Contato> buscarTodos() {
		return manager.createQuery("select c from Contato c", Contato.class).getResultList();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Contato buscar(@PathParam("id") Long id) {
		Contato contato = manager.find(Contato.class, id);
		return contato;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criar(Contato contato){
		manager.persist(contato);
		return Response.ok(contato).build();

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Contato atualizar(@PathParam("id") Long id, Contato contato ) {
		return manager.merge(contato);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		Contato contato = manager.find(Contato.class, id);
		if (contato != null) {
			manager.remove(contato);
		}
	}
	
	
}
