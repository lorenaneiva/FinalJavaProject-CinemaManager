/*
    Classe principal do sistema de gerenciamento de cinema.
    Responsável por iniciar os serviços e exibir o menu principal.
*/

import Models.Filme;
import cinema.services.SessaoService;

public class Main {
    public static void main(String[] args){
        Filme obj1 = new Filme("A volta dos que nunca foram", "Terror", "18+", 120);
         SessaoService sessaoService = new SessaoService();

        
        System.out.println(obj1.toString());
    }
    
    public static void exibirMenuPrincipal() {
    
    }
}

