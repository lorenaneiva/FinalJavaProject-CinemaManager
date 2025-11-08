package Models;

public class Reserva {
    private Sessao sessao;
    private int assento;
    private boolean statusPagamento;

    public Reserva (Sessao sessao, int assento, boolean statusPagamento){
        this.sessao = sessao;
        this.assento = assento;
        this.statusPagamento = statusPagamento;
    }

    public Sessao getSessao(){
        return sessao;
    }

    public void setSessao(Sessao sessao){
        if (sessao == null ){
            throw new IllegalArgumentException("Precisa adicionar uma sessao para fazer reserva");
        }
        this.sessao = sessao;
    }

    public int getAssento(){
        return assento;
    }

    public void setAssento(int assento){
        if (assento == 0 ){
            throw new IllegalArgumentException("Precisa colocar uma assento para assistir o filme");
        }
        this.assento = assento;
    }

    public boolean isStatusPagamento(){
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento){
        this.statusPagamento = statusPagamento;
    }

    public void verificarStatusPagamento() {
        if (statusPagamento) {
            System.out.println("Pagamento confirmado");
        } else {
            System.out.println("Aguardando pagamento");
        }
    }

    public void confirmarPagamento() {
        this.statusPagamento = true;
        System.out.println("Pagamento confirmado do assento: " + getAssento());
    }

    @Override
    public String toString() {
        String status = statusPagamento ? "Pago" : "Pendente";
        return "Resumo da reserva: "+ " | " + "Filme: " + sessao.getFilme().getTitulo()  + " |" + "Data da Sessao: " + sessao.getData() + " | " + "Horario da Sessao: " + sessao.getHorario() + " | " + "Sala: " +  sessao.getSala().getNome() +" | " + "Assento: " +  assento + " | " + "Status: " +  status;
    }
    
}