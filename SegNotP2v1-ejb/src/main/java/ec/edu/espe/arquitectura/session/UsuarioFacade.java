/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
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
public class UsuarioFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
     public void insertarUsuario(Usuario userIn) 
    {
        Morphia morphia = new Morphia();

        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        //datastore.ensureIndexes();
        System.out.println("conexion establecida con MongoDB!");
        Usuario user = new Usuario();
        
        user.setNombreUsuario(userIn.getNombreUsuario());
        user.setContrasenia(userIn.getContrasenia());
        user.setCodIdentificacion(userIn.getCodIdentificacion());
        /*
        user.setNombres(nombres);
        user.setApellidos(apellidos);
        user.setCorreoElectronico(correoElectronico);
        user.setCorreoElectronico(correoElectronico);
        */
        
        
        user.setCodigoRol(userIn.getCodigoRol());
        ds.save(userIn);
        System.out.println("Usuario Creado");
    }
     
     
     public Boolean validarUsuariopoCred(String user, String pass){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        /*
        Query<Usuario> qry=ds.createQuery(Usuario.class)
                .field("codigoUsuario").equal("fmacurio").asList();
        List<Usuario> usuarios=new ArrayList<Usuario>();
*/
        List<Usuario> userF =new ArrayList<Usuario>();
        userF=ds.createQuery(Usuario.class)
                .field("nombreUsuario").equal(user)
                .asList();
        if(userF.isEmpty()){
            System.out.println("no se encontro");
            return false;
        }
        else{
            System.out.println("se encontro");
            return true;
        }
     }
    
}
