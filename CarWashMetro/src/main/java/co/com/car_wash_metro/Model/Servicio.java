package co.com.car_wash_metro.Model;

public class Servicio {

    protected int id_servicio;
    protected String nombre_servicio;
    protected double valor_servicio;

    public Servicio(){

    }

    public Servicio(int id_servicio, String nombre_servicio, double valor_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.valor_servicio = valor_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public double getValor_servicio() {
        return valor_servicio;
    }

    public void setValor_servicio(double valor_servicio) {
        this.valor_servicio = valor_servicio;
    }
}
