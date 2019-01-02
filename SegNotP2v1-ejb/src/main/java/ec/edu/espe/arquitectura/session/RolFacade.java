/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
import ec.edu.espe.arquitectura.model.Rol;
import ec.edu.espe.arquitectura.model.Usuario;
import java.util.ArrayList;
import java.util.List;
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
        rol.setNombreRol(rolIn.getNombreRol());
        rol.setDescripcionRol(rolIn.getDescripcionRol());
        
        
        //rol.setCodigoFuncionalidad(rolIn.getCodigoFuncionalidad());
        /*
        user.setNombres(nombres);
        user.setApellidos(apellidos);
        user.setCorreoElectronico(correoElectronico);
        user.setCorreoElectronico(correoElectronico);
        */
        
        ds.save(rol);
        System.out.println("Rol Creado");
    }
    
      public List<Rol> listaRolTodas(){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        /*
        Query<Usuario> qry=ds.createQuery(Usuario.class)
                .field("codigoUsuario").equal("fmacurio").asList();
        List<Usuario> usuarios=new ArrayList<Usuario>();
*/
        List<Rol> rolF =new ArrayList<Rol>();
        rolF=ds.createQuery(Rol.class).asList();
        return rolF;
     }

       public List<Rol> seleccionarRolesUsuario(){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        List<Rol> rolesL = null;
        rolesL = new ArrayList<Rol>();
        rolesL=ds.find(Rol.class).asList();
        //Devuelve solo campo contrasenia
        //userF=ds.find(Usuario.class).retrievedFields( true, "contrasenia").asList();
         
         return rolesL;
     }
    
}
