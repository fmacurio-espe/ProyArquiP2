/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import com.google.gson.Gson;
import ec.edu.espe.arquitectura.msg.ClienteRedRQ;
import ec.edu.espe.arquitectura.session.MailSession;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ec.edu.espe.arquitectura.model.Transaccion;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/**
 * REST Web Service
 *
 * @author User
 */
@Path("notificacion")
@RequestScoped
public class NotificacionResource {

    @Context
    private UriInfo context;
    
    

    
    @EJB
    MailSession mail;
    
    
    /**
     * Creates a new instance of NotificacionResource
     */
    public NotificacionResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.api.NotificacionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@Context HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return ip;
        //TODO return proper representation object
        
    }

    /**
     * PUT method for updating or creating an instance of NotificacionResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(Transaccion content) throws Exception {
        System.out.println(content);
        //mail.enviarMail(content);
        System.out.println("fun");
        ClienteRedRQ n= obtenerUsuario();
        System.out.println(n);
        return Response.ok().build();
    }
    
    
    
    public ClienteRedRQ obtenerUsuario() throws MalformedURLException, IOException {
        String sURL = "http://kyc.strangled.net:8080/KYC-mongo-rest-web/api/cliente/cedula/1234567890"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
        String zipcode = rootobj.get("identificacion").getAsString(); //just grab the zipcode
        System.out.println(zipcode);
        System.out.println(root);
        Gson gson = new Gson();
        ClienteRedRQ rq=gson.fromJson(root, ClienteRedRQ.class);
        return rq;
    }   
}
