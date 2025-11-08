package cinema.services;

import cinema.models.Sessao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SessaoService {
    private ArrayList<Sessao> sessoes = new ArrayList<>();

    // para adastrar uma nova sessão
    public void cadastrarSessao(Sessao sessao) {
        sessoes.add(sessao);
        JOptionPane.showMessageDialog(null, "Sessão cadastrada com sucesso!");
    }

    // para listar todas as sessões de scream hehehe
    public void listarSessoes() {
        if (sessoes.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma sessão cadastrada.");
            return;
        }

        String sessoesStr = "";
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao s = sessoes.get(i);
            sessoesStr += (i + 1) + ": Filme: " + s.getFilme().getNomeFilme()
                        + " | Sala: " + s.getSala().getSalaId()
                        + " | Horário: " + s.getHorario() + "\n";
        }

        JOptionPane.showMessageDialog(null, sessoesStr);
    }

    // para editar uma sessão 
    public void editarSessao(int index, Sessao novaSessao) {
        if (index >= 0 && index < sessoes.size()) {
            sessoes.set(index, novaSessao);
            JOptionPane.showMessageDialog(null, "Sessão atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }

    // para remover uma sessão
    public void removerSessao(int index) {
        if (index >= 0 && index < sessoes.size()) {
            sessoes.remove(index);
            JOptionPane.showMessageDialog(null, "Sessão removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }

    // Retornar a lista de sessões 
    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }
}