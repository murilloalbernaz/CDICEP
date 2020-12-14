package com.murilloalbernaz.rest;

import com.murilloalbernaz.rest.cepservice.CepService;
import com.murilloalbernaz.rest.model.Endereco;
import com.murilloalbernaz.rest.model.EnderecoIngles;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cep")
public class CepResource {
    @Inject
    CepService service;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoIngles getEndereco(@PathParam("cep") String cep) {
        return service.buscaEndereco(cep);
    }
}