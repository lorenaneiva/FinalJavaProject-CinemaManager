package Models;

public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private String classificacao;
    private double duracao;

    // Construtor padrão
    public Filme() {
        this.id = 0;
        this.titulo = "";
        this.genero = "";
        this.classificacao = "";
        this.duracao = 0.0;
    }

    public Filme(String titulo, String genero, String classificacao, double duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public Filme(int id, String titulo, String genero, String classificacao, double duracao){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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