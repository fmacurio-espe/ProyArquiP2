/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
import ec.edu.espe.arquitectura.model.FechaProceso;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class FechaProcesoFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void insertarFecha() {
        Morphia morphia = new Morphia();

        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        //datastore.ensureIndexes();
        System.out.println("conexion establecida con MongoDB!");
        FechaProceso fecha = new FechaProceso();
        FechaProceso ff = new FechaProceso();
        ff = findFecha("1");
        if (ff != null) {
            Query<FechaProceso> usersLista =ds.createQuery(FechaProceso.class)
                .field("codFA").equal("1");
        
            Date d=new Date();
            UpdateOperations<FechaProceso> uo=ds.createUpdateOperations(FechaProceso.class)
                    .set("FechaProcesoActual", d);
        ds.update(usersLista, uo);
        }
        else{
            fecha.setCodFA("1");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            fecha.setFechaProcesoActual(date);
            ds.save(fecha);
        }
        System.out.println("Fecha Creada");
    }


    public FechaProceso findFecha(String codFA) {
        try {
            Morphia morphia = new Morphia();
            morphia.mapPackage("ec.edu.espe.arquitectura.model");
            Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
            System.out.println("conexion establecida");

            FechaProceso fechaF = ds.createQuery(FechaProceso.class)
                    .field("codFA").equal(codFA).get();
            System.out.println(fechaF);
            return fechaF;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean updateFecha(String fecha) {
        try {
            Morphia morphia = new Morphia();
            morphia.mapPackage("ec.edu.espe.arquitectura.model");
            Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
            System.out.println("conexion establecida");

            Date d = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            d = dateFormat.parse(fecha+" 00:00:00");

            System.out.println(d);
            Query<FechaProceso> usersLista = ds.createQuery(FechaProceso.class)
                    .field("codFA").equal("1");
            UpdateOperations<FechaProceso> uo = ds.createUpdateOperations(FechaProceso.class)
                    .set("FechaProcesoActual", d);
            ds.update(usersLista, uo);
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
