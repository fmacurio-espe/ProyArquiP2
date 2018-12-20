/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.managedBeans;

import ec.edu.espe.arquitectura.model.Funcionalidad;
import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.session.FuncionalidadFacade;
import ec.edu.espe.arquitectura.session.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

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
    
    
    String codigoUsuario;
    String nombreUsuario;
    String contrasenia;
    String identificacion;
    String nombres;
    String apellidos;
    String correo;

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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
    public usuarioController() {
    }

    
    
    public void insertarUsuario(){
        Usuario objUsu = new Usuario();
        objUsu.setCodIdentificacion(codigoUsuario);
        objUsu.setNombreUsuario(nombreUsuario);
        objUsu.setContrasenia(contrasenia);
        objUsu.setIdentificacion(identificacion);
        objUsu.setNombres(nombres);
        objUsu.setApellidos(apellidos);
        objUsu.setCorreoE(correo);
        
                
                
        System.out.println("los datos son" + objUsu);
        EJBUsuario.insertarUsuario(objUsu);
        
        System.out.println(codigoUsuario);
        System.out.println(nombreUsuario);
        System.out.println(contrasenia);
        System.out.println("Correctamento!");
    }
    
}
