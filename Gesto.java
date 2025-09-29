import java.util.ArrayList;

public class Gesto {
    String jogada;
    ArrayList<Gesto> ganha;
    ArrayList<Gesto> perde;

    public static final Gesto PEDRA;
    public static final Gesto PAPEL;
    public static final Gesto TESOURA;

    static {
        PEDRA = new Gesto("pedra", new ArrayList<>(), new ArrayList<>());
        PAPEL = new Gesto("papel", new ArrayList<>(), new ArrayList<>());
        TESOURA = new Gesto("tesoura", new ArrayList<>(), new ArrayList<>());

        PEDRA.ganha.add(TESOURA);
        PEDRA.perde.add(PAPEL);

        PAPEL.ganha.add(PEDRA);
        PAPEL.perde.add(TESOURA);

        TESOURA.ganha.add(PAPEL);
        TESOURA.perde.add(PEDRA);
    }

    public Gesto(String jogada, ArrayList<Gesto> ganha, ArrayList<Gesto> perde) {
        this.jogada = jogada;
        this.ganha = ganha;
        this.perde = perde;
    }

    public static Gesto obterGesto(String nome) {
        switch (nome.toLowerCase()) {
            case "pedra":
                return PEDRA;
            case "papel":
                return PAPEL;
            case "tesoura":
                return TESOURA;
            default:
                throw new IllegalArgumentException("Gesto inválido: " + nome);
        }
    }

    public String getJogada() {
        return jogada;
    }

    public ArrayList<Gesto> getGanha() {
        return ganha;
    }

    public ArrayList<Gesto> getPerde() {
        return perde;
    }
}
