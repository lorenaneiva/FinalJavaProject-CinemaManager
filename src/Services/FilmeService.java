package Services;

import Models.Filme;
import java.util.ArrayList;

public class FilmeService {

    private ArrayList<Filme> filmes;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        this.filmes.add(filme);
        System.out.println(" Filme '" + filme.getTitulo() + "' adicionado com sucesso");
    }

    public ArrayList<Filme> listarFilmes() {
        return this.filmes;
    }

    public Filme buscarFilmePorId(int id) {
        for (Filme f : filmes) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public boolean editarFilme(int id, String novoTitulo, String novoGenero, String novaClassificacao, double novaDuracao) {
        Filme filmeParaEditar = buscarFilmePorId(id);
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

    public boolean removerFilme(int id) {
        Filme filmeParaRemover = buscarFilmePorId(id);
        if (filmeParaRemover != null) {
            this.filmes.remove(filmeParaRemover);
            return true;
        }
        return false;
    }
}