/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.managedBeans;

import ec.edu.espe.arquitectura.model.Rol;
import ec.edu.espe.arquitectura.session.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author User
 */

@Named(value = "rolController")
@SessionScoped
public class rolController implements Serializable {

    
    @EJB
    RolFacade EJBRol;
    private List<Rol> lroles = null;
    
    private String codigoRol="";
    private String nombreRol="";
    private String descripcionRol="";
    //private Integer numusuario ;
    
    //private Integer numUser;
    
    private List<Rol> listaDeRoles = new ArrayList<Rol>();
    
    public rolController(){
    
    }
    
    
    public RolFacade getEJBRol() {
        return EJBRol;
    }

    public void setEJBRol(RolFacade EJBRol) {
        this.EJBRol = EJBRol;
    }
 

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public List<Rol> getListaDeRoles() {
        return listaDeRoles;
    }

    public void setListaDeRoles(List<Rol> listaDeRoles) {
        this.listaDeRoles = listaDeRoles;
    }
    
 
    
    public void insertarRol(){
        Rol objRol = new Rol();
        
        objRol.setCodigoRol(codigoRol);
        objRol.setNombreRol(nombreRol);
        objRol.setDescripcionRol(descripcionRol);
     
        System.out.println("los datos son" + objRol);
        EJBRol.insertarRol(objRol);
        
        System.out.println(codigoRol);
        System.out.println(nombreRol);
        System.out.println(descripcionRol);
        System.out.println("Correctamento!");
        
        extraerRolesUsusarios();
    }

    
     
  public List<Rol> extraerRolesUser(){
      extraerRolesUsusarios();
      List<Rol> lista;
      lista = EJBRol.seleccionarRolesUsuario();
      return lista;   
    }
     
     public void extraerRolesUsusarios(){
       
        listaDeRoles = EJBRol.seleccionarRolesUsuario();
    }
   
//     public void eliminarUsuario(){
//        List<Usuario> listaUsu = null;
//        listaUsu = EJBRol.seleccionarUsuarios();
//        
//         System.out.println("/**********DATOS DE LA LISTA*********/"+listaUsu);
//        String respuesta="";
//        
//         for (Integer in : checkUsuarios) {
//             for (int i = 0; i < listaUsu.size(); i++) {
//                 if (Objects.equals(in, listaUsu.get(i).getNumUser())) {
//                     System.out.println("********************************************************");
//                     System.out.println("El num de usuario seleccionado es:"+listaUsu.get(i).getNumUser());  
//                     Integer valor = listaUsu.get(i).getNumUser();
//                     respuesta = EJBRol.eliminarUsuarioCodigo(valor);
//                     System.out.println("Encontrado............"+EJBRol.eliminarUsuarioCodigo(valor));
//                 }
//             }
//         }
//        checkUsuarios.clear();
//     }
     
//     public void eliminarUsuarioString(){
//        List<Usuario> listaUsu = null;
//        listaUsu = EJBRol.seleccionarUsuarios();
//        
//         System.out.println("/**********DATOS DE LA LISTA*********/"+listaUsu);
//        String respuesta="";
//        
//         for (Integer in : checkUsuarios) {
//             for (int i = 0; i < listaUsu.size(); i++) {
//                 if (Objects.equals(in, listaUsu.get(i).getCodIdentificacion())) {
//                     System.out.println("********************************************************");
//                     System.out.println("El num de usuario seleccionado es:"+listaUsu.get(i).getNumUser());  
//                     Integer valor = listaUsu.get(i).getNumUser();
//                     String valorString = Integer.toString(valor);
//                     respuesta = EJBRol.eliminarUsuarioCodigoString(valorString);
//                     System.out.println("Encontrado............"+EJBRol.eliminarUsuarioCodigoString(valorString));
//                 }
//             }
//         }
//        checkUsuarios.clear();
//     }
//     
     
     
     
}

