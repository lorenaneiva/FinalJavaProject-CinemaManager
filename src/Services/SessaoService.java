package Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Models.Filme;
import Models.Sala;
import Models.Sessao;

public class SessaoService {
    private List<Sessao> sessoes = new ArrayList<>();

    public List<Sessao> getTodasSessoes() {
        return sessoes;
    }

    //para adicionar uma sessão
    public void adicionarSessao(Sessao sessao) {
        Sessao NewSessao = sessao;
        sessoes.add(NewSessao);
        System.out.println("Sessao adicionada com sucesso.");
    }

    //para listar sessões
    public void listarSessoes() {
        if (this.sessoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sessão cadastrada!");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de Sessões:\n");

        for (Sessao sessao : this.sessoes) {
            sb.append("ID ").append(sessao.getId()).append(" | Data: ").append(sessao.getData()).append(" | Horário: ").append(sessao.getHorario()).append(" | Filme: ").append(sessao.getFilme().getTitulo()).append(" | Sala: ").append(sessao.getSala().getNome()).append(" | Vagas: ").append(sessao.getVagas()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
        }
    //para buscar uma Sessão por ID
    public Sessao buscarSessaoPorId(int id) {
        for (Sessao sessao : sessoes) {
            if (sessao.getId() == id) {
                return sessao;
            }
        }
        throw new IllegalArgumentException("Sessão: " + id + " não encontrada.");
    }
    //para editar
    public void editarSessao(int id, LocalDate novaData, LocalTime novoHorario, Filme novoFilme, Sala novaSala) {
        //fazendo a busca da sessão pelo ID
        for (Sessao sessao : sessoes) {
            if (sessao.getId() == id) {
                // Validações
                if (novaData == null || novoHorario == null || novoFilme == null || novaSala == null) {
                    throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
                }

                //atualização das alterações
                sessao.setData(novaData);
                sessao.setHorario(novoHorario);
                sessao.setFilme(novoFilme);
                sessao.setSala(novaSala);

                System.out.println("Sessão: " + id + " foi atualizada com sucesso.");
                return;
            }
        }
        throw new IllegalArgumentException("Sessão: " + id + " não encontrada.");
    }
    //para remover uma sessão
    public void removerSessao(int id) {
        for (Sessao sessao : sessoes) {
            if (sessao.getId() == id) {
                sessoes.remove(sessao);
                System.out.println("Sessão: " + id + " removida com sucesso.");
                return;
            }
        }
        throw new IllegalArgumentException("Sessão: " + id + " não encontrada.");
    }

}
