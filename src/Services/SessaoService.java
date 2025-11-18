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


     public static int getContadorSessao() {
        return contadorGlobal;
    }

    //para adicionar uma sessao
    public void adicionarSessao(LocalDate data, LocalTime horario, Filme filme, Sala sala, int vagasDisponiveis) {
    Sessao sessao = new Sessao(data, horario, filme, sala, vagasDisponiveis);
    sessoes.add(sessao);
    System.out.println("Acicionar Sessao com ID " + sessao.getId() );
    }
    
    //para buscar uma Sessao por ID
    public Sessao buscarSessaoPorId(int id) {
    for (Sessao sessao : sessoes) {
        if (sessao.getId() == id) {
            return sessao;
        }
    }
    throw new IllegalArgumentException("Sessão com ID " + id + " não encontrada.");
    }
    //para editar
    public void editarSessao(int id, LocalDate novaData, LocalTime novoHorario, Filme novoFilme, Sala novaSala, int novasVagas) {
    //fazendo a busca da sessao pelo ID
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

            System.out.println("Sessão com ID " + id + " foi atualizada com sucesso.");
            return;
        }
    }
    throw new IllegalArgumentException("Sessão com ID " + id + " não encontrada.");
    }
    //para remover uma sessao
    public void removerSessao(int id) {
    for (Sessao sessao : sessoes) {
        if (sessao.getId() == id) {
            sessoes.remove(sessao);
            System.out.println("Sessão com ID " + id + " removida com sucesso.");
            return;
        }
    }
        throw new IllegalArgumentException("Sessão com ID " + id + " não encontrada.");
    }

}
