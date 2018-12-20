/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

/**
 *
 * @author User
 */
public class Transaccion {

    private String userId; 
    private String numCuenta;
    private String tipo;
    private String monto;
    
    public Transaccion() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Mail{" + "userId=" + userId + ", numCuenta=" + numCuenta + ", tipo=" + tipo + ", monto=" + monto + '}';
    }
    
    
    
    
}
