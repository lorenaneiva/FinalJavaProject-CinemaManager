package cinema.services;

import cinema.models.Filme;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FilmeService {
    private ArrayList<Filme> filmes = new ArrayList<>();

    // Criar filme
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
    }

    // Listar filmes
    public String listarFilmes() {
        if (filmes.isEmpty()) {
            return "Nenhum filme cadastrado.";
        }
        StringBuilder sb = new StringBuilder("📽️ Filmes cadastrados:\n\n");
        for (int i = 0; i < filmes.size(); i++) {
            sb.append(i + 1).append(") ").append(filmes.get(i)).append("\n");
        }
        return sb.toString();
    }

    // Editar filme
    public void editarFilme(int index, Filme novoFilme) {
        if (index >= 0 && index < filmes.size()) {
            filmes.set(index, novoFilme);
            JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido!");
        }
    }

    // Remover filme
    public void removerFilme(int index) {
        if (index >= 0 && index < filmes.size()) {
            filmes.remove(index);
            JOptionPane.showMessageDialog(null, "Filme removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido!");
        }
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }
}
