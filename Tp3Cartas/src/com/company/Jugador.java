package com.company;

import java.util.Observable;
import java.util.Random;
import java.util.Stack;

import static java.lang.Thread.sleep;

/**
 * Created by alumno on 01/04/2018.
 */
public class Jugador extends Observable implements Runnable {

    public Mazo mazo;
    public String Nombre;
    public int id;
    public Cartas carta;
    public Stack<Cartas> mazojug ;


    public Jugador (Mazo m ,String nom, int id)
    {
        this.setMazo(m);
        this.setId(id);
        this.setNombre(nom);
        addObserver(m);
        this.setMazojug(new Stack<Cartas>());
        

    }



    int aleatorio ()
    {
        Random ran = new Random();

        int val = ran.nextInt()%1500;

        if (val<0)
        {
            val = val* (-1);
        }
        return val;
    }

    @Override
    public void run() {

        try {
            for (; ; ) {
                Cartas c = mazo.recibircarta();
               this.mazojug.push(c);


              //  System.out.println("El Judador " + this.getNombre() + " recibe la carta " + this.getCarta().toString());
                //mazo.DarCarta(c,this.getId());
                setChanged();
                notifyObservers(c);
                mazo.Gameover();
                sleep((long) aleatorio());

            }
        }
            catch (InterruptedException e)
            {}


    }





    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Cartas getCarta() {
        return carta;
    }

    public void setCarta(Cartas carta) {
        this.carta = carta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stack<Cartas> getMazojug() {
        return mazojug;
    }

    public void setMazojug(Stack<Cartas> mazojug) {
        this.mazojug = mazojug;
    }
}

