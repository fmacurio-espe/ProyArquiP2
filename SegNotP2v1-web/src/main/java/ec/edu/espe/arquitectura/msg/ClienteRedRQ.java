/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.msg;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
public class ClienteRedRQ {

    private String apellidos;
    private Integer codigo;
    private String correoElectronico;
    private String nombres;
    private String identificacion;
    
    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public ClienteRedRQ() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "ClienteRedRQ{" + "apellidos=" + apellidos + ", codigo=" + codigo + ", correoElectronico=" + correoElectronico + ", nombres=" + nombres + ", identificacion=" + identificacion + '}';
    }
    
    
    
    
    

}
