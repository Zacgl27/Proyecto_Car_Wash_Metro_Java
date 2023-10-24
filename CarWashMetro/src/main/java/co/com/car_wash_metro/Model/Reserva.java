package co.com.car_wash_metro.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    protected int id_reserva;
    protected LocalDate fecha;
    protected LocalTime hora;
    protected String estado;

    public Reserva(){

    }

    public Reserva(int id_reserva, LocalDate fecha, LocalTime hora, String estado) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
