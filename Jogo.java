import java.util.List;
import java.util.Scanner;

public class Jogo {

    Mao jogador1;
    Mao jogador2;

    jogoController controller = new jogoController();

public static void main(String[] args) {
        Jogo jogo = new Jogo();

        Gesto pedra = new Gesto("pedra", List.of(papel), List.of());
        Gesto papel = new Gesto("papel", List.of(tesoura), List.of());
        Gesto tesoura = new Gesto("tesoura", List.of(pedra), List.of());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo Pedra, Papel e Tesoura!");
        System.out.println("Escolha seu gesto: pedra, papel ou tesoura.");
        String gestoEscolhido = scanner.nextLine();
        System.out.println("Segundo gesto escolhido: pedra, papel ou tesoura.");
        String segundoGestoEscolhido = scanner.nextLine();

        jogo.jogar(gestoEscolhido, segundoGestoEscolhido);
    }

    public void jogar(String gestoEscolhido, String segundoGestoEscolhido) {

        if(gestoEscolhido.equals("pedra")) {
        
        }

    
}
