package es.eoi.ejercicios.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

    public static void main(String[] args){

        String jdbcUrl = "jdbc:mysql://localhost:3306/pruebas_hibernate?useSSL=false";
        String user = "root";
        String pass = "root";

        try{
            System.out.println("Intentando conectar");

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Conectado!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
