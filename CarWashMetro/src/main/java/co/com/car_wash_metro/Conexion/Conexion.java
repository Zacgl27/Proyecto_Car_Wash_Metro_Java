package co.com.car_wash_metro.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Conexion instancia;

    private static Connection connect;

    private Conexion(){

        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/carwash", "root", "");
            if(connect!=null){
                System.out.println("La conexión ha sido exitosa");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static Connection get_connection(){

        System.out.println("Antes de pedir: " + connect);

        if(connect==null){
            new Conexion();
        }

        System.out.println("Cuando la llamo: " + connect);

        return connect;

    }

    public static void close_connection(){

        try{

            System.out.println("Antes de cerrar: " + connect);

            if(connect!=null){
                connect.close();
                connect = null;
            }

        }catch(SQLException e){
            System.out.println(e);
        }

        System.out.println("Despues de cerrar: " + connect);

    }

}
