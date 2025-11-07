package Models;

public class Reserva {
    private Sessao sessao;
    //adicionei o atributo Assento pois era não faz muito sentido um assento ser apenas um número sem verificação de ocupação
    private Assento assento;
    private boolean statusPagamento;

    public Reserva (Sessao sessao, Assento assento, boolean statusPagamento){
        this.sessao = sessao;
        this.assento = assento;
        this.statusPagamento = statusPagamento;
    }

    public Sessao getSessao(){
        return sessao;
    }

    public void setSessao(Sessao sessao){
        if (sessao == null ){
            throw new IllegalArgumentException("Precisa adicionar uma sessão para fazer reserva");
        }
        this.sessao = sessao;
    }

    public Assento getAssento(){
        return assento;
    }

    public void setAssento(Assento assento){
        if (assento == null){
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
        System.out.println("Pagamento confirmado do assento: " + assento.getNumero());
    }

    @Override
    public String toString() {
        String status = statusPagamento ? "Pago" : "Pendente";
        return "Resumo da reserva: "+ " | " + "Filme: " + sessao.getFilme().getTitulo()  + " |" + "Data da Sessão: " + sessao.getData() + " | " + "Horário da Sessão: " + sessao.getHorario() + " | " + "Sala: " +  sessao.getSala().getNome() +" | " + "Assento: " +  assento.getNumero() + " | " + "Status: " +  status;


    }
    
}
