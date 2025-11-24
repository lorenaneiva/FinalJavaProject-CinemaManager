package UI;

import javax.swing.JOptionPane;
import Models.Reserva;
import Models.Sessao;
import Services.ReservaService;
import Services.SessaoService;

import java.util.List;

public class ReservaMenu {
    private ReservaService reservaService;
    private SessaoService sessaoService;

    public ReservaMenu(ReservaService reservaService, SessaoService sessaoService) {
        this.reservaService = reservaService;
        this.sessaoService = sessaoService;
    }

    public void exibirMenu() {
        int selecao = -1; // inicialização obrigatória

        do {
            String input = JOptionPane.showInputDialog(
                "=== Menu de Reservas ===\n\n" +
                "Selecione uma das opções abaixo:\n\n" +
                "1 - Adicionar Reserva\n" +
                "2 - Listar Reservas\n" +
                "3 - Editar Reserva\n" +
                "4 - Buscar Reserva por ID\n" +
                "5 - Remover Reserva\n" +
                "0 - Voltar ao Menu Principal"
            );

            if (input == null) return;


            try {
                selecao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma opção válida.");

                continue;
            }
            switch (selecao) {
                case 1:
                    adicionarReserva();
                    break;
                case 2:
                    listarReservas();
                    break;
                case 3:
                    editarReserva();
                    break;
                case 4:
                    removerReserva();
                    break;
                case 0:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (selecao != 0);
    }

    private void adicionarReserva() {
        try {
            int idSessao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da sessão:"));
            int assento = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do assento:"));

            int pagamentoOpcao = JOptionPane.showConfirmDialog(null, "Pagamento realizado?", "Status de Pagamento", JOptionPane.YES_NO_OPTION);
            boolean statusPagamento = (pagamentoOpcao == JOptionPane.YES_OPTION);

            Sessao sessao = sessaoService.buscarSessaoPorId(idSessao);

            reservaService.adicionarReserva(sessao, assento, statusPagamento);

            JOptionPane.showMessageDialog(null, "Reserva adicionada com sucesso!\nVagas restantes: " + sessao.getVagas());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar reserva: ");
        }
    }

    private void listarReservas() {
        try {
            List<Reserva> reservas = reservaService.getTodasReservas();

            if (reservas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma reserva encontrada.");
                return;
            }

            StringBuilder sb = new StringBuilder("Lista de Reservas:\n");
            for (Reserva reserva : reservas) {
                sb.append("ID: ").append(reserva.getId())
                  .append(" | Sessão ID: ").append(reserva.getSessao().getId())
                  .append(" | Assento: ").append(reserva.getAssento())
                  .append(" | Pagamento: ").append(reserva.isStatusPagamento() ? "Sim" : "Não")
                  .append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar reservas: ");
        }
    }

    private void editarReserva() {
        try {
            int idReserva = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da reserva que deseja editar:"));
            int novoAssento = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo número de assento:"));
            int idSessao = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ID da sessão:"));

            Sessao novaSessao = sessaoService.buscarSessaoPorId(idSessao);

            reservaService.editarReserva(idReserva, novaSessao, novoAssento);

            JOptionPane.showMessageDialog(null, "Reserva atualizada com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar reserva: " );
        }
    }

    private void removerReserva() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da reserva que deseja remover:"));
            reservaService.removerReservaPorId(id);
            JOptionPane.showMessageDialog(null, "Reserva removida com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover reserva: ");
        }
    }
}