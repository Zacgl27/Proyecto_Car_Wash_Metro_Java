package co.com.car_wash_metro.model;

public class Celda {

    protected int id_celda;
    protected String estado;
    protected String tipo;

    public Celda(){

    }

    public Celda(int id_celda, String estado, String tipo) {
        this.id_celda = id_celda;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getId_celda() {
        return id_celda;
    }

    public void setId_celda(int id_celda) {
        this.id_celda = id_celda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
