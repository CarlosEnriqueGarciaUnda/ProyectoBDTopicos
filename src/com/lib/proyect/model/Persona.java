package com.lib.proyect.model;

public class Persona {
    private String nombre;
    private String appellidoPaterno;
    private String apellidoMaterno;
    private int idPersona;
    private int CURP;

    public Persona(String nombre, String appellidoPaterno, String apellidoMaterno, int idPersona, int CURP) {
        this.nombre = nombre;
        this.appellidoPaterno = appellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idPersona = idPersona;
        this.CURP = CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellidoPaterno() {
        return appellidoPaterno;
    }

    public void setAppellidoPaterno(String appellidoPaterno) {
        this.appellidoPaterno = appellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getCURP() {
        return CURP;
    }

    public void setCURP(int CURP) {
        this.CURP = CURP;
    }
}
