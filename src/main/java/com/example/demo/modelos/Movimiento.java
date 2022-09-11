package com.example.demo.modelos;

public class Movimiento {

    private String id;
    private String concepto;
    private String monto;
    private String usuario;
    private String empresa;

    public Movimiento(String id, String concepto, String monto, String usuario, String empresa) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id='" + id + '\'' +
                ", concepto='" + concepto + '\'' +
                ", monto='" + monto + '\'' +
                ", usuario='" + usuario + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }

}
