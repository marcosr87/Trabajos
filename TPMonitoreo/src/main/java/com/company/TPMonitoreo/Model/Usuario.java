package com.company.TPMonitoreo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by alumno on 24/04/2018.
 */

@Entity


public class Usuario  {
    @Id
    @GeneratedValue  ( strategy = GenerationType.AUTO)
    private long id;
    private String nombreBrowser;
    private String nombreSO;
    private LocalDateTime Fecha;
    public Usuario (String nombreSO, String nombreBrowser ){

        this.setNombreBrowser(nombreBrowser);
        this.setNombreSO(nombreSO);
        this.Fecha = LocalDateTime.now();

    }

    protected Usuario (){}




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreBrowser() {
        return nombreBrowser;
    }

    public void setNombreBrowser(String nombreBrowser) {
        this.nombreBrowser = nombreBrowser;
    }

    public String getNombreSO() {
        return nombreSO;
    }

    public void setNombreSO(String nombreSO) {
        this.nombreSO = nombreSO;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreBrowser='" + nombreBrowser + '\'' +
                ", nombreSO='" + nombreSO + '\'' +
                ", Fecha=" + getFecha() +
                '}';
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }
}
