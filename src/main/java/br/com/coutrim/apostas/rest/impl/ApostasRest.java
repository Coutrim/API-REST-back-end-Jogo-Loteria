package br.com.coutrim.apostas.rest.impl;


import javax.ejb.Stateless;
import javax.inject.Inject;
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

import br.com.coutrim.apostas.dao.ApostasDAO;
import br.com.coutrim.apostas.model.Apostas;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;


@Stateless
@Path("/apostas")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@JsonIgnoreProperties
public class ApostasRest {


    @Inject
    ApostasDAO apostasDAO;


    @GET
    public Response buscarTodos() {
        return Response.ok(apostasDAO.buscarApostas()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return Response.ok(apostasDAO.buscarAposta(id)).build();
    }

    @POST
    public Response criar(Apostas aposta) {
        return Response.ok(apostasDAO.criarAposta(aposta)).build();

    }

    @PUT
    @Path("/{id}")
    public Response atualizar(Apostas aposta) {
        return Response.ok(apostasDAO.atualizarAposta(aposta)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response apagar(@PathParam("id") Long id, Apostas aposta) {
        return Response.ok(apostasDAO.removerAposta(id, aposta)).build();
    }


}
