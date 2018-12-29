/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author User
 */
@Entity(noClassnameStored = true, value = "Usuario")
public class Usuario{
    
    @Id
    private ObjectId id;
    
    @Property("codIdentificacion")    
    @Indexed(options = @IndexOptions(name = "codIdentificacion",unique = true))
    private String codIdentificacion;
    
    @Property("nombreUsuario")    
    private String nombreUsuario;
    @Property("contrasenia")    
    private String contrasenia;
    
    @Property("numUser")    
    private Integer numUser;
    
    @Property("rolesUsuarios")    
    private String[] rolesUsuarios;
    
    //@Property("numusuario")    
    //private Integer numusuario;
    
    
//@Property("Rol")
    //private List<Rol> rol;
    
    @Property("codigoRol")
    private List<String> codigoRol;
    /*
    @Property("nombres")    
    private String nombres;
    @Property("apellidos")    
    private String apellidos;
    @Property("correoElectronico")    
    private String correoElectronico;
    @Property("numTelefono")    
    private String numTelefono;

    */
    
    public Usuario() 
    {
    
    }

    public List<String> getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(List<String> codigoRol) {
        this.codigoRol = codigoRol;
    }

    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(String codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
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

    public Integer getNumUser() {
        return numUser;
    }

    public void setNumUser(Integer numUser) {
        this.numUser = numUser;
    }

    public String getRolesUsuarios() {
        return Arrays.toString(rolesUsuarios);
    }

    public void setRolesUsuarios(String[] rolesUsuarios) {
        this.rolesUsuarios = rolesUsuarios;
    }

    
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", codIdentificacion=" + codIdentificacion + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", codigoRol=" + codigoRol + '}';
    }

   
    
}
