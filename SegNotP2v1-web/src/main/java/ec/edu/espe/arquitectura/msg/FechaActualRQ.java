/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.msg;

import java.util.Date;

/**
 *
 * @author User
 */
public class FechaActualRQ {
    Date FechaActual;

    public Date getFechaActual() {
        return FechaActual;
    }

    public void setFechaActual(Date FechaActual) {
        this.FechaActual = FechaActual;
    }

    @Override
    public String toString() {
        return "FechaActualRQ{" + "FechaActual=" + FechaActual + '}';
    }

    public FechaActualRQ() {
    }
    
    
    
}
