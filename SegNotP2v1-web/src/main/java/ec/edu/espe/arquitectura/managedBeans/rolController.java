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
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
    
    private String[] funcionesRoles = null;
    private String[] arregloRoles = null;
    
    //private Integer numUser;
    
    private List<Rol> listaDeRoles = new ArrayList<Rol>();
    
    public rolController(){
    
    }
    
    private Rol selectRol;
    
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

    public String[] getFuncionesRoles() {
        return funcionesRoles;
    }

    public void setFuncionesRoles(String[] funcionesRoles) {
        this.funcionesRoles = funcionesRoles;
    }

    public String[] getArregloRoles() {
        return arregloRoles;
    }

    public void setArregloRoles(String[] arregloRoles) {
        this.arregloRoles = arregloRoles;
    }

    
    
    /**/    

    public Rol getSelectRol() {
        return selectRol;
    }

    public void setSelectRol(Rol selectRol) {
        this.selectRol = selectRol;
    }
   
    public void updateEdited(RowEditEvent event){
    
        System.out.println("****************FUNCION A VERIFICAR****************");
        System.out.println(event.getSource());
        System.out.println("****************----------------****************");
        
        EJBRol.updateRol((Rol) event.getObject());        
    }
    

    /**/
    public void insertarRol(){
        Rol objRol = new Rol();
        
        objRol.setCodigoRol(codigoRol);
        objRol.setNombreRol(nombreRol);
        objRol.setDescripcionRol(descripcionRol);
        objRol.setFuncionRoles(funcionesRoles);
        
        System.out.println("los datos son" + objRol);
        EJBRol.insertarRol(objRol);
        
        System.out.println(codigoRol);
        System.out.println(nombreRol);
        System.out.println(descripcionRol);
        System.out.println(Arrays.toString(funcionesRoles));
        System.out.println("Correctamento!");
        
        extraerRolesUsusarios();
    }
     
    public List<Rol> extraerRolesUser(){
    //  extraerRolesUsuarios();
      List<Rol> lista;
      lista = EJBRol.seleccionarRolesUsuario();
      return lista;   
    }
     
     public void extraerRolesUsusarios(){
       
        listaDeRoles = EJBRol.seleccionarRolesUsuario();
    }
   
     public List<Rol> editarRol(String codigo){
      List<Rol> lista;
      lista = EJBRol.buscarRolPorCodigo(codigo);
         System.out.println("ROL ENCONTRADO"+lista);
      return lista;   
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
