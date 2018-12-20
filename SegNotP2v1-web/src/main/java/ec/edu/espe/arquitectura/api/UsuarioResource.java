/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.session.UsuarioFacade;
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
@Path("Usuario")
@RequestScoped
public class UsuarioResource {

    
    @Context
    private UriInfo context;

    @EJB
    UsuarioFacade EJBUsuario;
    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.api.UsuarioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJSonUser(Usuario content){
        System.out.println("Los datos POST recibidos ");
        System.out.println(content);
        
        EJBUsuario.insertarUsuario(content);
        return Response.ok().build();
    }
    
}
