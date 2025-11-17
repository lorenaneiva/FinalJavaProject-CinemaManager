package Services;

import Models.Filme;
import Models.Sessao;

public class SessaoService {

    //para adicionar um filme
//    public void adicionarFilme(Filme filme, Sessao sessao) {
//    if (filme == null) {
//        throw new IllegalArgumentException("O filme não pode ser nulo.");
//    }
//
//    sessao.listarFilmes().add(filme);
//    System.out.println("Filme '" + filme.getTitulo() + "' com ID " + filme.getId() + " adicionado com sucesso.");
//}

    //para buscar um filme por ID
    public void definirFilmePorId(int id, Sessao sessao, FilmeService filmeService) {
        Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
        if (filmeEncontrado != null) {
            sessao.setFilme(filmeEncontrado);
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
        }
    }

    //para editar um filme
    public boolean editarFilme(int id, String novoTitulo, String novoGenero, String novaClassificacao, double novaDuracao, Sessao sessao, FilmeService filmeService) {
        Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
        if (filmeEncontrado != null) {
            filmeEncontrado.setTitulo(novoTitulo);
            filmeEncontrado.setGenero(novoGenero);
            filmeEncontrado.setClassificacao(novaClassificacao);
            filmeEncontrado.setDuracao(novaDuracao);
            System.out.println("Filme com ID " + id + " editado com sucesso.");
            return true;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
        }
    }

    //para remover um filme
//    public boolean removerFilme(int id, Sessao sessao, FilmeService filmeService) {
//        Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
//        if (filmeEncontrado != null) {
//            sessao.listarFilmes().remove(filmeEncontrado);
//            System.out.println("Filme com ID " + id + " removido com sucesso.");
//            return true;
//        } else {
//            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
//        }
//    }
}
