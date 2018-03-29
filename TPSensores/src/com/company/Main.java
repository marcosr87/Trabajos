package com.company;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	// write your code here

        Auto observado = new Auto("Renault","Megane",48,23,30);

        Mecanico observador = new Mecanico(observado);
        observado.RepararAuto(observado);
    }
}
