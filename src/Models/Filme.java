package Models;

public class Filme {

    private static int contadorGlobal = 0;

    private int id;
    private String titulo;
    private String genero;
    private String classificacao;
    private double duracao;

    public Filme() {
        this.id = ++contadorGlobal;
    }
    
    public Filme(String titulo, String genero, String classificacao, double duracao){
        this.id = contadorGlobal++;
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        if (titulo == null || titulo.isEmpty()){
            throw new IllegalArgumentException("o titulo nao pode ser vazio!");
        }
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getDuracao() {
        return duracao;
    }
    public void setDuracao(double duracao){
        if (duracao <= 0){
            throw new IllegalArgumentException("A duracao deve ser positiva!");
        }
        this.duracao = duracao;
    }
    @Override
    public String toString() {
        return titulo + " | Genero: " + genero + " | Classificacao: " 
            + classificacao + " | Duracao: " + duracao + " min";
    }
}