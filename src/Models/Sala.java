package Models;

public class Sala {

    private static int contadorGlobal = 0;

    private int id;
    private String nome;
    private int capacidade;

    public Sala(){
        this.id = ++contadorGlobal;
    }

    public Sala(String nome,int capacidade){
        this.id = ++contadorGlobal;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if (nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("A aba de nome nao pode estar vazia!");
        }
        this.nome = nome;
    }
    
    public int getCapacidade(){
        return capacidade;
    }

    public void setCapacidade(int capacidade){
        if (capacidade == 0){
            throw new IllegalArgumentException("A aba de capacidade nao pode estar vazia!");
        }
        if (capacidade < 0){
            throw new IllegalArgumentException("A capacidade nao pode ser negativa");
        }
        this.capacidade = capacidade;
    }
    
    @Override
    public String toString() {
        return  "Nome: "+ nome + " | " + "Capacidade: " + capacidade;
    }
}