/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import ec.edu.espe.arquitectura.model.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("validarLogin")
@RequestScoped
public class ValidarLoginResource {

    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of ValidarLoginResource
     */
    public ValidarLoginResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.api.ValidarLoginResource
     * @param usuRQ
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        System.out.println("ook");
        return Response.ok().build();
    }

    /**
     * PUT method for updating or creating an instance of ValidarLoginResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson() {
     return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(Usuario usuRQ) {
        System.out.println("ook");
        return Response.ok(usuRQ).build();
    }
}