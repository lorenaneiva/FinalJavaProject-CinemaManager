package Services;

import Models.Sala;
import java.util.ArrayList;

public class SalaService {

    private ArrayList<Sala> salas;

    public SalaService() {
        this.salas = new ArrayList<>();
    }

    public void adicionarSala(Sala sala) {
        this.salas.add(sala);
        System.out.println("Sala adicionada com sucesso.");
    }

    public ArrayList<Sala> listarSalas() {
        return this.salas;
    }

    public Sala buscarSalaPorId(int id) {
        for (Sala s : salas) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean editarSala(int id, String novoNome, int novaCapacidade) {
        Sala salaParaEditar = buscarSalaPorId(id);

        if (salaParaEditar != null) {
            try {
                salaParaEditar.setNome(novoNome);
                salaParaEditar.setCapacidade(novaCapacidade);
                return true;
            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao editar sala: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean removerSala(int id) {
        Sala salaParaRemover = buscarSalaPorId(id);

        if (salaParaRemover != null) {
            this.salas.remove(salaParaRemover);
            return true;
        }
        return false;
    }
}