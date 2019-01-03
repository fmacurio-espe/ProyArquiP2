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
public class FechaRQ {

    private String FechaHoraActual;
    private String FechaActual;
    private String HoraActual;

    public String getFechaHoraActual() {
        return FechaHoraActual;
    }

    public void setFechaHoraActual(String FechaHoraActual) {
        this.FechaHoraActual = FechaHoraActual;
    }

    public String getHoraActual() {
        return HoraActual;
    }

    public void setHoraActual(String HoraActual) {
        this.HoraActual = HoraActual;
    }

    
    public String getFechaActual() {
        return FechaActual;
    }

    public void setFechaActual(String FechaActual) {
        this.FechaActual = FechaActual;
    }

    @Override
    public String toString() {
        return "FechaRQ{" + "FechaHoraActual=" + FechaHoraActual + ", FechaActual=" + FechaActual + ", HoraActual=" + HoraActual + '}';
    }

    
    
    
    public FechaRQ() {
    }

}
