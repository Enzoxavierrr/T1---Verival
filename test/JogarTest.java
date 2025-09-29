package test;

import src.Gesto;
import src.Jogar;
import src.Mao;
import src.Resultado;

public class JogarTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes para a classe Jogar ===");

        testPedraVsTesoura();
        testPedraVsPapel();
        testPapelVsPedra();
        testPapelVsTesoura();
        testTesouraVsPapel();
        testTesouraVsPedra();
        testEmpates();
        testTodosOsResultadosPossiveis();

        System.out.println("=== Todos os testes da classe Jogar passaram! ===\n");
    }

    public static void testPedraVsTesoura() {
        System.out.println("Testando PEDRA vs TESOURA...");

        Jogar jogar = new Jogar();
        Mao maoPedra = new Mao(Gesto.PEDRA);
        Mao maoTesoura = new Mao(Gesto.TESOURA);

        Resultado resultado = jogar.ResultadoDoJogo(maoPedra, maoTesoura);
        assert resultado == Resultado.GANHADOR : "PEDRA deve ganhar de TESOURA";

        System.out.println("✓ PEDRA vence TESOURA corretamente");
    }

    public static void testPedraVsPapel() {
        System.out.println("Testando PEDRA vs PAPEL...");

        Jogar jogar = new Jogar();
        Mao maoPedra = new Mao(Gesto.PEDRA);
        Mao maoPapel = new Mao(Gesto.PAPEL);

        Resultado resultado = jogar.ResultadoDoJogo(maoPedra, maoPapel);
        assert resultado == Resultado.PERDEDOR : "PEDRA deve perder para PAPEL";

        System.out.println("✓ PEDRA perde para PAPEL corretamente");
    }

    public static void testPapelVsPedra() {
        System.out.println("Testando PAPEL vs PEDRA...");

        Jogar jogar = new Jogar();
        Mao maoPapel = new Mao(Gesto.PAPEL);
        Mao maoPedra = new Mao(Gesto.PEDRA);

        Resultado resultado = jogar.ResultadoDoJogo(maoPapel, maoPedra);
        assert resultado == Resultado.GANHADOR : "PAPEL deve ganhar de PEDRA";

        System.out.println("✓ PAPEL vence PEDRA corretamente");
    }

    public static void testPapelVsTesoura() {
        System.out.println("Testando PAPEL vs TESOURA...");

        Jogar jogar = new Jogar();
        Mao maoPapel = new Mao(Gesto.PAPEL);
        Mao maoTesoura = new Mao(Gesto.TESOURA);

        Resultado resultado = jogar.ResultadoDoJogo(maoPapel, maoTesoura);
        assert resultado == Resultado.PERDEDOR : "PAPEL deve perder para TESOURA";

        System.out.println("✓ PAPEL perde para TESOURA corretamente");
    }

    public static void testTesouraVsPapel() {
        System.out.println("Testando TESOURA vs PAPEL...");

        Jogar jogar = new Jogar();
        Mao maoTesoura = new Mao(Gesto.TESOURA);
        Mao maoPapel = new Mao(Gesto.PAPEL);

        Resultado resultado = jogar.ResultadoDoJogo(maoTesoura, maoPapel);
        assert resultado == Resultado.GANHADOR : "TESOURA deve ganhar de PAPEL";

        System.out.println("✓ TESOURA vence PAPEL corretamente");
    }

    public static void testTesouraVsPedra() {
        System.out.println("Testando TESOURA vs PEDRA...");

        Jogar jogar = new Jogar();
        Mao maoTesoura = new Mao(Gesto.TESOURA);
        Mao maoPedra = new Mao(Gesto.PEDRA);

        Resultado resultado = jogar.ResultadoDoJogo(maoTesoura, maoPedra);
        assert resultado == Resultado.PERDEDOR : "TESOURA deve perder para PEDRA";

        System.out.println("✓ TESOURA perde para PEDRA corretamente");
    }

    public static void testEmpates() {
        System.out.println("Testando empates...");

        Jogar jogar = new Jogar();

        // PEDRA vs PEDRA
        Mao maoPedra1 = new Mao(Gesto.PEDRA);
        Mao maoPedra2 = new Mao(Gesto.PEDRA);
        Resultado resultado1 = jogar.ResultadoDoJogo(maoPedra1, maoPedra2);
        assert resultado1 == Resultado.EMPATE : "PEDRA vs PEDRA deve ser empate";

        // PAPEL vs PAPEL
        Mao maoPapel1 = new Mao(Gesto.PAPEL);
        Mao maoPapel2 = new Mao(Gesto.PAPEL);
        Resultado resultado2 = jogar.ResultadoDoJogo(maoPapel1, maoPapel2);
        assert resultado2 == Resultado.EMPATE : "PAPEL vs PAPEL deve ser empate";

        // TESOURA vs TESOURA
        Mao maoTesoura1 = new Mao(Gesto.TESOURA);
        Mao maoTesoura2 = new Mao(Gesto.TESOURA);
        Resultado resultado3 = jogar.ResultadoDoJogo(maoTesoura1, maoTesoura2);
        assert resultado3 == Resultado.EMPATE : "TESOURA vs TESOURA deve ser empate";

        System.out.println("✓ Todos os empates funcionam corretamente");
    }

    public static void testTodosOsResultadosPossiveis() {
        System.out.println("Testando se todos os resultados possíveis são cobertos...");

        Jogar jogar = new Jogar();
        boolean temGanhador = false;
        boolean temPerdedor = false;
        boolean temEmpate = false;

        Gesto[] gestos = { Gesto.PEDRA, Gesto.PAPEL, Gesto.TESOURA };

        for (Gesto gesto1 : gestos) {
            for (Gesto gesto2 : gestos) {
                Mao mao1 = new Mao(gesto1);
                Mao mao2 = new Mao(gesto2);
                Resultado resultado = jogar.ResultadoDoJogo(mao1, mao2);

                if (resultado == Resultado.GANHADOR)
                    temGanhador = true;
                if (resultado == Resultado.PERDEDOR)
                    temPerdedor = true;
                if (resultado == Resultado.EMPATE)
                    temEmpate = true;
            }
        }

        assert temGanhador : "Deve existir pelo menos um caso de GANHADOR";
        assert temPerdedor : "Deve existir pelo menos um caso de PERDEDOR";
        assert temEmpate : "Deve existir pelo menos um caso de EMPATE";

        System.out.println("✓ Todos os tipos de resultado são possíveis");
    }
}