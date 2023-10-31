package co.com.car_wash_metro.ModelDAO;

import co.com.car_wash_metro.Conexion.Conexion;
import co.com.car_wash_metro.Model.Cliente;
import co.com.car_wash_metro.Model.Reserva;
import co.com.car_wash_metro.Model.Usuario;

import java.security.cert.Extension;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelDAO {
    public static void crearUsuario(Usuario registro){
        try (Connection conexion = Conexion.get_connection()) {   // SE CAMBIO EL METODO POR LA CLASE CONEXION
            //PreparedStatement no sirve para preparar el qury de sql
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `usuario` (`CEDULA`, `NOMBRE`, `APELLIDO`, `CORREO`, `CONTRASEÑA`, `TELEFONO`) VALUES (?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, registro.getCedula());
                ps.setString(2, registro.getNombre());
                ps.setString(3, registro.getApellido());
                ps.setString(4, registro.getCorreo());
                ps.setString(5, registro.getContraseña());
                ps.setInt(6, registro.getTelefono());
                // SE UTILIZA CUANDO ESMOS UTILIZANDO PARa insert  DELETE UPDATE, execitequery, para
                ps.executeUpdate();
                System.out.println("registro de usario exitoso");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch ( SQLException e) {
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }

    public static void eliminarUsuario(int Cedula){
        try (Connection connect = Conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM usuario where cedula = ?";  ///  sintaxis de eliminar  prodcuto
                ps = connect.prepareStatement(query);
                ps.setInt(1, Cedula);
                ps.executeUpdate();  /// para eliminar  execute
                System.out.println("El usuario se  ha sido eliminado correctamente ");
            }catch (SQLException e){
                System.out.println("No se elimino  cliente");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void modificarUsuario(int cedulaActual, Usuario update){
        try (Connection connect = Conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                int opc = update.getOpc();
                System.out.println(opc);
                if (opc == 1){
                    String query = "UPDATE usuario SET cedula = ? WHERE cedula = ?";
                    ps = connect.prepareStatement(query);
                    ps.setInt(1, update.getCedula());
                    ps.setInt(2, cedulaActual);
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }else if (opc == 2){
                    String query = "UPDATE  usuario SET nombre = ? WHERE cedula = ? ";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getNombre());
                    ps.setInt(2, update.getCedula());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }else if (opc == 3) {
                    String query = "UPDATE  usuario SET apellido = ? WHERE cedula = ?";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getApellido());
                    ps.setInt(2, update.getCedula());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }else if (opc == 4) {
                    String query = "UPDATE  servicio SET correo = ?  WHERE cedula = ? ";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getCorreo());
                    ps.setInt(2, update.getCedula());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }else if (opc == 5) {
                    String query = "UPDATE  usuario SET telefono =?  WHERE cedula  =? ";
                    ps = connect.prepareStatement(query);
                    ps.setInt(1, update.getTelefono());
                    ps.setInt(2, update.getCedula());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }
            }catch (SQLException e) {
                System.out.println("no fue posiblle acatualizar el registro");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void realizarReservaDB(Reserva  reserva, Cliente cliente){
        try(Connection conexion = Conexion.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO reserva (fecha, hora, estado, id_cliente,celda , matricula)VALUES(?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setDate(1, reserva.getFecha());
                ps.setTime(2,reserva.getHora());
                ps.setInt(4, reserva.getId_cliente());
                ps.setInt(5, reserva.getId_celda());
                ps.setString(6, cliente.getMatricula());
                ps.executeUpdate();
                System.out.println("Registro de reserva exitoso!");
            }catch(SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }

    public static void listarReservaDB(){
        PreparedStatement ps = null;   // va a mandar la cosulta
        ResultSet rs = null; //  va a traer la consulta
        try (Connection connect = Conexion.get_connection()){
            String query ="SELECT * FROM Reserva";
            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();  //// delete , select de sql
            while (rs.next()){
                System.out.println("Id_cliente" + rs.getInt("id"));
                System.out.println("matricula" +  rs.getString("matricula"));
                System.out.println("fecha " +  rs.getDate("fecha"));
                System.out.println("hora "+ rs.getTime("hora"));
                System.out.println("estado " + rs.getString("estado"));
            }
        }catch (SQLException e){
            System.out.println("No se recuperaron registros");
            System.out.println(e);
        }
    }

    public static void modificarReserva(Reserva update, Cliente cliente) {
        try (Connection connect = Conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                int opc = update.getOpc();
                System.out.println(opc);
                if (opc == 1) {
                    String query = "UPDATE reserva SET fecha =?  WHERE Id_reserva =? ";
                    ps = connect.prepareStatement(query);
                    ps.setDate(1, update.getFecha());
                    ps.setInt(2, update.getId_reserva());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                } else if (opc == 2) {
                    String query = "UPDATE  reservs SET hora =?  WHERE Id_reserva  =? ";
                    ps = connect.prepareStatement(query);
                    ps.setTime(1, update.getHora());
                    ps.setInt(2, update.getId_reserva());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                } else if (opc == 3) {
                    String query = "UPDATE  reserva SET celda =?  WHERE id_reserva   =? ";
                    ps = connect.prepareStatement(query);
                    ps.setInt(1, update.getId_celda());
                    ps.setInt(2, update.getId_reserva());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                } else if (opc == 4) {
                    String query = "UPDATE  reserva SET matricula =?  WHERE id_reserva   =? ";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, cliente.getMatricula());
                    ps.setInt(2, update.getId_reserva());
                    ps.executeUpdate();
                    System.out.println("Actualizacion exitosa");
                }
            } catch (SQLException e) {
                System.out.println("no fue posiblle acatualizar el registro");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void eliminarReserva(int id_reserva){
        try (Connection connect = Conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM reserva where id_reserva = ?";  ///  sintaxis de eliminar  prodcuto
                ps = connect.prepareStatement(query);
                ps.setInt(1, id_reserva);
                ps.executeUpdate();  /// para eliminar  execute
                System.out.println("La reserva se  ha sido eliminado correctamente ");
            } catch (SQLException e) {
                System.out.println("No se elimino  reserva");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}


