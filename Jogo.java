import java.util.Scanner;

public class Jogo {

    Mao jogador1;
    Mao jogador2;

    Jogar controller = new Jogar();

    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem-vindo ao Jogo Pedra, Papel e Tesoura!");
            System.out.println("Escolha seu gesto: pedra, papel ou tesoura.");
            String gestoEscolhido = scanner.nextLine();

            System.out.println("Segundo gesto escolhido: pedra, papel ou tesoura.");
            String segundoGestoEscolhido = scanner.nextLine();

            jogo.jogar(gestoEscolhido, segundoGestoEscolhido);
        }
    }

    public void jogar(String gestoEscolhido, String segundoGestoEscolhido) {
        try {
            Gesto gesto1 = Gesto.obterGesto(gestoEscolhido);
            Gesto gesto2 = Gesto.obterGesto(segundoGestoEscolhido);

            Mao mao1 = new Mao(gesto1);
            Mao mao2 = new Mao(gesto2);

            Resultado resultado = controller.ResultadoDoJogo(mao1, mao2);
            System.out.println("Resultado da partida:");
            System.out.println("Jogador 1: " + gestoEscolhido);
            System.out.println("Jogador 2: " + segundoGestoEscolhido);
            System.out.println("Jogador 1 foi o: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Gestos válidos: pedra, papel, tesoura");
        }
    }
}
