package Services;
import  Models.Reserva;
import Models.Sessao;

import java.util.ArrayList;
import java.util.List;

public class ReservaService {
    
    private List<Reserva> reservas = new ArrayList<>();
    public List<Reserva> getTodasReservas() {
        return reservas;
    }
    //para adicionar reserva
    public void adicionarReserva(Sessao sessao, int assento, boolean statusPagamento) {
        // Validações
        if (sessao == null) {
            throw new IllegalArgumentException("Precisa adicionar uma sessão para fazer a reserva.");
        }
        if (assento <= 0) {
            throw new IllegalArgumentException("Precisa colocar um número de assento válido.");
        }
        // Criação da reserva
        Reserva reserva = new Reserva(sessao, assento, statusPagamento);
        // Reduz vagas disponíveis
        int vagasAtuais = sessao.getVagas();
        if (vagasAtuais <= 0) {
            throw new IllegalStateException("Não há vagas disponíveis para essa sessão.");
        }
        sessao.setVagas(vagasAtuais - 1);

        // Adiciona à lista
        reservas.add(reserva);

        System.out.println("Reserva adicionada com sucesso para o assento " + assento + " na sessão: " + sessao.getId());
    }
    // Listar todas as reservas
    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Sessão ID: " + reserva.getSessao().getId() +
                            " | Assento: " + reserva.getAssento() +
                            " | Pagamento: " + (reserva.isStatusPagamento()));
        }
    }
    //para editar reservas
    public void editarReserva(int idReserva, Sessao novaSessao, int novoAssento) {
    Reserva reserva = buscarReservaPorId(idReserva);

    // Validações
    if (novaSessao == null) {
        throw new IllegalArgumentException("Sessão não pode ser nula.");
    }

    if (novoAssento <= 0) {
        throw new IllegalArgumentException("Número de assento inválido.");
    }

    // Atualizações
    reserva.setSessao(novaSessao);
    reserva.setAssento(novoAssento);

    System.out.println("Reserva: " + idReserva + " atualizada com sucesso.");
}
    public Reserva buscarReservaPorId(int id) {
    for (Reserva reserva : reservas) {
        if (reserva.getId() == id) {
            return reserva;
        }
    }
    throw new IllegalArgumentException("Reserva: " + id + " não encontrada.");
    }
    public void removerReservaPorId(int id) {
    // Verificação de ID 
    if (id <= 0) {
        throw new IllegalArgumentException("O ID da reserva deve ser maior que zero.");
    }
    // Busca e remoção
    Reserva reservaParaRemover = null;
    for (Reserva reserva : reservas) {
        if (reserva.getId() == id) {
            reservaParaRemover = reserva;
            break;
        }
    }
    if (reservaParaRemover != null) {
        reservas.remove(reservaParaRemover);
        System.out.println("Reserva com ID " + id + " removida com sucesso.");
    } else {
        throw new IllegalArgumentException("Reserva com ID " + id + " não encontrada.");
    }
    }
}

