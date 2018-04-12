package com.company;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Created by alumno on 01/04/2018.
 */
public class Mazo implements Observer {

    Stack mazo ;
    Jugador j1;
    Jugador j2;
    Jugador j3;
    Jugador j4;
    Cartas carta;


    public Mazo(){

        this.mazo= new Stack<Cartas>();
        crearPalo(12,"oro");
        crearPalo(12,"espada");
        crearPalo(12,"basto");
        crearPalo(12,"copa");


    }

    private void crearPalo(int cartas, String palo){
        int i;
        for(i=0;i<cartas;i++){
            Cartas nueva = new Cartas(i+1,palo);
            this.mazo.push(nueva);
        }
    }

    public synchronized Cartas recibircarta()
    {

        while (mazo.empty())
        {


            try
            {



                wait();



            }


            catch (InterruptedException e)
            { }


        }

        notifyAll();
        return (Cartas) mazo.pop();


    }

    public void DarCarta (Cartas cartas, int id)
    {
        if(j1.getId() == 1)
            j1.getMazojug().add(cartas);
        if (j2.getId() == 2)
            j2.getMazojug().add(cartas);
        if(j3.getId() == 3)
            j3.getMazojug().add(cartas);
        if (j4.getId() == 4)
            j4.getMazojug().add(cartas);
        }

    public void setJugadores(Jugador j1, Jugador j2, Jugador j3, Jugador j4) {
        this.j1=j1;
        this.j2=j2;
        this.j3=j3;
        this.j4=j4;
    }

    public void Gameover() {
        if (mazo.empty()) {

            System.out.println("FINALIZO LA PARTIDA RESULTADOS");
            System.out.println(j1.getMazojug().size() + j1.getNombre());
            System.out.println(j2.getMazojug().size() + j2.getNombre());

            System.out.println(j3.getMazojug().size() + j3.getNombre());

            System.out.println(j4.getMazojug().size() + j4.getNombre());

            avisarGanador();
        }

    }


    public void avisarGanador(){
        Jugador J;
        System.out.println("GRACIAS POR JUGAR");
        if(j1.getMazojug().size() >= j2.getMazojug().size() && j1.getMazojug().size()>=j3.getMazojug().size() && j1.getMazojug().size()>=j4.getMazojug().size()) {
            System.out.println("El Ganador es: " + j1.getNombre() + " La cantidad de cartas es:" + j1.getMazojug().size());
            J = j1;
            guardarGanador(J);
        }
        if(j2.getMazojug().size()>=j1.getMazojug().size() && j2.getMazojug().size()>=j3.getMazojug().size() && j2.getMazojug().size()>=j4.getMazojug().size()){

            System.out.println("El Ganador es: " + j2.getNombre() + " La cantidad de cartas es:" + j2.getMazojug().size());
            J= j2;
            guardarGanador(J);

        }


        if(j3.getMazojug().size()>=j1.getMazojug().size() && j3.getMazojug().size()>=j2.getMazojug().size() && j3.getMazojug().size()>=j4.getMazojug().size()){
        System.out.println("El Ganador es: " + j3.getNombre() + " La cantidad de cartas es:" + j3.getMazojug().size());
        J = j3;
        guardarGanador(J);
        }
        if(j4.getMazojug().size()>=j1.getMazojug().size() && j4.getMazojug().size()>=j2.getMazojug().size() && j4.getMazojug().size()>=j3.getMazojug().size()){

            System.out.println("El Ganador es: " + j4.getNombre() + " La cantidad de cartas es:" + j4.getMazojug().size());
            J = j4;
            guardarGanador(J);
        }
            
    }

    private void guardarGanador(Jugador j){
        Conexion conexion = new Conexion();
        conexion.ejecutarQuery(j.getNombre(), j.getMazojug().size());
    }

    public Cartas sacarCarta ()
    {
        return (Cartas) mazo.pop();
    }

    public void cargarCarta (Cartas l)
    {
        mazo.push(l);
    }

    public boolean estadoMazo ()
    {
        return mazo.empty();
    }

    @Override
    public void update(Observable o, Object arg) {

        Jugador jugador = (Jugador) o;
        Cartas valorCarta = (Cartas) arg;
        System.out.println("El jugadxr: " + jugador.getNombre() + " obtiene carta con valor: " + valorCarta);
        
    }
}
