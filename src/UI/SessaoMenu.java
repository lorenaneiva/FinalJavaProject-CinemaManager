package UI;
import java.util.List;
import Models.Filme;
import Models.Sala;
import Models.Sessao;
import Services.FilmeService;
import Services.SalaService;
import Services.SessaoService;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SessaoMenu {

    private FilmeService filmeService;
    private SalaService salaService;
    private SessaoService sessaoService;

    public SessaoMenu(FilmeService filmeService, SalaService salaService, SessaoService sessaoService) {
        this.filmeService = filmeService;
        this.salaService = salaService;
        this.sessaoService = sessaoService;
    }

    public void exibirMenu() {
        while (true) {
            String opcao = JOptionPane.showInputDialog(
                "=== Menu das Sessões ===\n\n" +
                "Selecione uma das opções abaixo:\n\n" +
                "1 - Criar sessão\n" +
                "2 - Listar sessões\n" +
                "3 - Editar sessão\n" +
                "4 - Remover sessões\n" +
                "0 - Voltar ao Menu Principal"
            );

            if (opcao == null) return;

            switch (opcao) {
                case "1":
                    criarSessao();
                    break;
                case "2":
                    listarSessoes();
                    break;
                case "3":
                    editarSessao();
                    break;
                case "4":
                    removerSessao();
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
            }
        }
    }

    private void criarSessao() {
        try {
            //Tava dando erro na parte de aceitar datas, tive que especificar formato
            String dataStr = JOptionPane.showInputDialog("Digite a data da sessão (dd/MM/yyyy):");
            DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, fmtData);

            String horarioStr = JOptionPane.showInputDialog("Digite o horário da sessão (HH:mm):");
            DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horario = LocalTime.parse(horarioStr, fmtHora);
            JOptionPane.showMessageDialog(null,"Visualize os filmes disponiveis para a sessão e selecione um.");
            Filme filme = selecionarFilme();
            if (filme == null) return;
            JOptionPane.showMessageDialog(null,"Visualize as salas disponiveis para a sessão e selecione uma.");
            Sala sala = selecionarSala();
            if (sala == null) return;
            int vagas = sala.getCapacidade();

            Sessao novaSessao = new Sessao(data, horario, filme, sala, vagas);
            sessaoService.adicionarSessao(novaSessao);

            JOptionPane.showMessageDialog(null, "Sessão criada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar sessão: " + e.getMessage());
        }
    }

    private void listarSessoes() {
        List<Sessao> sessoes = sessaoService.getTodasSessoes();

        if (sessoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sessão cadastrada!");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de Sessões:\n");

        for (Sessao sessao : sessoes) {
            sb.append("ID ").append(sessao.getId()).append(" | Data: ").append(sessao.getData()).append(" | Horário: ").append(sessao.getHorario()).append(" | Filme: ").append(sessao.getFilme().getTitulo()).append(" | Sala: ").append(sessao.getSala().getNome()).append(" | Vagas: ").append(sessao.getVagas()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void editarSessao() {
        Sessao sessao = selecionarSessao();
        if (sessao == null) return;

        String opcao = JOptionPane.showInputDialog(
            "Editar Sessões\n" +
            "1 - Alterar Data\n" +
            "2 - Alterar Horário\n" +
            "3 - Alterar Filme\n" +
            "4 - Alterar Sala\n" +
            "Escolha:"
        );

        try {
            switch (opcao) {
                case "1":
                    DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate novaData = LocalDate.parse(
                        JOptionPane.showInputDialog("Nova data (dd/MM/yyyy):"),
                        fmtData
                    );
                    sessao.setData(novaData);
                    break;

                case "2":
                    DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime novoHorario = LocalTime.parse(
                        JOptionPane.showInputDialog("Novo horário (HH:mm):"),
                        fmtHora
                    );
                    sessao.setHorario(novoHorario);
                    break;

                case "3":
                    Filme novoFilme = selecionarFilme();
                    if (novoFilme != null) sessao.setFilme(novoFilme);
                    break;

                case "4":
                    Sala novaSala = selecionarSala();
                    if (novaSala != null) {
                        sessao.setSala(novaSala);
                        sessao.setVagas(novaSala.getCapacidade());
                    }
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null, "Voltando para o menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
            }

            JOptionPane.showMessageDialog(null, "Sessão editada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar sessão: " + e.getMessage());
        }
    }

    private void removerSessao() {
        Sessao sessao = selecionarSessao();
        if (sessao == null) return;

        sessaoService.removerSessao(sessao.getId());
        JOptionPane.showMessageDialog(null, "Sessão removida com sucesso!");
    }

    private Sessao selecionarSessao() {
        List<Sessao> sessoes = sessaoService.getTodasSessoes();
        if (sessoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sessão cadastrada!");
            return null;
        }

        listarSessoes();

        try {
            int id = Integer.parseInt(
                JOptionPane.showInputDialog("Digite o ID da sessão:")
            );

            for (Sessao s : sessoes) {
                if (s.getId() == id) return s;
            }

            JOptionPane.showMessageDialog(null, "Sessão não encontrada!");
            return null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
            return null;
        }
    }

    private Filme selecionarFilme() {
        ArrayList<Filme> filmes = filmeService.listarFilmes();

        if (filmes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado!");
            return null;
        }

        StringBuilder sb = new StringBuilder("Lista de filmes:\n");
        for (Filme f : filmes) {
            sb.append("ID ").append(f.getId()).append(" -> ").append(f).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());

        try {
            int id = Integer.parseInt(
                JOptionPane.showInputDialog("Digite o ID do filme:")
            );

            Filme filme = filmeService.buscarFilmePorId(id);

            if (filme == null) {
                JOptionPane.showMessageDialog(null, "Filme não encontrado!");
                return null;
            }

            return filme;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
            return null;
        }
    }

    private Sala selecionarSala() {
        ArrayList<Sala> salas = salaService.listarSalas();

        if (salas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sala cadastrada!");
            return null;
        }

        StringBuilder sb = new StringBuilder("Lista de salas:\n");
        for (Sala s : salas) {
            sb.append("ID ").append(s.getId()).append(" -> ").append(s).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());

        try {
            int id = Integer.parseInt(
                JOptionPane.showInputDialog("Digite o ID da sala:")
            );

            Sala sala = salaService.buscarSalaPorId(id);

            if (sala == null) {
                JOptionPane.showMessageDialog(null, "Sala não encontrada!");
                return null;
            }

            return sala;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
            return null;
        }
    }
}
