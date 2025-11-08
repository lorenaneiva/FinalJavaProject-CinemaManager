package Services;

import Models.Filme;
import java.util.ArrayList;

public class FilmeService {

    private ArrayList<Filme> filmes;

    private int proximoId = 1;

    public FilmeService() {
        this.filmes = new ArrayList<>(); // [cite: 22]
    }

    //                                              ------IMPORTANTE (DANIEL,LORENA)-----
    // Essa area aqui esta fazendo o: Editar, Remover, Listar e Adicionar.
    // Lorena, se a classe filme não receber o ID no construtor, prfv me avisa para eu e o daniel arrumarmos isso, pq ele esqueceu..

    public void adicionarFilme(Filme filme) {
        // Logica de atribuiçao do ID nova
        filme.setId(this.proximoId++);

        this.filmes.add(filme);
        System.out.println(" Filme '" + filme.getTitulo() + "' adicionado com sucesso bro");
    }

    //Essa parte retorna a lista

    public ArrayList<Filme> listarFilmes() {
        return this.filmes;
    }

    // Essa é a area de BUSCA por ID (Daniel, Lorena)

    public Filme buscarFilmePorId(int id) {
        for (Filme f : filmes) {
            // Esssa é a logica que usei pra procurar por id. [
            // Caso de erros, me avisem pra eu trocar.
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public boolean editarFilme(int id, String novoTitulo, String novoGenero, String novaClassificacao, double novaDuracao) {
        Filme filmeParaEditar = buscarFilmePorId(id);
        // Essa parte aqui EDITA um filme que o usuario buscou por ID (deu varios erros, entao provavelmente talvez ainda de algum...
        // qualquer coisa me avisem prfv. )

        if (filmeParaEditar != null) {
            try {
                filmeParaEditar.setTitulo(novoTitulo);
                filmeParaEditar.setGenero(novoGenero);
                filmeParaEditar.setClassificacao(novaClassificacao);
                filmeParaEditar.setDuracao(novaDuracao);
                return true;
            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao editar filme: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    // Essa area REMOVE o filme da lista usando o ID (Daniel, Lorena)

    public boolean removerFilme(int id) {
        Filme filmeParaRemover = buscarFilmePorId(id);
        if (filmeParaRemover != null) {
            this.filmes.remove(filmeParaRemover);
            return true;
        }
        return false;
    }
}