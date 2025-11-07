package Models;

public class Assento {
    private String numero;
    private boolean ocupado;

    public Assento(String numero) {
        this.numero = numero;
        this.ocupado = false;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Numero do assento não pode ser vazio");
        }
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void reservar() {
        if (this.ocupado) {
            throw new IllegalStateException("Assento " + numero + " já tá ocupado");
        }
        this.ocupado = true;
    }

    public void liberar() {
        this.ocupado = false;
    }
    //verificação do status do assento
    @Override
    public String toString() {
        String status = ocupado ? " Ocupado" : " Livre";
        return "Assento " + numero + status;
    }
}