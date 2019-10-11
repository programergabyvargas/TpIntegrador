package com.example.tpintegrador.ui.inquilinos;

import android.icu.lang.UCharacter;

public class Inquilino {
    private String dni;
    private String apellido;
    private String nombre;
    private String Direccion;
    private String telefono;

    public Inquilino(String dni, String apellido, String nombre, String direccion, String telefono) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        Direccion = direccion;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
