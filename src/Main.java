import Models.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CINEMA - TESTES ===\n");
        
        try {
            // 1. Testando a classe Filme
            System.out.println("1. TESTANDO CLASSE FILME:");
            Filme filme1 = new Filme("O Poderoso Chefão", "Drama", "16+", 175.0);
            Filme filme2 = new Filme("Vingadores: Ultimato", "Ação", "12+", 181.0);
            
            System.out.println("Filme 1: " + filme1);
            System.out.println("Filme 2: " + filme2);
            
            // Testando validações
            try {
                Filme filmeInvalido = new Filme("", "Ação", "12+", 120.0);
            } catch (IllegalArgumentException e) {
                System.out.println("✅ Validação de título vazio funcionou: " + e.getMessage());
            }
            
            System.out.println();
            
            // 2. Testando a classe Sala
            System.out.println("2. TESTANDO CLASSE SALA:");
            Sala sala1 = new Sala("Sala 1", 50);
            Sala sala2 = new Sala("Sala VIP", 30);
            
            System.out.println("Sala 1: " + sala1);
            System.out.println("Sala 2: " + sala2);
            
            System.out.println();
            
            // 3. Testando a classe Sessao
            System.out.println("3. TESTANDO CLASSE SESSÃO:");
            LocalDate dataFutura = LocalDate.now().plusDays(7);
            LocalTime horario = LocalTime.of(19, 30);
            
            Sessao sessao1 = new Sessao(dataFutura, horario, filme1, sala1, 50);
            Sessao sessao2 = new Sessao(dataFutura.plusDays(1), LocalTime.of(16, 0), filme2, sala2, 30);
            
            System.out.println("Sessão 1: " + sessao1);
            System.out.println("Sessão 2: " + sessao2);
            
            // Testando validação de data passada
            try {
                Sessao sessaoInvalida = new Sessao(LocalDate.now().minusDays(1), horario, filme1, sala1, 50);
            } catch (IllegalArgumentException e) {
                System.out.println("✅ Validação de data passada funcionou: " + e.getMessage());
            }
            
            System.out.println();
            
            // 4. Testando a classe Assento
            System.out.println("4. TESTANDO CLASSE ASSENTO:");
            Assento assento1 = new Assento("A1");
            Assento assento2 = new Assento("B5");
            Assento assento3 = new Assento("C3");
            
            System.out.println("Assento 1: " + assento1);
            System.out.println("Assento 2: " + assento2);
            
            // Testando reserva de assento
            assento1.reservar();
            System.out.println("Após reservar A1: " + assento1);
            
            // Testando tentativa de reservar assento já ocupado
            try {
                assento1.reservar();
            } catch (IllegalStateException e) {
                System.out.println("✅ Validação de assento ocupado funcionou: " + e.getMessage());
            }
            
            // Testando liberação de assento
            assento1.liberar();
            System.out.println("Após liberar A1: " + assento1);
            
            System.out.println();
            
            // 5. Testando a classe Reserva
            System.out.println("5. TESTANDO CLASSE RESERVA:");
            
            // Reservando alguns assentos
            assento1.reservar();
            assento2.reservar();
            
            Reserva reserva1 = new Reserva(sessao1, assento1, true);
            Reserva reserva2 = new Reserva(sessao2, assento2, false);
            
            System.out.println("Reserva 1: " + reserva1);
            System.out.println("Reserva 2: " + reserva2);
            
            // Testando status de pagamento
            System.out.print("Status reserva 1: ");
            reserva1.verificarStatusPagamento();
            
            System.out.print("Status reserva 2: ");
            reserva2.verificarStatusPagamento();
            
            // Confirmando pagamento da reserva 2
            reserva2.confirmarPagamento();
            System.out.println("Reserva 2 após confirmação: " + reserva2);
            
            System.out.println();
            
            // 6. Cenário completo: Simulando um fluxo real
            System.out.println("6. CENÁRIO COMPLETO - FLUXO DE RESERVA:");
            
            // Criando novos objetos para o cenário
            Filme filmeNovo = new Filme("Interestelar", "Ficção Científica", "10+", 169.0);
            Sala salaNova = new Sala("Sala IMAX", 100);
            Sessao sessaoNova = new Sessao(
                LocalDate.now().plusDays(3), 
                LocalTime.of(20, 15), 
                filmeNovo, 
                salaNova, 
                100
            );
            
            Assento assentoNovo1 = new Assento("D7");
            Assento assentoNovo2 = new Assento("D8");
            
            System.out.println("Filme: " + filmeNovo.getTitulo());
            System.out.println("Sala: " + salaNova.getNome());
            System.out.println("Data: " + sessaoNova.getData() + " às " + sessaoNova.getHorario());
            System.out.println("Vagas disponíveis: " + sessaoNova.getVagas());
            
            // Fazendo reservas
            assentoNovo1.reservar();
            Reserva reservaNova1 = new Reserva(sessaoNova, assentoNovo1, false);
            System.out.println("\nReserva criada: " + reservaNova1);
            
            // Cliente faz o pagamento
            reservaNova1.confirmarPagamento();
            System.out.println("Após pagamento: " + reservaNova1);
            
            // Tentando reservar o mesmo assento
            try {
                assentoNovo1.reservar();
            } catch (IllegalStateException e) {
                System.out.println("❌ Não foi possível reservar: " + e.getMessage());
            }
            
            // Reservando outro assento
            assentoNovo2.reservar();
            Reserva reservaNova2 = new Reserva(sessaoNova, assentoNovo2, true);
            System.out.println("Nova reserva: " + reservaNova2);
            
            System.out.println();
            System.out.println("=== TODOS OS TESTES FORAM CONCLUÍDOS COM SUCESSO! ===");
            
        } catch (Exception e) {
            System.out.println("❌ Erro durante os testes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}