/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.util.Date;
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
@Entity(noClassnameStored = true, value = "FechaProceso")
public class FechaProceso {
    @Id
    private ObjectId id;
    
    
    @Property("codFA")
    @Indexed(options = @IndexOptions(name = "codFA",unique = true))
    String codFA;
    @Property("FechaProcesoActual")
    Date FechaProcesoActual;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodFA() {
        return codFA;
    }

    public void setCodFA(String codFA) {
        this.codFA = codFA;
    }

    public Date getFechaProcesoActual() {
        return FechaProcesoActual;
    }

    public void setFechaProcesoActual(Date FechaProcesoActual) {
        this.FechaProcesoActual = FechaProcesoActual;
    }

    @Override
    public String toString() {
        return "FechaProceso{" + "id=" + id + ", codFA=" + codFA + ", FechaProcesoActual=" + FechaProcesoActual + '}';
    }

    public FechaProceso() {
    }
    
    
    
    
}
