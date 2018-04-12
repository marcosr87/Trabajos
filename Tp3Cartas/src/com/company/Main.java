package com.company;

public class Main {

    public static void main(String[] args) {


	// write your code here

        Mazo maz = new Mazo();

        Jugador jug1= new Jugador(maz,"Pablo",1);
        Jugador jug2= new Jugador(maz,"Marcos",2);
        Jugador jug3= new Jugador(maz,"Julia",3);
        Jugador jug4= new Jugador(maz,"Amelie",4);
        maz.setJugadores(jug1,jug2,jug3,jug4);

        Thread jugador1 = new Thread(jug1);
        Thread jugador2 = new Thread(jug2);
        Thread jugador3 = new Thread(jug3);
        Thread jugador4 = new Thread(jug4);




        jugador1.start();
        jugador2.start();
        jugador3.start();
        jugador4.start();



    }
}
