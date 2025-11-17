package Services;
import  Models.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {
    private List<Reserva> reservas = new ArrayList<>();
    // Adicionar uma reserva
    public void adicionarReserva(Reserva reserva) {
        if (reserva == null || reserva.getSessao() == null || reserva.getAssento() <= 0) {
            throw new IllegalArgumentException("Reserva inválida. Verifique os dados.");
        }
        reservas.add(reserva);
        System.out.println("Reserva adicionada com sucesso!");
    }
    // Listar todas as reservas
    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println("[" + i + "] " + reservas.get(i));
        }
    }
    // Para buscar reserva por ID
    public Reserva buscarReservaPorId(int id) {
    if (id < 0 || id >= reservas.size()) {
        throw new IllegalArgumentException("Reserva com ID " + id + " não encontrada.");
    }
    return reservas.get(id);
    }
    // Editar uma reserva existente
    public void editarReserva(int index, Reserva novaReserva) {
        if (index < 0 || index >= reservas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        if (novaReserva == null || novaReserva.getSessao() == null || novaReserva.getAssento() <= 0) {
            throw new IllegalArgumentException("Nova reserva inválida.");
        }
        reservas.set(index, novaReserva);
        System.out.println("Reserva editada com sucesso!");
    }
    // Remover uma reserva
    public void removerReserva(int index) {
        if (index < 0 || index >= reservas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        reservas.remove(index);
        System.out.println("Reserva removida com sucesso!");
    }
}

