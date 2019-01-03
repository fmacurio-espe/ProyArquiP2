/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.msg;

/**
 *
 * @author User
 */

public class usuarioRQ {
    String usuario;
    String clave;
    String ci;
    String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "usuarioRQ{" + "usuario=" + usuario + ", clave=" + clave + ", ci=" + ci + ", rol=" + rol + '}';
    }

    
    
    public usuarioRQ() {
    }
    
    
    
}
