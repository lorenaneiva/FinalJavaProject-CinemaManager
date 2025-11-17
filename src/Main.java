/*
    Classe principal do sistema de gerenciamento de cinema.
    Responsável por iniciar os serviços e exibir o menu principal.
*/

import  UI.MenuPrincipal;

public class Main {
    public static void main(String[] args){
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();
        System.exit(0);
    }
}