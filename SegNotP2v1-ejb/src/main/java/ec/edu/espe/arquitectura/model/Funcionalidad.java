/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author User
 */
@Entity(noClassnameStored = true, value = "Funcionalidad")
public class Funcionalidad {
    @Id
    private ObjectId id;
    
    
    @Property("codigoFuncionalidad")
    private String codigoFuncionalidad;
    @Property("nombreFuncionalidad")
    private String nombreFuncionalidad;
    @Property("recurso")
    private String recurso;

    public Funcionalidad() {
    }

    public String getCodigoFuncionalidad() {
        return codigoFuncionalidad;
    }

    public void setCodigoFuncionalidad(String codigoFuncionalidad) {
        this.codigoFuncionalidad = codigoFuncionalidad;
    }

    public String getNombreFuncionalidad() {
        return nombreFuncionalidad;
    }

    public void setNombreFuncionalidad(String nombreFuncionalidad) {
        this.nombreFuncionalidad = nombreFuncionalidad;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return "Funcionalidad{" + "codigoFuncionalidad=" + codigoFuncionalidad + ", nombreFuncionalidad=" + nombreFuncionalidad + ", recurso" + recurso + '}';
    }
    
}
