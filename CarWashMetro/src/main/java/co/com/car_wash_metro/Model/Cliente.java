package co.com.car_wash_metro.Model;

public class Cliente extends Usuario{

    protected int id_cliente;
    protected String matricula;

    public Cliente(){

    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
        this.matricula = matricula;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
