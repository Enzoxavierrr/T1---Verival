package test;

import src.Gesto;

/**
 * Testes da classe Gesto (versão sem JUnit)
 */
public class GestoJUnitTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes da classe Gesto (versão JUnit adaptada) ===");

        testObjetosEstaticos();
        testObterGesto();
        testObterGestoComEntradaInvalida();
        testGetters();
        testRelacoesPedra();
        testRelacoesPapel();
        testRelacoesTesoura();

        System.out.println("=== Todos os testes da classe Gesto passaram! ===\n");
    }

    public static void testObjetosEstaticos() {
        System.out.println("Testando objetos estáticos...");

        // Verificar se os objetos foram criados
        assert Gesto.PEDRA != null : "PEDRA não deve ser null";
        assert Gesto.PAPEL != null : "PAPEL não deve ser null";
        assert Gesto.TESOURA != null : "TESOURA não deve ser null";

        // Verificar nomes dos gestos
        assert "pedra".equals(Gesto.PEDRA.getJogada()) : "Nome da PEDRA deve ser 'pedra'";
        assert "papel".equals(Gesto.PAPEL.getJogada()) : "Nome do PAPEL deve ser 'papel'";
        assert "tesoura".equals(Gesto.TESOURA.getJogada()) : "Nome da TESOURA deve ser 'tesoura'";

        System.out.println("✓ Objetos estáticos criados corretamente");
    }

    public static void testObterGesto() {
        System.out.println("Testando método obterGesto...");

        // Testar com entradas válidas
        assert Gesto.obterGesto("pedra") == Gesto.PEDRA : "obterGesto('pedra') deve retornar PEDRA";
        assert Gesto.obterGesto("papel") == Gesto.PAPEL : "obterGesto('papel') deve retornar PAPEL";
        assert Gesto.obterGesto("tesoura") == Gesto.TESOURA : "obterGesto('tesoura') deve retornar TESOURA";

        // Testar case insensitive
        assert Gesto.obterGesto("PEDRA") == Gesto.PEDRA : "obterGesto deve ser case insensitive";
        assert Gesto.obterGesto("Papel") == Gesto.PAPEL : "obterGesto deve ser case insensitive";
        assert Gesto.obterGesto("TeSOUrA") == Gesto.TESOURA : "obterGesto deve ser case insensitive";

        System.out.println("✓ Método obterGesto funciona corretamente");
    }

    public static void testObterGestoComEntradaInvalida() {
        System.out.println("Testando obterGesto com entrada inválida...");

        try {
            Gesto.obterGesto("invalid");
            assert false : "Deveria lançar IllegalArgumentException para entrada inválida";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().contains("Gesto inválido") : "Mensagem de erro deve conter 'Gesto inválido'";
        }

        try {
            Gesto.obterGesto("");
            assert false : "Deveria lançar IllegalArgumentException para string vazia";
        } catch (IllegalArgumentException e) {
            // Esperado
        }

        try {
            Gesto.obterGesto(null);
            assert false : "Deveria lançar exceção para null";
        } catch (Exception e) {
            // Esperado (pode ser NullPointerException ou IllegalArgumentException)
        }

        System.out.println("✓ Tratamento de entradas inválidas funciona corretamente");
    }

    public static void testGetters() {
        System.out.println("Testando métodos getters...");

        assert Gesto.PEDRA.getJogada() != null : "getJogada não deve retornar null";
        assert Gesto.PEDRA.getGanha() != null : "getGanha não deve retornar null";
        assert Gesto.PEDRA.getPerde() != null : "getPerde não deve retornar null";

        System.out.println("✓ Métodos getters funcionam corretamente");
    }

    public static void testRelacoesPedra() {
        System.out.println("Testando relações da PEDRA...");

        // PEDRA ganha de TESOURA
        assert Gesto.PEDRA.getGanha().contains(Gesto.TESOURA) : "PEDRA deve ganhar de TESOURA";
        assert !Gesto.PEDRA.getGanha().contains(Gesto.PAPEL) : "PEDRA não deve ganhar de PAPEL";
        assert !Gesto.PEDRA.getGanha().contains(Gesto.PEDRA) : "PEDRA não deve ganhar de si mesma";

        // PEDRA perde para PAPEL
        assert Gesto.PEDRA.getPerde().contains(Gesto.PAPEL) : "PEDRA deve perder para PAPEL";
        assert !Gesto.PEDRA.getPerde().contains(Gesto.TESOURA) : "PEDRA não deve perder para TESOURA";
        assert !Gesto.PEDRA.getPerde().contains(Gesto.PEDRA) : "PEDRA não deve perder para si mesma";

        System.out.println("✓ Relações da PEDRA estão corretas");
    }

    public static void testRelacoesPapel() {
        System.out.println("Testando relações do PAPEL...");

        // PAPEL ganha de PEDRA
        assert Gesto.PAPEL.getGanha().contains(Gesto.PEDRA) : "PAPEL deve ganhar de PEDRA";
        assert !Gesto.PAPEL.getGanha().contains(Gesto.TESOURA) : "PAPEL não deve ganhar de TESOURA";
        assert !Gesto.PAPEL.getGanha().contains(Gesto.PAPEL) : "PAPEL não deve ganhar de si mesmo";

        // PAPEL perde para TESOURA
        assert Gesto.PAPEL.getPerde().contains(Gesto.TESOURA) : "PAPEL deve perder para TESOURA";
        assert !Gesto.PAPEL.getPerde().contains(Gesto.PEDRA) : "PAPEL não deve perder para PEDRA";
        assert !Gesto.PAPEL.getPerde().contains(Gesto.PAPEL) : "PAPEL não deve perder para si mesmo";

        System.out.println("✓ Relações do PAPEL estão corretas");
    }

    public static void testRelacoesTesoura() {
        System.out.println("Testando relações da TESOURA...");

        // TESOURA ganha de PAPEL
        assert Gesto.TESOURA.getGanha().contains(Gesto.PAPEL) : "TESOURA deve ganhar de PAPEL";
        assert !Gesto.TESOURA.getGanha().contains(Gesto.PEDRA) : "TESOURA não deve ganhar de PEDRA";
        assert !Gesto.TESOURA.getGanha().contains(Gesto.TESOURA) : "TESOURA não deve ganhar de si mesma";

        // TESOURA perde para PEDRA
        assert Gesto.TESOURA.getPerde().contains(Gesto.PEDRA) : "TESOURA deve perder para PEDRA";
        assert !Gesto.TESOURA.getPerde().contains(Gesto.PAPEL) : "TESOURA não deve perder para PAPEL";
        assert !Gesto.TESOURA.getPerde().contains(Gesto.TESOURA) : "TESOURA não deve perder para si mesma";

        System.out.println("✓ Relações da TESOURA estão corretas");
    }
}