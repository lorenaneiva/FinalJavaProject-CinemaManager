package Models;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Services.FilmeService;

public class Sessao {
    private int id;
    private LocalDate data;
    private LocalTime horario;
    private Sala sala;
    private int vagasDisponiveis;
    private ArrayList<Filme> filmes;
    private int proximoId = 1;
    private Filme filme;
    
    public Sessao() {
        this.filmes = new ArrayList<>();
    }
     public Sessao(LocalDate data, LocalTime horario, Filme filme, Sala sala, int vagasDisponiveis) {
        this.data = data;
        this.horario = horario;
        this.sala = sala;
        this.vagasDisponiveis = vagasDisponiveis;
        this.filmes = new ArrayList<>();
        this.filmes.add(filme);
    }
    // Adicionar filme
    public void adicionarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("O filme não pode ser nulo.");
        }
        filme.setId(proximoId++);
        filme.add(filme);
        System.out.println("Filme '" + filme.getTitulo() + "' adicionado com sucesso.");
    }
    // Listar filmes
    public ArrayList<Filme> listarFilmes() {
        return filmes;
    }
    // Buscar por ID
   public void definirFilmePorId(int id, FilmeService filmeService) {
    Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
    if (filmeEncontrado != null) {
        setFilme(filmeEncontrado);
    }
    else {
        throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
    }
    }
    // Editar filme 
    public boolean editarFilme(int id, String novoTitulo, String novoGenero, String novaClassificacao, double novaDuracao, FilmeService filmeService) {
        Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
        if (filmeEncontrado != null) {
            filmeEncontrado.setTitulo(novoTitulo);
            filmeEncontrado.setGenero(novoGenero);
            filmeEncontrado.setClassificacao(novaClassificacao);
            filmeEncontrado.setDuracao(novaDuracao);
            System.out.println("Filme com ID " + id + " editado com sucesso.");
            return true;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
        }
    }
    // Remover filme 
    public boolean removerFilme(int id, FilmeService filmeService) {
        Filme filmeEncontrado = filmeService.buscarFilmePorId(id);
        if (filmeEncontrado != null) {
            filmes.remove(filmeEncontrado);
            System.out.println("Filme com ID " + id + " removido com sucesso.");
            return true;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado.");
        }
    }
    public int getId() {
    return id;
    }
    public void setId(int id) {
    if (id <= 0) {
        throw new IllegalArgumentException("O ID da sessão deve ser maior que zero.");
    }
    this.id = id;
    }
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data){
        if (data == null){
            throw new IllegalArgumentException("o filme precisa de uma data");
        }
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("a data precisa ser apos a data atual");
        }
        this.data = data;
    }
    public LocalTime getHorario(){
        return horario;
    }
    public void setHorario(LocalTime horario){
        if (horario == null){
            throw new IllegalArgumentException("O horario da sessao precisa ser preenchido");
        }
        this.horario = horario;
    }
    public Filme getFilme(){
        return getFilme();
    }
    public void setFilme(Filme filme){
        if (filme == null){
            throw new IllegalArgumentException("O filme precisa ser adicionado na sessao");
        }
        this.filme = filme;
    }
    public Sala getSala(){
        return sala;
    }
    public void setSala(Sala sala){
        if (sala == null){
            throw new IllegalArgumentException("uma sala precisa ser escolhida para passar o filme");
        }
        this.sala = sala;
    }
    public int getVagas(){
        return vagasDisponiveis;
    }
    public void setVagas(int vagasDisponiveis){
        if (vagasDisponiveis < 0){
            throw new IllegalArgumentException("uma sessao nao pode passar do numero de assentos");
        }
        this.vagasDisponiveis = vagasDisponiveis;
    }
    @Override
    public String toString(){
        return "Data do filme: " + data + " | " + "Horario da Sessao: " + horario + " | " + "Filme: " + filme + " | "+ "Sala: " + sala + " | " + "Vagas Disponiveis: " + vagasDisponiveis;
    }
}