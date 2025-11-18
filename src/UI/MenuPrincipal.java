package UI;

import Services.FilmeService;
import Services.SalaService;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class MenuPrincipal {

    private FilmeService filmeService = new FilmeService();
    private SalaService salaService = new SalaService();

    public void exibirMenu() {
        String input;
        int opcao = -1;

        while (opcao != 0) {
            String menu = "Gerenciador de Cinema \n\n";
            menu += "1. Gerenciar Filmes \n";
            menu += "2. Gerenciar Salas \n";
            menu += "3. Gerenciar Sessões e Reservas\n";
            menu += "0. Sair do Sistema";

            input = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.PLAIN_MESSAGE);

            if (input == null) {
                opcao = 0;
                continue;
            }

            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Acessando Menu Filmes.", "Filmes", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Acessando Menu Salas. ", "Salas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Menu de Sessões/Reservas. ", "Outros", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema. Até mais!", "Sair", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção não reconhecida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}