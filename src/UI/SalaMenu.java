package UI;

import javax.swing.JOptionPane;
import Models.Sala;
import Services.SalaService;

public class SalaMenu {

    private SalaService salaService;

    public SalaMenu(SalaService salaService) {
        this.salaService = salaService;
    }

    public void exibirMenuPrincipal() {

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "=== Menu de Salas ===\n\n" +
                    "Selecione uma das opções abaixo:\n\n" +
                    "1 - Cadastrar Salas\n" +
                    "2 - Listar Salas\n" +
                    "3 - Editar Salas\n" +
                    "4 - Remover Sala\n" +
                    "0 - Voltar\n\n" +
                    "Escolha uma opção: "
            );

            if (opcao == null) return; 

            switch (opcao) {
                case "1":
                    cadastrarSala();
                    break;

                case "2":
                    listarSalas();
                    break;

                case "3":
                    editarSala();
                    break;

                case "4":
                    removerSala();
                    break;

                case "0":
                    return; 

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }


    private void cadastrarSala() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome da sala:");
            if (nome == null) return;

            String capStr = JOptionPane.showInputDialog("Digite a capacidade:");
            if (capStr == null) return;

            int capacidade = Integer.parseInt(capStr);

            Sala sala = new Sala(nome, capacidade);
            salaService.adicionarSala(sala);

            JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a sala: " + e.getMessage());
        }
    }

    private void listarSalas() {
        var salas = salaService.listarSalas();

        if (salas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sala cadastrada.");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de Salas: \n\n");

        for (Sala s : salas) {
            sb.append("ID: ").append(s.getId())
                    .append(" | ").append(s.toString())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }


    private void editarSala() {
        listarSalas();
        String idStr = JOptionPane.showInputDialog("Digite o ID da sala que quer editar: ");
        if (idStr == null) return;

        int id = Integer.parseInt(idStr);

        Sala sala = salaService.buscarSalaPorId(id);

        if (sala == null) {
            JOptionPane.showMessageDialog(null, "Sala não encontrada!");
            return;
        }

        String novoNome = JOptionPane.showInputDialog("Novo nome:", sala.getNome());
        if (novoNome == null) return;

        String novaCapStr = JOptionPane.showInputDialog("Nova capacidade:", sala.getCapacidade());
        if (novaCapStr == null) return;

        int novaCapacidade = Integer.parseInt(novaCapStr);

        boolean sucesso = salaService.editarSala(id, novoNome, novaCapacidade);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Sala editada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar sala!");
        }
    } 

    private void removerSala() {

        String idStr = JOptionPane.showInputDialog("Digite o ID da sala que quer remover, por favor: ");
        if (idStr == null) return;

        int id = Integer.parseInt(idStr);

        boolean removida = salaService.removerSala(id);

        if (removida) {
            JOptionPane.showMessageDialog(null, "Sala removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Sala não encontrada!");
        }
    }
}