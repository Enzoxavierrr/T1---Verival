package test;

import src.Jogo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JogoTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes para a classe Jogo ===");

        testJogarComGestosValidos();
        testJogarComGestoInvalido();
        testTodosOsResultadosDoJogo();
        testCriacaoDoObjetoJogo();

        System.out.println("=== Todos os testes da classe Jogo passaram! ===\n");
    }

    public static void testJogarComGestosValidos() {
        System.out.println("Testando método jogar com gestos válidos...");

        Jogo jogo = new Jogo();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Testes com gestos válidos
            jogo.jogar("pedra", "tesoura");
            jogo.jogar("papel", "pedra");
            jogo.jogar("tesoura", "papel");
            jogo.jogar("pedra", "pedra"); // empate

            System.setOut(originalOut);

            String output = outputStream.toString();

            assert output.contains("Resultado da partida") : "Saída deve conter 'Resultado da partida'";
            assert output.contains("Jogador 1") : "Saída deve conter 'Jogador 1'";
            assert output.contains("Jogador 2") : "Saída deve conter 'Jogador 2'";

            System.out.println("✓ Método jogar funciona com gestos válidos");
        } catch (Exception e) {
            System.setOut(originalOut);
            throw e;
        }
    }

    public static void testJogarComGestoInvalido() {
        System.out.println("Testando método jogar com gesto inválido...");

        Jogo jogo = new Jogo();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            jogo.jogar("pedra", "invalid");

            System.setOut(originalOut);

            String output = outputStream.toString();

            assert output.contains("Erro") : "Saída deve conter mensagem de erro";
            assert output.contains("Gestos válidos") : "Saída deve conter lista de gestos válidos";

            System.out.println("✓ Método jogar trata gestos inválidos corretamente");
        } catch (Exception e) {
            System.setOut(originalOut);
            throw e;
        }
    }

    public static void testTodosOsResultadosDoJogo() {
        System.out.println("Testando se todos os resultados são possíveis...");

        Jogo jogo = new Jogo();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            jogo.jogar("pedra", "tesoura"); // GANHADOR
            jogo.jogar("pedra", "papel"); // PERDEDOR
            jogo.jogar("pedra", "pedra"); // EMPATE

            System.setOut(originalOut);

            String output = outputStream.toString();

            assert output.contains("GANHADOR") || output.contains("GANADOR") : "Deve conter resultado de vitória";
            assert output.contains("PERDEDOR") : "Deve conter resultado de derrota";
            assert output.contains("EMPATE") : "Deve conter resultado de empate";

            System.out.println("✓ Todos os tipos de resultado são gerados corretamente");
        } catch (Exception e) {
            System.setOut(originalOut);
            throw e;
        }
    }

    public static void testCriacaoDoObjetoJogo() {
        System.out.println("Testando criação do objeto Jogo...");

        Jogo jogo = new Jogo();

        assert jogo != null : "Objeto Jogo não deve ser null";

        try {
            jogo.jogar("pedra", "papel"); // Se não der erro, o controller existe
            System.out.println("✓ Objeto Jogo criado corretamente");
        } catch (NullPointerException e) {
            assert false : "Controller não foi inicializado corretamente";
        }
    }
}