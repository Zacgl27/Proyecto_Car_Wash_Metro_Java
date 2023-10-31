package co.com.car_wash_metro.Tests;

import co.com.car_wash_metro.Conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

    public static void main(String[] args) {

        try(Connection connect = Conexion.get_connection()){

        }catch(SQLException e){
            System.out.println(e);
        }finally{
            Conexion.close_connection();
        }

    }

}
