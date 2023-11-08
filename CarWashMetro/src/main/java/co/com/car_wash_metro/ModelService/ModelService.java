package co.com.car_wash_metro.modelService;

import co.com.car_wash_metro.model.Reserva;
import co.com.car_wash_metro.model.Usuario;
import co.com.car_wash_metro.modelDAO.ModelDAO;


import java.util.Scanner;

public class ModelService {

    static Scanner sc = new Scanner(System.in);

    //funciones
    public static void crearUsuario(String rol) {
        System.out.println("Ingrese su cedula ");
        int cedula = sc.nextInt();
        System.out.println("Ingrese su nombre");
        String nombre = sc.next();
        System.out.println("IngrEse su apellido");
        String apellido = sc.next();
        System.out.println("Ingrese su correo");
        String correo = sc.next();
        System.out.println("Ingrese su telefono");
        int telefono = sc.nextInt();
        System.out.println("Ingrese su contraseña");
        String contraseña = sc.next();

        Usuario registro = new Usuario();

        //seteo pasando argumento dentro los parentesis
        registro.setCedula(cedula);
        registro.setNombre(nombre);
        registro.setApellido(apellido);
        registro.setCorreo(correo);
        registro.setTelefono(telefono);
        registro.setContraseña(contraseña);
        registro.setRol(rol);

        ModelDAO.crearUsuario(registro);
    }

    public static void eliminarUsuario() {
        System.out.println("Indiquela cedula del usuaro  a eliminar ");

        int cedula = sc.nextInt();

        ModelDAO.eliminarUsuario(cedula);

    }

    public static void modificarUsuario() {
        System.out.println("Indique  para modificar 1. cedula 2.  nombre  3.apellido   4.correo  5.telefono");
        int id;
        sc.skip("\n");
        int opc = sc.nextInt();

        Usuario usuario = new Usuario();
        switch (opc) {
            case 1:
                System.out.println("Modificar cedula");
                System.out.println("Ingrese la cedula actual");
                int cedulaActual = sc.nextInt();
                System.out.println("Indique la nueva cedula");
                int nuevaCedula = sc.nextInt();
                opc = 1;

                usuario.setOpc(opc);

                usuario.setCedula(nuevaCedula);
                ModelDAO.modificarUsuario(cedulaActual, usuario);
                break;
            case 2:
                System.out.println("Modificar  nombre");
                System.out.println("Ingrese la cedula del usuario ");
                int cedula = sc.nextInt();
                System.out.println("Indique el nombre nuevo");
                String nombre = sc.next();

                opc = 2;
                usuario.setOpc(opc);

                usuario.setCedula(cedula);
                usuario.setNombre(nombre);
                ModelDAO.modificarUsuario(cedula, usuario);
                break;
            case 3:
                System.out.println("Modificar apellido");
                System.out.println("Ingrese la cedula para modificar");
                cedula = sc.nextInt();
                System.out.println("Indique el apellido nuevo");
                String apellido = sc.nextLine();
                opc = 3;
                usuario.setOpc(opc);

                usuario.setApellido(apellido);
                usuario.setCedula(cedula);
                ModelDAO.modificarUsuario(cedula, usuario);
                break;

            case 4:
                System.out.println("Modificar correo");
                System.out.println("Ingrese la cedula para modificar");
                cedula = sc.nextInt();
                System.out.println("indique el correo o");
                String correo = sc.nextLine();
                opc = 4;
                usuario.setOpc(opc);

                usuario.setCorreo(correo);
                usuario.setCedula(cedula);
                ModelDAO.modificarUsuario(cedula, usuario);
                break;

            case 5:
                System.out.println("Modificar telefono");
                System.out.println("Ingrese la cedula  para modificar tl");
                cedula = sc.nextInt();
                System.out.println("Indique el telefono  del usuario");
                int telefono = sc.nextInt();
                opc = 5;
                usuario.setOpc(opc);

                usuario.setTelefono(telefono);
                usuario.setCedula(cedula);
                ModelDAO.modificarUsuario(cedula, usuario);
                break;

            default:
                System.out.println("Seleccione una opcion correcta");
        }
    }

    public static void realizarReserva() {
        System.out.println("Fecha de la reserva: ");
        String fecha = sc.next();
        System.out.println("Hora de la reserva: ");
        String hora = sc.next();
        System.out.println("estado de la reserva: ");
        String estado = sc.next();
        System.out.println("Cedula de cliente");
        int cedula = sc.nextInt();
        System.out.println("Matricula de vehiculo");
        String matricula = sc.next();

        Reserva reserva = new Reserva();
        Usuario cliente= new Usuario();

        cliente.setCedula(cedula);

        //reserva.setFecha(fecha);
        //reserva.setHora(hora);
        reserva.setEstado(estado);
        reserva.setId_cliente(cedula);
        reserva.setMatricula(matricula);


        ModelDAO.realizarReservaDB(reserva, cliente);


    }

    public static void eliminarReserva() {
        System.out.println("bgrese el id de la reserva para eliminar ");
        int id_reserva = sc.nextInt();

        ModelDAO.eliminarReserva(id_reserva);
    }
    public static String iniciarSesion(){
        String rol = "";

        System.out.println("Ingrese su correo");
        String correo = sc.next();

        System.out.println("Ingrese su contraseña");
        String contraseña = sc.next();

       Usuario usuario = ModelDAO.iniciarSesion(correo);

       if (usuario.getCorreo() == null){
           System.out.println("El usuario no existe");
       }else {
           if (usuario.getContraseña().equals(contraseña)){
               rol = usuario.getRol();
           }else{
               System.out.println("Contraseña  no es correcta");
           }
       }

       return rol;
    }
    public  static  void listarReserva(){
        ModelDAO.listarReservaDB();
    }
}
