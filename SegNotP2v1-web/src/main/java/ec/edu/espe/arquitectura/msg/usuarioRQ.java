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
        return "usuarioRQ{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }

    public usuarioRQ() {
    }
    
    
    
}
