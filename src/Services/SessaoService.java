package Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Models.Filme;
import Models.Sala;
import Models.Sessao;

public class SessaoService {
    private List<Sessao> sessoes = new ArrayList<>();

    //para adicionar uma sessão
    public void adicionarSessao(LocalDate data, LocalTime horario, Filme filme, Sala sala, int vagasDisponiveis) {
    Sessao sessao = new Sessao(data, horario, filme, sala, vagasDisponiveis);
    sessoes.add(sessao);
    System.out.println("Adicionar Sessao: " + sessao.getId() );
    }
    //para listar sessões
    public void listarSessoes() {
    if (sessoes.isEmpty()) {
        System.out.println("Nenhuma sessão cadastrada.");
        return;
    }

    System.out.println("Lista de Sessões:");
    for (Sessao sessao : sessoes) {
        System.out.println("ID: " + sessao.getId() +
                           " | Data: " + sessao.getData() +
                           " | Horário: " + sessao.getHorario() +
                           " | Filme: " + sessao.getFilme().getTitulo() +
                           " | Sala: " + sessao.getSala().getNome() +
                           " | Vagas: " + sessao.getVagas());
    }
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
    public void editarSessao(int id, LocalDate novaData, LocalTime novoHorario, Filme novoFilme, Sala novaSala, int novasVagas) {
    //fazendo a busca da sessão pelo ID
    for (Sessao sessao : sessoes) {
        if (sessao.getId() == id) {
            // Validações
            if (novaData == null || novoHorario == null || novoFilme == null || novaSala == null) {
                throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
            }
            if (novasVagas <= 0) {
                throw new IllegalArgumentException("O número de vagas deve ser maior que zero.");
            }

            //atualização das alterações
            sessao.setData(novaData);
            sessao.setHorario(novoHorario);
            sessao.setFilme(novoFilme);
            sessao.setSala(novaSala);
            sessao.setVagas(novasVagas);

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
