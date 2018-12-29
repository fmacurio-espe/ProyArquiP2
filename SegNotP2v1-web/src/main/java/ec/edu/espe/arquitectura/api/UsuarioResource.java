/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.msg.usuarioRQ;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("usuario")
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
    @Path("val/{user}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("user") String user, @PathParam("pass") String pass) {
        //TODO return proper representation object
        if(EJBUsuario.validarUsuariopoCred(user, pass)){
            return Response.accepted().build();
        }
        else{
            return Response.status(401).build();
        }
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
        
        EJBUsuario.insertarUsuarios(content);
        return Response.ok().build();
    }
    
    
    
    
}
