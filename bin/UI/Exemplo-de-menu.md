package cinema.ui;

import cinema.models.Filme;
import cinema.services.FilmeService;
import javax.swing.JOptionPane;

public class FilmeMenu {
    private FilmeService filmeService;

    public FilmeMenu(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void exibirMenu() {
        String opcao;
        do {
            opcao = JOptionPane.showInputDialog(
                "🎬 MENU DE FILMES 🎬\n\n" +
                "1 - Cadastrar filme\n" +
                "2 - Listar filmes\n" +
                "3 - Editar filme\n" +
                "4 - Remover filme\n" +
                "0 - Voltar\n\n" +
                "Escolha uma opção:"
            );

            if (opcao == null) break; // caso o usuário cancele

            switch (opcao) {
                case "1":
                    cadastrarFilme();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, filmeService.listarFilmes());
                    break;
                case "3":
                    editarFilme();
                    break;
                case "4":
                    removerFilme();
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (!"0".equals(opcao));
    }

    private void cadastrarFilme() {
        try {
            String titulo = JOptionPane.showInputDialog("Título do filme:");
            String genero = JOptionPane.showInputDialog("Gênero:");
            String classificacao = JOptionPane.showInputDialog("Classificação indicativa:");
            int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração (em minutos):"));

            Filme filme = new Filme(titulo, genero, classificacao, duracao);
            filmeService.adicionarFilme(filme);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar filme: " + e.getMessage());
        }
    }

    private void editarFilme() {
        try {
            String lista = filmeService.listarFilmes();
            if (lista.contains("Nenhum")) {
                JOptionPane.showMessageDialog(null, lista);
                return;
            }

            int index = Integer.parseInt(JOptionPane.showInputDialog(lista + "\nDigite o número do filme a editar:")) - 1;

            String novoTitulo = JOptionPane.showInputDialog("Novo título:");
            String novoGenero = JOptionPane.showInputDialog("Novo gênero:");
            String novaClassificacao = JOptionPane.showInputDialog("Nova classificação:");
            int novaDuracao = Integer.parseInt(JOptionPane.showInputDialog("Nova duração (min):"));

            Filme novoFilme = new Filme(novoTitulo, novoGenero, novaClassificacao, novaDuracao);
            filmeService.editarFilme(index, novoFilme);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar filme: " + e.getMessage());
        }
    }

    private void removerFilme() {
        try {
            String lista = filmeService.listarFilmes();
            if (lista.contains("Nenhum")) {
                JOptionPane.showMessageDialog(null, lista);
                return;
            }

            int index = Integer.parseInt(JOptionPane.showInputDialog(lista + "\nDigite o número do filme a remover:")) - 1;
            filmeService.removerFilme(index);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover filme: " + e.getMessage());
        }
    }
}
