package com.company;

/**
 * Created by alumno on 01/04/2018.
 */
public class Cartas {

    private int idCarta;
    private String Palo;

    public Cartas (int id,String p)
    {
        this.setIdCarta(id);
        this.setPalo(p);
    }


    private int getIdCarta() {
        return idCarta;
    }



    private void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    private String getPalo() {
        return Palo;
    }

    private void setPalo(String palo) {
        Palo = palo;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "idCarta=" + idCarta +
                ", Palo='" + Palo + '\'' +
                '}';
    }
}
