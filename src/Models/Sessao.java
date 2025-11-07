package Models;

//implementei o localDate e LocalTime por que percebi que fazer data e dia com condicional é bem difícil com String... e se colocassem 01/10/1200? não teria como dar erro
//Link do vídeo que eu assisti: https://youtu.be/F2bZ1fkAQx0?si=ZWGJIy0SZM1GbGyK
import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao {
    private LocalDate data;
    private LocalTime horario;
    private Filme filme;
    private Sala sala;
    private int vagasDisponiveis;

    public Sessao(LocalDate data, LocalTime horario, Filme filme, Sala sala, int vagasDisponiveis) {
        this.data = data;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        if (data == null){
            throw new IllegalArgumentException("o filme precisa de uma data");
        }
        //código simples para verificar se a data colocada não é uma data anterior a de agora
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("a data precisa ser após a data atual");
        }
        this.data = data;
    }

    public LocalTime getHorario(){
        return horario;
    }

    public void setHorario(LocalTime horario){
        if (horario == null){
            throw new IllegalArgumentException("O horário da sessão precisa ser preenchido");
        }
        this.horario = horario;
    }

    public Filme getFilme(){
        return filme;
    }

    public void setFilme(Filme filme){
        if (filme == null){
            throw new IllegalArgumentException("O filme precisa ser adicionado na sessão");
        }
        this.filme = filme;
    }
    public Sala getSala(){
        return sala;
    }

    public void setSala(Sala sala){
        if (sala == null){
            throw new IllegalArgumentException("uma sala precisa ser escolhida para passar o filme");
        }
        this.sala = sala;
    }
    public int getVagas(){
        return vagasDisponiveis;
    }

    public void setVagas(int vagasDisponiveis){
        if (vagasDisponiveis < 0){
            throw new IllegalArgumentException("uma sessão não pode passar do número de assentos");
        }
        this.sala = sala;
    }

    @Override
    public String toString(){
        return "Data do filme: " + data + " | " + "Horário da Sessão: " + horario + " | " + "Filme: " + filme + " | "+ "Sala: " + sala + " | " + "Vagas Disponiveis: " + vagasDisponiveis;
    }
}
    
