package co.com.car_wash_metro.tests;

import co.com.car_wash_metro.conexion.Conexion;

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
