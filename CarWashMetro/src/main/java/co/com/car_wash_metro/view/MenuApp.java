package co.com.car_wash_metro.view;

import java.util.Scanner;
import co.com.car_wash_metro.modelService.ModelService;

public class MenuApp {

    Scanner sc= new Scanner(System.in);

    ModelService service = new ModelService();

    public  void menuPrincipal(){

        System.out.println("Menu Principal");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Registrarse");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Iniciar sesion");
                String rol = service.iniciarSesion();
                if (rol.equals("administrador")){
                    menuAdministrador();

                }else if (rol.equals("cliente")) {
                    menuCLiente();

                 }
                break;
            case 2:
                System.out.println("Registrarse");
                service.crearUsuario("cliente");
                break;
        }




    }
    public void  menuAdministrador (){

        System.out.println("Menu Administrador");
        System.out.println("1. Crear Empleado \n" +
                "2. Eliminar Empleado \n" +
                "3. Modificar CLiente \n" +
                "4.Realizar reserva \n" +
                "5. ELimianr reserva \n" +
                        "6. Listar reservas");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Crear empleado");
                service.crearUsuario("empleado");
                break;
            case 2:
                System.out.println("Eliminar empleado");
                service.eliminarUsuario();
                break;
            case 3:
                System.out.println("Modificar Usuario");
                service.modificarUsuario();
                break;
            case 4:
                System.out.println("Realizar reserva");

                service.realizarReserva();
                break;
            case 5:
                System.out.println("Eliminar reserva");
                service.eliminarReserva();
                break;
            case 6:
                System.out.println("Listar reserva");
                service.listarReserva();
                break;

        }


    }
    public void  menuCLiente(){

        System.out.println("Menu CLiente");
        System.out.println("1.Hacer reserva \n" +
                "2. Cancelar Reserva");

        int opcion = sc.nextInt();

        switch (opcion){

            case 1:
                System.out.println("Para hacer reserva ");
                service.realizarReserva();
                break;

            case 2 :
                System.out.println("Cacelar reserva");
                service.eliminarReserva();
                break;
        }
    }
}
