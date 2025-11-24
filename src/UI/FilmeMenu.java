package UI;

import javax.swing.JOptionPane;
import Models.Filme;
import Services.FilmeService;
import java.util.ArrayList;

public class FilmeMenu {

    private FilmeService filmeService;

    public FilmeMenu(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void exibirMenuPrincipal() {
        String opcao;

        do {
            opcao = JOptionPane.showInputDialog(
                "=== Menu de filmes ===\n\n" +
                "Selecione uma das opções abaixo:\n\n" +
                "1 - Cadastrar filme\n" +
                "2 - Listar filmes\n" +
                "3 - Editar filme\n" +
                "4 - Remover filme\n" +
                "0 - Voltar"
            );

            if (opcao == null) {
                break;
            }

            switch (opcao) {
                case "1":
                    cadastrarFilme();
                    break;
                case "2":
                    listarFilmes();
                    break;
                case "3":
                    editarFilme();
                    break;
                case "4":
                    removerFilme();
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
            }
        } while (!"0".equals(opcao));
    }

    private void cadastrarFilme() {
        try {
            String titulo = JOptionPane.showInputDialog("Título do filme:");
            if (titulo == null || titulo.trim().isEmpty()) //para saber se o que o usuario escreveu esta vazio.]
            {
                JOptionPane.showMessageDialog(null, "Cadastro cancelado ou título vazio.");
                return;
            }

            String genero = JOptionPane.showInputDialog("Gênero:");
            String classificacao = JOptionPane.showInputDialog("Classificação indicativa:");
            String duracaoStr = JOptionPane.showInputDialog("Duração (em minutos):");

            if (duracaoStr == null) {
                JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
                return;
            }

            double duracao = Double.parseDouble(duracaoStr); //aqui ele converte o texto do usuario pra double

            Filme filme = new Filme();
            filme.setTitulo(titulo);
            filme.setGenero(genero);
            filme.setClassificacao(classificacao);
            filme.setDuracao(duracao);

            filmeService.adicionarFilme(filme);

            JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar filme: " + e.getMessage());
        }
        ////tratamento de erro e mostra o erro que deu
    }

    private void listarFilmes() {
        ArrayList<Filme> filmes = filmeService.listarFilmes();
        if (filmes == null || filmes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado.");
            return;
        }
        //montando a lista fromatada
        StringBuilder lista = new StringBuilder("Lista de filmes:\n\n");
        for (Filme f : filmes) {
            lista.append("ID: ").append(f.getId())
                .append(" | ").append(f.getTitulo())
                .append(" | Gênero: ").append(f.getGenero())
                .append(" | Classificação: ").append(f.getClassificacao())
                .append(" | Duração: ").append(f.getDuracao()).append(" min\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private void editarFilme() {
        try {
            //exibição da lista
            listarFilmes();

            String idStr = JOptionPane.showInputDialog("Digite o ID do filme que deseja editar:");
            if (idStr == null) return;

            int id = Integer.parseInt(idStr);
            //aqui ele transforma o texto em numero int
            Filme filme = filmeService.buscarFilmePorId(id);

            if (filme == null) {
                JOptionPane.showMessageDialog(null, "Filme não encontrado!");
                return;
            }

            String novoTitulo = JOptionPane.showInputDialog("Novo título:", filme.getTitulo());
            String novoGenero = JOptionPane.showInputDialog("Novo gênero:", filme.getGenero());
            String novaClassificacao = JOptionPane.showInputDialog("Nova classificação:", filme.getClassificacao());
            String durStr = JOptionPane.showInputDialog("Nova minutagem:", String.valueOf(filme.getDuracao()));

            if (durStr == null) return;

            double novaDuracao = Double.parseDouble(durStr);

            boolean sucesso = filmeService.editarFilme(id, novoTitulo, novoGenero, novaClassificacao, novaDuracao);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar filme!");
            }
        //usuario colocou outra coisa alem de numeros
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID ou duração inválida. Use apenas números.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar: " + e.getMessage());
        }
    }

    private void removerFilme() {
        try {
            listarFilmes();

            String idStr = JOptionPane.showInputDialog("Digite o ID do filme que deseja remover:");
            if (idStr == null) return;

            int id = Integer.parseInt(idStr);
            boolean removido = filmeService.removerFilme(id);

            if (removido) {
                JOptionPane.showMessageDialog(null, "Filme removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Filme não encontrado!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Use apenas números.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }
}
