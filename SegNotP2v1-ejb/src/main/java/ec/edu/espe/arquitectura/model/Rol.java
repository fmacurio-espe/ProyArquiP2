/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author User
 */
@Entity(noClassnameStored = true, value = "Rol")
public class Rol {
    //@Id
    //private ObjectId id;

    @Id
    private ObjectId id;
    
    
    @Property("codigoRol")
    @Indexed(options = @IndexOptions(name = "codigoRol",unique = true))
    private String codigoRol;

    @Property("nombreRol")
    private String nombreRol;

    @Property("descripcionRol")
    private String descripcionRol;

    @Property("funcionRoles")
    private String[] funcionRoles;
    
    //@Property("codigoFuncionalidad")
    //private List<String> codigoFuncionalidad;
    
    public Rol() {
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

    public String[] getFuncionRoles() {
        return funcionRoles;
    }

    public void setFuncionRoles(String[] funcionRoles) {
        this.funcionRoles = funcionRoles;
    }

  
    
    /*public List<String> getCodigoFuncionalidad() {
        return codigoFuncionalidad;
    }

    public void setCodigoFuncionalidad(List<String> codigoFuncionalidad) {
        this.codigoFuncionalidad = codigoFuncionalidad;
    }*/

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", codigoRol=" + codigoRol + ", nombreRol=" + nombreRol + ", descripcionRol=" + descripcionRol + ", funcionRoles=" + funcionRoles + '}';
    }
   
    
     
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigoRol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.codigoRol, other.codigoRol)) {
            return false;
        }
        return true;
    }
}
