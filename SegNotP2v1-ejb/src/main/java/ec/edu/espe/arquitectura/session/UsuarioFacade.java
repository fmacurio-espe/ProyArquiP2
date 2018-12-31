/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
import com.mongodb.client.gridfs.GridFSBuckets;
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
public class UsuarioFacade {

    private Object MorphiaDatastoreTrasaction;

     public boolean validarUsuario(String user, String pass){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        List<Usuario> userF =new ArrayList<Usuario>();
        userF=ds.createQuery(Usuario.class)
                .field("nombreUsuario").equal(user)
                .field("contrasenia").equal(pass)
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
    
     public void insertarUsuarios(Usuario userIn) 
    {
        Morphia morphia = new Morphia();

        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        //datastore.ensureIndexes();
        System.out.println("conexion establecida con MongoDB!");
        Usuario user = new Usuario();
        
        //user.setNumusuario(userIn.getNumusuario());
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
     
     
     public List<Usuario> validarUsuariopoCred(String user, String pass){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        List<Usuario> userF =new ArrayList<Usuario>();
        userF=ds.createQuery(Usuario.class)
                .field("nombreUsuario").equal(user)
                .field("contrasenia").equal(pass)
                .asList();
        if(userF.isEmpty()){
            System.out.println("no se encontro");
            return null;
        }
        else{
            System.out.println("se encontro");
            return userF;
        }
     }
    
     
     public List<Usuario> seleccionarUsuarios(){
         
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");
        
        List<Usuario> userF = null;
        userF = new ArrayList<Usuario>();
        userF=ds.find(Usuario.class).asList();
        //Devuelve solo campo contrasenia
        //userF=ds.find(Usuario.class).retrievedFields( true, "contrasenia").asList();
         
         return userF;
     }

    public List<Usuario> buscarUsuarioCod(String codUser) {

        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");

        List<Usuario> userF = new ArrayList<Usuario>();
        //userF=ds.find(Usuario.class).asList();
        //Devuelve solo campo contrasenia
        userF = ds.createQuery(Usuario.class)
                .field("codigoUsuario").equal(codUser).asList();
        System.out.println("Usuario encontrado:" + userF);
        return userF;
    }

   
     public String eliminarUsuarioCodigo(Integer numUser){
        System.out.println("ENTRA A FUNCION DE MORPHIA");
        String codigo="";
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");

        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        boolean borradoExitoso = false;
      
         try {
             final Query <Usuario> userF = ds.createQuery(Usuario.class).field("numUser").equal(numUser);
             ds.delete(userF);
             borradoExitoso = true;
         } catch (Exception e) {
             System.out.println(e);
         }
        
         System.out.println("ESTADO DEL BORRADO EN LA BD:"+borradoExitoso);
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////");
        //System.out.println("Usuario encontrado en la base de datos:" + userF);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////");
        
        //}
          
        /*for(int i =0 ; i< userF.size();i++){
            codigo = userF.get(i).getCodIdentificacion();
        }*/
        
        return codigo;
     
     }
     
     public String eliminarUsuarioCodigoString(String numUser){
        System.out.println("ENTRA A FUNCION DE MORPHIA");
        String codigo="";
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");

        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        boolean borradoExitoso = false;
      
         try {
             final Query <Usuario> userF = ds.createQuery(Usuario.class).field("numUser").equal(numUser);
             ds.delete(userF);
             borradoExitoso = true;
         } catch (Exception e) {
             System.out.println(e);
         }
        
         System.out.println("ESTADO DEL BORRADO EN LA BD:"+borradoExitoso);
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////");
        //System.out.println("Usuario encontrado en la base de datos:" + userF);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////");
        
        //}
          
        /*for(int i =0 ; i< userF.size();i++){
            codigo = userF.get(i).getCodIdentificacion();
        }*/
        
        return codigo;
     
     }
}
