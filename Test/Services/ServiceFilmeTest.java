/*
    Classe principal do sistema de gerenciamento de cinema.
    Responsável por iniciar os serviços e exibir o menu principal.
*/
import Models.Filme;
import Services.FilmeService;

public class ServiceTest {
    public static void main(String[] args){
        FilmeService filmeService = new FilmeService();

        Filme filme = new Filme();
        filme.setTitulo("O Dr. House");
        filme.setGenero("Medicina");
        filme.setClassificacao("+16");
        filme.setDuracao(90);

        filmeService.adicionarFilme(filme);
        
        Filme filme2 = new Filme();
        filme2.setTitulo("Homem aranha");
        filme2.setGenero("Ficcao cientifica");
        filme2.setClassificacao("+14");
        filme2.setDuracao(120);
        // adicionar filme
        filmeService.adicionarFilme(filme2);
            
        System.out.println("----------");

        System.out.println(filmeService.listarFilmes());
        // editar filme
        System.out.println("----------");

        filmeService.editarFilme(1, "TituloTeste", "GeneroTeste", "ClassificaoTeste", 666);

        System.out.println(filmeService.listarFilmes());
        
        // buscarFilmePorId
        System.out.println("----------");
        System.out.println(filmeService.buscarFilmePorId(1));

        // remover filme  
        System.out.println("----------");

        filmeService.removerFilme(1);
        
        System.out.println(filmeService.listarFilmes());

    }
}

