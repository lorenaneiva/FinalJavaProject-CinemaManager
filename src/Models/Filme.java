package Models;

public class Filme {
    private String titulo;
    private String genero;
    private String classificacao;
    private int duracao;

    public Filme (String titulo, String genero, String classificacao, int duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        if (titulo == null || titulo.isEmpty()){
            throw new IllegalArgumentException("o título não pode ser vazio!");
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

    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao){
        if (duracao <= 0){
            throw new IllegalArgumentException("A duração deve ser positiva!");
        }
        this.duracao = duracao;
    }
    @Override
    public String toString() {
        return "🎬 " + titulo + " | Gênero: " + genero + " | Classificação: " 
            + classificacao + " | Duração: " + duracao + " min";
    }

    
}
