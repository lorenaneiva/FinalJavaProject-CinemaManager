package Models;

public class Reserva {
    private Sessao sessao;
    private int assento;
    private String statusPagamento;

    public Reserva (Sessao sessao, int assento, String statusPagamento){
        this.sessao = sessao;
        this.assento = assento;
        this.statusPagamento = statusPagamento;
    }

}
