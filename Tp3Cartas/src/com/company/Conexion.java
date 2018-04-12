package com.company;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by alumno on 11/04/2018.
 */
public class Conexion {

            private Connection conn = null;

            public Conexion(){
                try {
                    String host = "localhost";
                    int port = 3306;
                    String db = "tp3Cartas";
                    String user = "root";
                    String password = "";

                    String url1 = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

                    conn = DriverManager.getConnection(url1, user, password);

                    if (conn != null) {
                        System.out.println("\nConectado a la base de datos del juego");
                    }
                } catch (SQLException ex) {
                    System.out.println("\nNo se pudo conectar a la base de datos");
                    ex.printStackTrace();
                }
            }

            public void ejecutarQuery(String nombre, int cantidadCartas){

                try {
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                    String query = " insert into juegos (nombreGanador, cantCartas, fecha)"
                            + " values (?, ?, ?)";

                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, nombre);
                    preparedStmt.setInt (2, cantidadCartas);
                    preparedStmt.setDate   (3, startDate);

                    preparedStmt.execute();

                    conn.close();

                    System.out.printf("\nJugador ganador guardado !!");
                } catch (Exception e)
                {
                    System.err.println("ocurrio algun problema al guardar el jugador");
                    System.err.println(e.getMessage());
                }
            }

}
