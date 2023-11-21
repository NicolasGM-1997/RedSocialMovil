package com.example.redsocial;

public class Usuario {
    private String user,nombre,ciudad,fecha,pass;

    public Usuario(String user, String nombre, String ciudad, String fecha, String pass) {
        this.user = user;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
