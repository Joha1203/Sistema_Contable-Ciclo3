package com.example.demo.modelos;

public class MovimientoDinero {
    private double montoMovimiento;
    private String concepto;
    private String remitente;

    public MovimientoDinero() {
    }

    public MovimientoDinero(double montoMovimiento, String concepto, String remitente) {
        this.montoMovimiento = montoMovimiento;
        this.concepto = concepto;
        this.remitente = remitente;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getRemitente() {
        return remitente;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "montoMovimiento=" + montoMovimiento +
                ", concepto='" + concepto + '\'' +
                ", remitente='" + remitente + '\'' +
                '}';
    }
}
