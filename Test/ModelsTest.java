/*
    Classe principal do sistema de gerenciamento de cinema.
    Responsável por iniciar os serviços e exibir o menu principal.
*/

import java.time.LocalDate;
import java.time.LocalTime;

import Models.Filme;
import Models.Sala;
import Models.Sessao;
import Models.Reserva;

public class ModelsTest {
    public static void main(String[] args){
        Filme filme = new Filme();
        filme.setTitulo("O Dr. House");
        filme.setGenero("Medicina");
        filme.setClassificacao("+16");
        filme.setDuracao(90);
        System.out.println(filme.getId() + " " + filme.toString());

        Filme filme2 = new Filme();
        filme2.setTitulo("Homem aranha");
        filme2.setGenero("Ficcao cientifica");
        filme2.setClassificacao("+14");
        filme2.setDuracao(120);
        System.out.println(filme2.getId() + " " + filme2.toString());

        System.out.println("----------");

        Sala sala = new Sala();
        sala.setNome("A10");
        sala.setCapacidade(100);
        System.out.println(sala.toString());
        
        Sala sala2 = new Sala();
        sala2.setNome("B15");
        sala2.setCapacidade(150);
        System.out.println(sala2.toString());

        System.out.println("----------");

        Sessao sessao = new Sessao();
        sessao.setFilme(filme);
        sessao.setSala(sala);
        LocalDate dataSessao = LocalDate.of(2025, 11, 25);
        sessao.setData(dataSessao);
        LocalTime horaSessao = LocalTime.of(12, 40);
        sessao.setHorario(horaSessao);
        sessao.setVagas(sala.getCapacidade());
        System.out.println(sessao.toString());

        Sessao sessao2 = new Sessao();
        sessao2.setFilme(filme2);
        sessao2.setSala(sala2);
        LocalDate dataSessao2 = LocalDate.of(2025, 12, 3);
        sessao2.setData(dataSessao2);
        LocalTime horaSessao2 = LocalTime.of(15, 20);
        sessao2.setHorario(horaSessao2);
        sessao2.setVagas(sala2.getCapacidade());
        System.out.println(sessao2.toString());

        System.out.println("----------");

        Reserva reserva = new Reserva();
        reserva.setSessao(sessao);
        reserva.setAssento(40);
        reserva.setStatusPagamento(true);
        System.out.println(reserva.toString());
        
        Reserva reserva2 = new Reserva();
        reserva2.setSessao(sessao2);
        reserva2.setAssento(21);
        reserva2.setStatusPagamento(false);
        System.out.println(reserva2.toString());

    }
    
    public static void exibirMenuPrincipal() {
    
    }
}

