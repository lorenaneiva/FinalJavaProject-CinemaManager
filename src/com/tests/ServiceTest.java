package com.tests;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Models.Filme;
import Models.Sala;
import Models.Sessao;
import Models.Reserva;
import Services.FilmeService;
import Services.SalaService;
import Services.SessaoService;
import Services.ReservaService;

public class ServiceTest {
    public static void main(String[] args){
        FilmeService filmeService = new FilmeService();

        Filme filme = new Filme();
        filme.setTitulo("O Dr. House");
        filme.setGenero("Medicina");
        filme.setClassificacao("+16");
        filme.setDuracao(90);

        filmeService.adicionarFilme(filme);
        
        Filme filme2 = new Filme();
        filme2.setTitulo("Homem aranha");
        filme2.setGenero("Ficcao cientifica");
        filme2.setClassificacao("+14");
        filme2.setDuracao(120);
        // adicionar filme
        filmeService.adicionarFilme(filme2);
            
        System.out.println("----------");

        System.out.println(filmeService.listarFilmes());
        // editar filme
        System.out.println("----------");

        filmeService.editarFilme(1, "TituloTeste", "GeneroTeste", "ClassificaoTeste", 666);

        System.out.println(filmeService.listarFilmes());
        
        // buscarFilmePorId
        System.out.println("----------");
        System.out.println(filmeService.buscarFilmePorId(1));

        // remover filme  
        System.out.println("----------");

        filmeService.removerFilme(1);
        
        System.out.println(filmeService.listarFilmes());
        System.out.println("----------");
        // SALAS
        System.out.println("############################ SALAS ############################");

        Sala sala = new Sala("A12", 100);
        Sala sala2 = new Sala("C13", 100);
        SalaService salas = new SalaService();
        System.out.println("----------");
        salas.adicionarSala(sala);
        System.out.println("----------");
        salas.adicionarSala(sala2);
        System.out.println("----------");
        System.out.println(salas.listarSalas());
        System.out.println("----------");
        salas.removerSala(2);
        System.out.println(salas.listarSalas());
        System.out.println("----------");


        System.out.println("############################ SESSOES ############################");

        LocalDate data = LocalDate.of(2025,12,17);
        LocalTime time = LocalTime.of(20,20);

        Sessao sessao = new Sessao(data, time, filme2, sala, 100);
        SessaoService sessoes = new SessaoService();
        sessoes.adicionarSessao(sessao);
        System.out.println("----------");
        //sessoes.listarSessoes();
        System.out.println("----------");

        System.out.println("############################ RESERVAS ############################");
        ReservaService reservaService = new ReservaService();
        List<Reserva> reservas = reservaService.getTodasReservas();

        reservaService.adicionarReserva(sessao, 20, true);
        reservaService.adicionarReserva(sessao, 10, true);
        reservaService.adicionarReserva(sessao, 10, true);
        reservaService.adicionarReserva(sessao, 10, true);
        reservaService.adicionarReserva(sessao, 10, true);
        reservaService.listarReservas();
        for(Reserva reserva : reservas){
            System.out.println(reserva.getSessao().getVagas());
        }
        
        
    }
}

