package test;

public class TodosOsTestes {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   EXECUTANDO TODOS OS TESTES DO JOGO");
        System.out.println("     Pedra, Papel e Tesoura");
        System.out.println("========================================\n");

        boolean todosOsTestesPassaram = true;

        try {
            // Executar testes da classe Gesto (versão adaptada)
            System.out.println("1. Testando classe Gesto...");
            GestoJUnitTest.main(new String[] {});
            System.out.println("✅ Classe Gesto - TODOS OS TESTES PASSARAM!\n");

        } catch (Exception | AssertionError e) {
            System.out.println(" Classe Gesto - FALHA NOS TESTES!");
            System.out.println("Erro: " + e.getMessage() + "\n");
            todosOsTestesPassaram = false;
        }

        try {
            System.out.println("2. Testando classe Mao...");
            MaoTest.main(new String[] {});
            System.out.println(" Classe Mao - TODOS OS TESTES PASSARAM!\n");

        } catch (Exception | AssertionError e) {
            System.out.println(" Classe Mao - FALHA NOS TESTES!");
            System.out.println("Erro: " + e.getMessage() + "\n");
            todosOsTestesPassaram = false;
        }

        try {
            System.out.println("3. Testando classe Jogar...");
            JogarTest.main(new String[] {});
            System.out.println(" Classe Jogar - TODOS OS TESTES PASSARAM!\n");

        } catch (Exception | AssertionError e) {
            System.out.println(" Classe Jogar - FALHA NOS TESTES!");
            System.out.println("Erro: " + e.getMessage() + "\n");
            todosOsTestesPassaram = false;
        }

        try {
            System.out.println("4. Testando classe Jogo...");
            JogoTest.main(new String[] {});
            System.out.println(" Classe Jogo - TODOS OS TESTES PASSARAM!\n");

        } catch (Exception | AssertionError e) {
            System.out.println(" Classe Jogo - FALHA NOS TESTES!");
            System.out.println("Erro: " + e.getMessage() + "\n");
            todosOsTestesPassaram = false;
        }

        System.out.println("========================================");
        if (todosOsTestesPassaram) {
            System.out.println(" RESULTADO FINAL: TODOS OS TESTES PASSARAM!");
            System.out.println("   O jogo está funcionando corretamente!");
        } else {
            System.out.println(" RESULTADO FINAL: ALGUNS TESTES FALHARAM!");
            System.out.println("   Verifique os erros acima.");
        }
        System.out.println("========================================");

        System.out.println("\n ESTATÍSTICAS DOS TESTES:");
        System.out.println("Classes testadas: 4 (Gesto, Mao, Jogar, Jogo)");
        System.out.println("Cenários testados:");
        System.out.println("  - Objetos estáticos e inicialização");
        System.out.println("  - Validação de entrada");
        System.out.println("  - Lógica do jogo (vitória, derrota, empate)");
        System.out.println("  - Tratamento de erros");
        System.out.println("  - Integração entre classes");

        if (!todosOsTestesPassaram) {
            System.exit(1);
        }
    }
}