package UI;

import Services.FilmeService;
import Services.SalaService;
import Services.SessaoService;
import Services.ReservaService;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    private FilmeService filmeService = new FilmeService();
    private SalaService salaService = new SalaService();
    private SessaoService sessaoService = new SessaoService();
    private ReservaService reservaService = new ReservaService();
    public void exibirMenu() {
        String input;
        int opcao = -1;

        FilmeMenu filmeMenu = new FilmeMenu(filmeService);
        SalaMenu salaMenu = new SalaMenu(salaService);
        SessaoMenu sessaoMenu = new SessaoMenu(filmeService, salaService, sessaoService);
        ReservaMenu reservaMenu = new ReservaMenu(reservaService, sessaoService);

        while (opcao != 0) {
            String menu = " Gerenciador de Cinema \n\n";
            menu += "1. Gerenciar Filmes\n";
            menu += "2. Gerenciar Salas\n";
            menu += "3. Gerenciar Sessões\n";
            menu += "4. Gerenciar Reservas\n";
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
                    filmeMenu.exibirMenuPrincipal();
                    break;
                case 2:
                    salaMenu.exibirMenuPrincipal();
                    break;
                case 3:
                    sessaoMenu.exibirMenu();
                case 4:
                    reservaMenu.exibirMenu();
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