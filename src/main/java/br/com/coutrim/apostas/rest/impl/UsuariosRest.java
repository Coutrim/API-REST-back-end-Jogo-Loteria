package br.com.coutrim.apostas.rest.impl;

import br.com.coutrim.apostas.dao.UsuariosDAO;
import br.com.coutrim.apostas.model.Apostas;
import br.com.coutrim.apostas.model.Usuarios;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
@JsonIgnoreProperties
public class UsuariosRest {

    @Inject
    UsuariosDAO usuariosDAO;


    @GET
    public Response buscarTodosUsuarios() {
        return Response.ok(usuariosDAO.buscarUsuarios()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id")Long id){
        return Response.ok(usuariosDAO.buscarPorId(id)).build();

    }

    @POST
    public Response criarUsuario(Usuarios usuario){
        return Response.ok(usuariosDAO.criarUsuario(usuario)).build();
    }

    @Path("/{id}")
    @PUT
    public Response editarUsuario(Usuarios usuario){
        return Response.ok(usuariosDAO.atualizarUsuario(usuario)).build();
    }
    @Path("/{id}")
    @DELETE
    public Response removerUsuario(@PathParam("id") Long id, Usuarios usuario){
        return Response.ok(usuariosDAO.removerUsuario(id, usuario)).build();
    }


}
