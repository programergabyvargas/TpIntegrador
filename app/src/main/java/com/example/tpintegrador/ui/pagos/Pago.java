package com.example.tpintegrador.ui.pagos;

import android.widget.DatePicker;

public class Pago {
    private int nroPago;
    private String fecha;
    private double importe;
    private String propiedad;


    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public Pago(int nroPago, String fecha, double importe, String propiedad) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.propiedad = propiedad;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean equals (Object o){
      if (o != null && o instanceof Pago){
          Pago pago = (Pago) o;
          if(pago.getNroPago() == nroPago){
              return true;
          }
      }
      return false;
    }
}
