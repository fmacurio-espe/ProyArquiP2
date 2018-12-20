/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
import ec.edu.espe.arquitectura.model.Rol;
import ec.edu.espe.arquitectura.model.Usuario;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class RolFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      public void insertarRol(Rol rolIn) 
    {
        Morphia morphia = new Morphia();

        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        //datastore.ensureIndexes();
        System.out.println("conexion establecida con MongoDB!");
        Rol rol = new Rol();
        
        rol.setCodigoRol(rolIn.getCodigoRol());
        rol.setDescripcionRol(rolIn.getDescripcionRol());
        rol.setNombreRol(rolIn.getNombreRol());
        
        rol.setCodigoFuncionalidad(rolIn.getCodigoFuncionalidad());
        /*
        user.setNombres(nombres);
        user.setApellidos(apellidos);
        user.setCorreoElectronico(correoElectronico);
        user.setCorreoElectronico(correoElectronico);
        */
        
        ds.save(rol);
        System.out.println("Rol Creado");
    }
    
    
}