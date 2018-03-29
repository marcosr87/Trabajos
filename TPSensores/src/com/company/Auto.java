package com.company;

import java.util.Observable;

/**
 * Created by alumno on 26/03/2018.
 */
public class Auto extends Observable implements Cloneable {

    private String Marca;
    private String Modelo;
    private double NiveldeAceite;
    private  double NivelAgua;
    private double PresionNeumaticos;

    public Auto(String marca, String modelo, double niveldeAceite, double nivelAgua, double presionNeumaticos)
    {

        this.Marca = marca;
        this.Modelo = modelo;
        this.NiveldeAceite = niveldeAceite;
        this.NivelAgua = nivelAgua;
        this.PresionNeumaticos = presionNeumaticos;

    }


        public void RepararAuto(Auto a) throws CloneNotSupportedException

        {
            Auto oldvalue = (Auto) this.clone();
            if (a.getNiveldeAceite()<110 || a.getNiveldeAceite()>110)
            a.NiveldeAceite = 110;
            if (a.getNivelAgua()<90 || a.getNivelAgua()>90)
            a.NivelAgua = 90;
            if (a.getPresionNeumaticos()>30 || a.getPresionNeumaticos()<30)
            a.PresionNeumaticos = 30;
            setChanged();
            notifyObservers(oldvalue);
        }




    public String toStringaceite() {
        return "Auto{" +
                "NiveldeAceite=" + NiveldeAceite +
                '}';
    }
    public String toStringagua() {
        return "Auto{" +
                "NivelAgua=" + NivelAgua +
                '}';
    }


    public String toStringneumaticos() {
        return "Auto{" +
                "PresionNeumaticos=" + PresionNeumaticos +
                '}';
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public double getNiveldeAceite() {
        return NiveldeAceite;
    }

    public void setNiveldeAceite(double niveldeAceite) {
        NiveldeAceite = niveldeAceite;
    }

    public double getNivelAgua() {
        return NivelAgua;
    }

    public void setNivelAgua(double nivelAgua) {
        NivelAgua = nivelAgua;
    }

    public double getPresionNeumaticos() {
        return PresionNeumaticos;
    }

    public void setPresionNeumaticos(double presionNeumaticos) {
        PresionNeumaticos = presionNeumaticos;
    }
}
