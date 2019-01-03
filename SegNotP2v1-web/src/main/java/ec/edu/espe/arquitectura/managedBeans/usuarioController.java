/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.managedBeans;

import ec.edu.espe.arquitectura.model.Funcionalidad;
import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.session.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author User
 */

@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    /**
     * Creates a new instance of funcionalidadController
     */
    
    @EJB
    UsuarioFacade EJBUsuario;
    private List<Usuario> lusuarios = null;
    
    
    
    private String codigoUsuario="";
    private String nombreUsuario="";
    private String contrasenia="";
    //private Integer numusuario ;
    private Integer numUser;
    private String[] rolesUsuario;

    private List<Integer> checkUsuarios = new ArrayList<Integer>();
    
    
    public UsuarioFacade getEJBUsuario() {
        return EJBUsuario;
    }

    public void setEJBUsuario(UsuarioFacade EJBUsuario) {
        this.EJBUsuario = EJBUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Usuario> getLusuarios() {
        return lusuarios;
    }

    public void setLusuarios(List<Usuario> lusuarios) {
        this.lusuarios = lusuarios;
    }

    public Integer getNumUser() {
        return numUser;
    }

    public void setNumUser(Integer numUser) {
        this.numUser = numUser;
    }

    public String[] getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(String[] rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }

   
    
    
    
    public usuarioController() {
        
    }

    
    public void insertarUsuario(){
        Usuario objUsu = new Usuario();
        objUsu.setCodIdentificacion(codigoUsuario);
        objUsu.setNombreUsuario(nombreUsuario);
        objUsu.setContrasenia(contrasenia);
        objUsu.setNumUser(numUser);
        //objUsu.setRolesUsuarios(rolesUsuario);
        
     
        System.out.println("los datos son" + objUsu);
        EJBUsuario.insertarUsuarios(objUsu);
        
        System.out.println(codigoUsuario);
        System.out.println(nombreUsuario);
        System.out.println(contrasenia);
        System.out.println("Correctamento!");
    }

    public void comprobarUsuario() {

        boolean comprobar;
        String redirecciona;
        Usuario objUsu = new Usuario();
        objUsu.setNombreUsuario(nombreUsuario);
        objUsu.setContrasenia(contrasenia);

        System.out.println("los datos de login son" + objUsu);

        try {
            comprobar = EJBUsuario.validarUsuario(objUsu.getNombreUsuario(), objUsu.getContrasenia());

            if (comprobar = true) {
                String url = "http://localhost:8080/SegNotP2v1-web/"; //url donde se redirige la pantalla
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect(url);//redirecciona la página

                System.out.println(url);

                System.out.println("Logueado Exitosamente !!!");
                System.out.println(nombreUsuario);
                System.out.println(contrasenia);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
                System.out.println("Datos de Login Erroneos");
            }
        } catch (Exception e) {
            System.out.println("Error: " + objUsu.getContrasenia());
        }
        
        
    }
    
     public List<Usuario> extraerUsuarios(){
       
        List<Usuario> lista;
        lista = EJBUsuario.seleccionarUsuarios();
        
        return lista;
        
    }
     
     public List<Usuario> buscarUsuario(String codigo){
       
        List<Usuario> lista;
        lista = EJBUsuario.buscarUsuarioCod(codigo);
        return lista;
        
    }
     
     
     public void checkUsuario(ValueChangeEvent evento){
         String[] check = null;
         check = (String[]) evento.getNewValue();
         for(int i = 0; i<check.length; i++){
             checkUsuarios.add(Integer.valueOf(check[i]));
         }
     }
     
     public void eliminarUsuario(){
        List<Usuario> listaUsu = null;
        listaUsu = EJBUsuario.seleccionarUsuarios();
        
         System.out.println("/**********DATOS DE LA LISTA*********/"+listaUsu);
        String respuesta="";
        
         for (Integer in : checkUsuarios) {
             for (int i = 0; i < listaUsu.size(); i++) {
                 if (Objects.equals(in, listaUsu.get(i).getNumUser())) {
                     System.out.println("********************************************************");
                     System.out.println("El num de usuario seleccionado es:"+listaUsu.get(i).getNumUser());  
                     Integer valor = listaUsu.get(i).getNumUser();
                     respuesta = EJBUsuario.eliminarUsuarioCodigo(valor);
                     System.out.println("Encontrado............"+EJBUsuario.eliminarUsuarioCodigo(valor));
                 }
             }
         }
        checkUsuarios.clear();
     }
     
     public void eliminarUsuarioString(){
        List<Usuario> listaUsu = null;
        listaUsu = EJBUsuario.seleccionarUsuarios();
        
         System.out.println("/**********DATOS DE LA LISTA*********/"+listaUsu);
        String respuesta="";
        
         for (Integer in : checkUsuarios) {
             for (int i = 0; i < listaUsu.size(); i++) {
                 if (Objects.equals(in, listaUsu.get(i).getCodIdentificacion())) {
                     System.out.println("********************************************************");
                     System.out.println("El num de usuario seleccionado es:"+listaUsu.get(i).getNumUser());  
                     Integer valor = listaUsu.get(i).getNumUser();
                     String valorString = Integer.toString(valor);
                     respuesta = EJBUsuario.eliminarUsuarioCodigoString(valorString);
                     System.out.println("Encontrado............"+EJBUsuario.eliminarUsuarioCodigoString(valorString));
                 }
             }
         }
        checkUsuarios.clear();
     }
     
     
     
     
}

