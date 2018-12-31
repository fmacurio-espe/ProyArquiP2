/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.managedBeans;

import ec.edu.espe.arquitectura.model.Funcionalidad;
import ec.edu.espe.arquitectura.session.FuncionalidadFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author User
 */
@Named(value = "rolController")
@Dependent
public class rolController {

    @EJB
    FuncionalidadFacade EJBFun;
    /**
     * Creates a new instance of rolController
     */        
            
    String nombreRol;
    String Descripcion;
    List<Funcionalidad> lfun=new ArrayList<Funcionalidad>();
    List<Funcionalidad> Selfun=new ArrayList<Funcionalidad>();
    public rolController() {
        Funcionalidad a=new Funcionalidad();
        a.setCodigoFuncionalidad("a");
        a.setNombreFuncionalidad("b");
        a.setRecurso("s");
        lfun.add(a);
    }
    @PostConstruct
    public void rolController(){
        try {
            this.lfun = EJBFun.listaFuncionalidadesTodas();
        } catch (Exception e) {
            System.out.println("error lista");
        }
    }
    

    public List<Funcionalidad> getSelfun() {
        return Selfun;
    }

    public void setSelfun(List<Funcionalidad> Selfun) {
        this.Selfun = Selfun;
    }

    
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public List<Funcionalidad> getLfun() {
        return lfun;
    }

    public void setLfun(List<Funcionalidad> lfun) {
        this.lfun = lfun;
    }

    
    
    
    
}
