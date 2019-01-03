/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.api;

import ec.edu.espe.arquitectura.model.FechaProceso;
import ec.edu.espe.arquitectura.msg.FechaRQ;

import ec.edu.espe.arquitectura.session.FechaProcesoFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
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
@Path("fechaproceso")
@RequestScoped
public class FechaprocesoResource {

    @Context
    private UriInfo context;
    
    @EJB
    FechaProcesoFacade EJBFecha;

    /**
     * Creates a new instance of FechaprocesoResource
     */
    public FechaprocesoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.api.FechaprocesoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() throws ParseException {
        //TODO return proper representation object
        FechaProceso fa=new FechaProceso();
        fa=EJBFecha.findFecha("1");
        Date fecha= fa.getFechaProcesoActual();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5"));
	DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
        fechaFormat.setTimeZone(TimeZone.getTimeZone("GMT-5"));
	DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        fechaFormat.setTimeZone(TimeZone.getTimeZone("GMT-5"));
	
        String fh= dateFormat.format(fecha);
        String f= fechaFormat.format(fecha);
        String h= horaFormat.format(fecha);
        
        FechaRQ faRQ=new FechaRQ();
        faRQ.setFechaHoraActual(fh);
        faRQ.setFechaActual(f);
        faRQ.setHoraActual(h);
       
//throw new UnsupportedOperationException();
        return Response.ok(faRQ).build();
    }

    /**
     * PUT method for updating or creating an instance of FechaprocesoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(FechaRQ content) {
         EJBFecha.updateFecha(content.getFechaActual());
        return Response.ok().build();
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJSon(){
        
        EJBFecha.insertarFecha();
        
        return Response.ok().build();
    }
}
