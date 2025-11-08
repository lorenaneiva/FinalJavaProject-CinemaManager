package Models;

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
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("a data precisa ser apos a data atual");
        }
        this.data = data;
    }

    public LocalTime getHorario(){
        return horario;
    }

    public void setHorario(LocalTime horario){
        if (horario == null){
            throw new IllegalArgumentException("O horario da sessao precisa ser preenchido");
        }
        this.horario = horario;
    }

    public Filme getFilme(){
        return filme;
    }

    public void setFilme(Filme filme){
        if (filme == null){
            throw new IllegalArgumentException("O filme precisa ser adicionado na sessao");
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
            throw new IllegalArgumentException("uma sessao nao pode passar do numero de assentos");
        }
        this.vagasDisponiveis = vagasDisponiveis;
    }

    @Override
    public String toString(){
        return "Data do filme: " + data + " | " + "Horario da Sessao: " + horario + " | " + "Filme: " + filme + " | "+ "Sala: " + sala + " | " + "Vagas Disponiveis: " + vagasDisponiveis;
    }
}