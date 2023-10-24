package co.com.car_wash_metro.Model;

public class Administrador extends Usuario {

    protected int id_admin;

    public Administrador(){

    }

    public Administrador(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
}
