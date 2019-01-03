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
import org.mongodb.morphia.query.Query;

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
        rol.setFuncionRoles(rolIn.getFuncionRoles());
        
        
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
       
       public List<Rol> buscarRolPorCodigo(String codRol) {

        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");

        List<Rol> lrol = new ArrayList<Rol>();
        //userF=ds.find(Usuario.class).asList();
        //Devuelve solo campo contrasenia
        lrol = ds.createQuery(Rol.class)
                .field("codigoRol").equal(codRol).asList();
        System.out.println("Rol encontrado:" + lrol);
        return lrol;
    }
     
       public void updateRol(Object obj){
       
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        
        System.out.println("conexion establecida con MongoDB!");
        List<Rol> listaRoles = new ArrayList<Rol>();
        
        Rol rol = new Rol();
        
//        rol.setCodigoRol(obj.getCodigoRol());
//        rol.setNombreRol(obj.getNombreRol());
//        rol.setDescripcionRol(obj.getDescripcionRol());
//        rol.setFuncionRoles(obj.getFuncionRoles());
        
        //ds.update(query, uo)
        //ds.update(rol);
        System.out.println("Rol Creado");
       
       }
       
//         public String eliminarUsuarioCodigo(Integer numUser){
//        System.out.println("ENTRA A FUNCION DE MORPHIA");
//        String codigo="";
//        Morphia morphia = new Morphia();
//        morphia.mapPackage("ec.edu.espe.arquitectura.model");
//
//        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
//        boolean borradoExitoso = false;
//      
//         try {
//             final Query <Usuario> userF = ds.createQuery(Usuario.class).field("numUser").equal(numUser);
//             ds.delete(userF);
//             borradoExitoso = true;
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//        
//         System.out.println("ESTADO DEL BORRADO EN LA BD:"+borradoExitoso);
//        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////");
//        //System.out.println("Usuario encontrado en la base de datos:" + userF);
//        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////");
//        
//        //}
//          
//        /*for(int i =0 ; i< userF.size();i++){
//            codigo = userF.get(i).getCodIdentificacion();
//        }*/
//        
//        return codigo;
//     
//     }
       
    
}
