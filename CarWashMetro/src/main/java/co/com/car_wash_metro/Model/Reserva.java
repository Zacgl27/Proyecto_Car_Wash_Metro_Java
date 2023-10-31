package co.com.car_wash_metro.Model;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
    protected int id_reserva;
    protected Date fecha;
    protected Time hora;
    protected String estado;
    protected int id_cliente;
    protected int id_celda;
    public Reserva() {

    }
    public Reserva(int id_reserva, Date fecha, Time hora, String estado) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.id_cliente = id_cliente;
        this.id_celda = id_celda;
    }

    public int getId_reserva() {
        return id_reserva;
    }
    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHora() {
        return this.hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_celda() {
        return id_celda;
    }
    public void setId_celda(int id_celda) {
        this.id_celda = id_celda;
    }
    public int getOpc() {
        return 0;
    }
}
