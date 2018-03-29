package com.company;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alumno on 26/03/2018.
 */
public class Mecanico implements Observer {

    Auto observado;

    private String Nombre;

    public Mecanico ( Auto auto)
    {
        this.Nombre = "Miguel";
        observado = auto;
        observado.addObserver(this);
    }

    @Override
    public void update(Observable auto, Object queEstado) {
        Auto a = (Auto) auto;
        Auto b = (Auto) queEstado;
        if (auto != observado) {
            throw new IllegalArgumentException();
        }


        if (a.toStringaceite().equals(b.toStringaceite())) {
            System.out.println("El atributo Aceite no se modifico sigue siendo:" + a.toStringaceite());
        } else {
            System.out.println("Estado Actual de Aceite : " + a.toStringaceite() + "Estado anterior " + ((Auto) queEstado).toStringaceite());
        }
        if (a.toStringagua().equals(b.toStringagua())) {
            System.out.println("El atributo Agua no se modifico sigue siendo:" + a.toStringagua());
        } else {
            System.out.println("Estado Actual de Agua : " + a.toStringagua() + "Estado anterior " + ((Auto) queEstado).getNivelAgua());
        }
        if (a.toStringneumaticos().equals(b.toStringneumaticos())) {
            System.out.println("El atributo Neumaticos no se modifico sigue siendo:" + a.toStringneumaticos());
        } else {

            System.out.println("Estado Actual de Neumaticos : " + a.toStringneumaticos() + "Estado anterior " + ((Auto) queEstado).getPresionNeumaticos());
        }
    }
}
