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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    
    private String codigoFuncionalidad="";
    private String nombreFuncionalidad="";
    private String recurso="";
    private String msg="";
    
    
    List<Funcionalidad> listFuncionTodo = new ArrayList<Funcionalidad>();

    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public List<Funcionalidad> getListFuncionTodo() {
        return listFuncionTodo;
    }

    public void setListFuncionTodo(List<Funcionalidad> listFuncionTodo) {
        this.listFuncionTodo = listFuncionTodo;
    }
    
    
    public funcionalidadController() {
        
    }
    @PostConstruct
    public void funcionalidadController(){
        try {
            this.listFuncionTodo = EJBFuncionalidad.listaFuncionalidadesTodas();
        } catch (Exception e) {
            System.out.println("error lista");
        }
    }
        
    
    public void insertarFuncionalidad(){
        
        Funcionalidad objFun = new Funcionalidad();
        objFun.setCodigoFuncionalidad(codigoFuncionalidad);
        objFun.setNombreFuncionalidad(nombreFuncionalidad);
        objFun.setRecurso(recurso);
        System.out.println("los datos son" + objFun);
        msg="";
        try {
            EJBFuncionalidad.insertarFuncionalidad(objFun);
            this.listFuncionTodo = EJBFuncionalidad.listaFuncionalidadesTodas();
            this.msg="se ingreso correctamente";
        } catch (Exception e) {
            this.msg="error en el ingreso";
        }
        
        System.out.println(msg);
    }
    
    
     public List<Funcionalidad> extraerFuncionalidades(){
      //extraerRolesUsusarios();
      List<Funcionalidad> lista;
      lista = EJBFuncionalidad.listaFuncionalidadesTodas();
      return lista;   
    }
    
    
}
