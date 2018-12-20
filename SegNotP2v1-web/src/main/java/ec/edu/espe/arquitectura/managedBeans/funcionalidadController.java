/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.managedBeans;

import ec.edu.espe.arquitectura.model.Funcionalidad;
import ec.edu.espe.arquitectura.session.FuncionalidadFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
@Named(value = "funcionalidadController")
@SessionScoped
public class funcionalidadController implements Serializable {

    /**
     * Creates a new instance of funcionalidadController
     */
    
    @EJB
    FuncionalidadFacade EJBFuncionalidad;
    
    
    String codigoFuncionalidad;
    String nombreFuncionalidad;
    String recurso;

    public FuncionalidadFacade getEJBFuncionalidad() {
        return EJBFuncionalidad;
    }

    public void setEJBFuncionalidad(FuncionalidadFacade EJBFuncionalidad) {
        this.EJBFuncionalidad = EJBFuncionalidad;
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
    
    
    
    public funcionalidadController() {
    
    }

    
    public void insertarFuncionalidad(){
        Funcionalidad objFun = new Funcionalidad();
        objFun.setCodigoFuncionalidad(codigoFuncionalidad);
        objFun.setNombreFuncionalidad(nombreFuncionalidad);
        objFun.setRecurso(recurso);
        System.out.println("los datos son" + objFun);
        EJBFuncionalidad.insertarFuncionalidad(objFun);
        
        System.out.println(codigoFuncionalidad);
        System.out.println("se ejecuto correctamente");
    }
    
}
