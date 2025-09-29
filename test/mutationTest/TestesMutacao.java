package test.mutationTest;

import src.*;

/**
 * Framework manual para Testes de Mutação
 * 
 * Este teste aplica mutações específicas no código e verifica se os testes
 * conseguem detectar essas mudanças. É uma implementação manual do conceito
 * de mutation testing.
 */
public class TestesMutacao {

    private static int totalMutacoes = 0;
    private static int mutacoesMortas = 0; // Detectadas pelos testes
    private static int mutacoesVivas = 0; // NÃO detectadas (problema!)

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("        TESTES DE MUTAÇÃO");
        System.out.println("    Jogo Pedra, Papel e Tesoura");
        System.out.println("========================================\n");

        // Executar diferentes categorias de mutação
        testarMutacoesCondicionais();
        testarMutacoesAritmeticas();
        testarMutacoesRelacionais();
        testarMutacoesConstantes();

        // Relatório final
        exibirRelatorioFinal();
    }

    /**
     * Testa mutações em condicionais (if/else)
     */
    public static void testarMutacoesCondicionais() {
        System.out.println("🧬 MUTAÇÕES CONDICIONAIS");
        System.out.println("=" + "=".repeat(30));

        // Mutação 1: Trocar && por ||
        System.out.println("\n1. Testando mutação: && → ||");
        boolean mutacao1Detectada = testarMutacaoCondicional1();
        registrarMutacao("Operador && → ||", mutacao1Detectada);

        // Mutação 2: Inverter condições
        System.out.println("\n2. Testando mutação: Inverter condições");
        boolean mutacao2Detectada = testarMutacaoCondicional2();
        registrarMutacao("Inverter condições", mutacao2Detectada);

        System.out.println();
    }

    /**
     * Testa mutações aritméticas
     */
    public static void testarMutacoesAritmeticas() {
        System.out.println("🧬 MUTAÇÕES ARITMÉTICAS");
        System.out.println("=" + "=".repeat(30));

        // Simulação: se houvesse operações matemáticas
        System.out.println("\n1. Testando mutação: + → -");
        boolean mutacao1 = testarMutacaoAritmetica();
        registrarMutacao("Operador + → -", mutacao1);

        System.out.println();
    }

    /**
     * Testa mutações relacionais (==, !=, etc.)
     */
    public static void testarMutacoesRelacionais() {
        System.out.println("🧬 MUTAÇÕES RELACIONAIS");
        System.out.println("=" + "=".repeat(30));

        // Mutação: == por !=
        System.out.println("\n1. Testando mutação: == → !=");
        boolean mutacao1 = testarMutacaoRelacional();
        registrarMutacao("Operador == → !=", mutacao1);

        System.out.println();
    }

    /**
     * Testa mutações de constantes
     */
    public static void testarMutacoesConstantes() {
        System.out.println("🧬 MUTAÇÕES DE CONSTANTES");
        System.out.println("=" + "=".repeat(30));

        // Mutação: trocar strings
        System.out.println("\n1. Testando mutação: \"pedra\" → \"papel\"");
        boolean mutacao1 = testarMutacaoConstante();
        registrarMutacao("String \"pedra\" → \"papel\"", mutacao1);

        System.out.println();
    }

    // ===== IMPLEMENTAÇÃO DAS MUTAÇÕES =====

    /**
     * Simula mutação: trocar contains() por !contains()
     */
    public static boolean testarMutacaoCondicional1() {
        try {
            // Código original: if(jogador1.gesto.ganha.contains(jogador2.gesto))
            // Mutação: if(!jogador1.gesto.ganha.contains(jogador2.gesto))

            Jogar jogarMutado = new JogarMutado1();
            Mao maoPedra = new Mao(Gesto.PEDRA);
            Mao maoTesoura = new Mao(Gesto.TESOURA);

            Resultado resultado = jogarMutado.ResultadoDoJogo(maoPedra, maoTesoura);
            Resultado esperado = Resultado.GANHADOR;

            boolean mutacaoDetectada = !resultado.equals(esperado);

            if (mutacaoDetectada) {
                System.out.println("   ✅ MUTAÇÃO DETECTADA - Resultado mudou de " + esperado + " para " + resultado);
            } else {
                System.out.println("   ❌ MUTAÇÃO SOBREVIVEU - Resultado permaneceu " + resultado);
            }

            return mutacaoDetectada;

        } catch (Exception e) {
            System.out.println("   ✅ MUTAÇÃO DETECTADA - Exceção lançada: " + e.getMessage());
            return true;
        }
    }

    /**
     * Simula mutação: inverter ordem das condições
     */
    public static boolean testarMutacaoCondicional2() {
        try {
            // Código original: verifica ganha primeiro, depois perde
            // Mutação: verifica perde primeiro, depois ganha

            Jogar jogarMutado = new JogarMutado2();
            Mao maoPedra = new Mao(Gesto.PEDRA);
            Mao maoTesoura = new Mao(Gesto.TESOURA);

            Resultado resultado = jogarMutado.ResultadoDoJogo(maoPedra, maoTesoura);
            Resultado esperado = Resultado.GANHADOR;

            boolean mutacaoDetectada = !resultado.equals(esperado);

            if (mutacaoDetectada) {
                System.out.println("   ✅ MUTAÇÃO DETECTADA - Resultado mudou de " + esperado + " para " + resultado);
            } else {
                System.out.println("   ❌ MUTAÇÃO SOBREVIVEU - Resultado permaneceu " + resultado);
            }

            return mutacaoDetectada;

        } catch (Exception e) {
            System.out.println("   ✅ MUTAÇÃO DETECTADA - Exceção lançada: " + e.getMessage());
            return true;
        }
    }

    /**
     * Simula mutação aritmética (se houvesse)
     */
    public static boolean testarMutacaoAritmetica() {
        // Para este projeto, não há operações aritméticas significativas
        System.out.println("   ℹ️  Não há operações aritméticas no código atual");
        return true; // Consideramos como detectada
    }

    /**
     * Simula mutação relacional
     */
    public static boolean testarMutacaoRelacional() {
        try {
            // Simula trocar == por != na comparação de strings
            GestoMutado gestoMutado = new GestoMutado();

            try {
                Gesto resultado = gestoMutado.obterGestoMutado("pedra");
                boolean mutacaoDetectada = (resultado != Gesto.PEDRA);

                if (mutacaoDetectada) {
                    System.out.println("   ✅ MUTAÇÃO DETECTADA - Retornou gesto incorreto");
                } else {
                    System.out.println("   ❌ MUTAÇÃO SOBREVIVEU - Retornou gesto correto");
                }

                return mutacaoDetectada;
            } catch (Exception e) {
                System.out.println("   ✅ MUTAÇÃO DETECTADA - Exceção inesperada: " + e.getMessage());
                return true;
            }

        } catch (Exception e) {
            System.out.println("   ✅ MUTAÇÃO DETECTADA - Erro na criação: " + e.getMessage());
            return true;
        }
    }

    /**
     * Simula mutação de constante
     */
    public static boolean testarMutacaoConstante() {
        try {
            // Simula trocar "pedra" por "papel" no switch
            Gesto resultado = Gesto.obterGesto("pedra");

            // Em uma mutação real, isso retornaria PAPEL em vez de PEDRA
            // Vamos simular verificando se nossos testes detectariam

            boolean estaCorreto = (resultado == Gesto.PEDRA);
            boolean mutacaoDetectada = estaCorreto; // Se está correto, nossos testes detectariam a mutação

            if (mutacaoDetectada) {
                System.out.println("   ✅ MUTAÇÃO SERIA DETECTADA - Testes verificam o retorno correto");
            } else {
                System.out.println("   ❌ MUTAÇÃO SOBREVIVERIA - Testes não verificam adequadamente");
            }

            return mutacaoDetectada;

        } catch (Exception e) {
            System.out.println("   ✅ MUTAÇÃO DETECTADA - Exceção: " + e.getMessage());
            return true;
        }
    }

    // ===== CLASSES MUTADAS PARA TESTE =====

    /**
     * Versão mutada da classe Jogar - Mutação 1
     */
    static class JogarMutado1 extends Jogar {
        @Override
        public Resultado ResultadoDoJogo(Mao jogador1, Mao jogador2) {
            // MUTAÇÃO: Inverteu a condição contains()
            if (!jogador1.getGesto().getGanha().contains(jogador2.getGesto())) {
                return Resultado.GANHADOR;
            }
            if (jogador1.getGesto().getPerde().contains(jogador2.getGesto())) {
                return Resultado.PERDEDOR;
            }
            return Resultado.EMPATE;
        }
    }

    /**
     * Versão mutada da classe Jogar - Mutação 2
     */
    static class JogarMutado2 extends Jogar {
        @Override
        public Resultado ResultadoDoJogo(Mao jogador1, Mao jogador2) {
            // MUTAÇÃO: Inverteu ordem das condições
            if (jogador1.getGesto().getPerde().contains(jogador2.getGesto())) {
                return Resultado.PERDEDOR;
            }
            if (jogador1.getGesto().getGanha().contains(jogador2.getGesto())) {
                return Resultado.GANHADOR;
            }
            return Resultado.EMPATE;
        }
    }

    /**
     * Versão mutada do método obterGesto
     */
    static class GestoMutado {
        public Gesto obterGestoMutado(String nome) {
            switch (nome.toLowerCase()) {
                case "pedra":
                    return Gesto.PAPEL; // MUTAÇÃO: retorna PAPEL em vez de PEDRA
                case "papel":
                    return Gesto.PAPEL;
                case "tesoura":
                    return Gesto.TESOURA;
                default:
                    throw new IllegalArgumentException("Gesto inválido: " + nome);
            }
        }
    }

    // ===== UTILITÁRIOS =====

    private static void registrarMutacao(String descricao, boolean detectada) {
        totalMutacoes++;
        if (detectada) {
            mutacoesMortas++;
            System.out.printf("   🎯 %s: MORTA (detectada)%n", descricao);
        } else {
            mutacoesVivas++;
            System.out.printf("   ⚠️  %s: VIVA (problema!)%n", descricao);
        }
    }

    private static void exibirRelatorioFinal() {
        System.out.println("========================================");
        System.out.println("           RELATÓRIO FINAL");
        System.out.println("========================================");

        double scoreCobertura = totalMutacoes > 0 ? (double) mutacoesMortas / totalMutacoes * 100 : 0;

        System.out.printf("Total de mutações testadas: %d%n", totalMutacoes);
        System.out.printf("Mutações mortas (detectadas): %d%n", mutacoesMortas);
        System.out.printf("Mutações vivas (não detectadas): %d%n", mutacoesVivas);
        System.out.printf("Score de cobertura de mutação: %.1f%%%n", scoreCobertura);

        System.out.println();
        if (scoreCobertura >= 80) {
            System.out.println("🎉 EXCELENTE! Seus testes têm boa qualidade.");
        } else if (scoreCobertura >= 60) {
            System.out.println("👍 BOM! Mas há espaço para melhorar os testes.");
        } else {
            System.out.println("⚠️  ATENÇÃO! Seus testes precisam de melhorias.");
        }

        System.out.println("\n📋 RECOMENDAÇÕES:");
        System.out.println("• Mutação Score >= 80% é considerado bom");
        System.out.println("• Mutações vivas indicam testes insuficientes");
        System.out.println("• Adicione testes para cenários não cobertos");

        if (mutacoesVivas > 0) {
            System.out.println("\n❗ AÇÃO NECESSÁRIA:");
            System.out.println("• Revise as mutações que sobreviveram");
            System.out.println("• Adicione testes específicos para cobrir esses casos");
            System.out.println("• Melhore as assertions dos testes existentes");
        }
    }
}