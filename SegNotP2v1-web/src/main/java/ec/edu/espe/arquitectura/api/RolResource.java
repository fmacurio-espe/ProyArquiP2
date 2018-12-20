/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import ec.edu.espe.arquitectura.model.Rol;
import ec.edu.espe.arquitectura.session.RolFacade;
import javax.ejb.EJB;
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
@Path("Rol")
@RequestScoped
public class RolResource {

    @Context
    private UriInfo context;
    
    @EJB
    RolFacade EJBRol;

    /**
     * Creates a new instance of RolResource
     */
    public RolResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.api.RolResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RolResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJSonUser(Rol content){
        System.out.println("Los datos POST recibidos ");
        System.out.println(content);
        
        EJBRol.insertarRol(content);
        return Response.ok().build();
    }
}
