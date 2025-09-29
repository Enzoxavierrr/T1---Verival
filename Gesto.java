import java.util.List;

public class Gesto {
    String jogada;
    List<Gesto> ganha;
    List<Gesto> perde;

    
    public Gesto(String jogada, List<Gesto> ganha, List<Gesto> perde) {
        this.jogada = jogada;
        this.ganha = ganha;
        this.perde = perde;
    }

    public String getJogada() {
        return jogada;
    }

    public List<Gesto> getGanha() {
        return ganha;
    }

    public List<Gesto> getPerde() {
        return perde;
    }
}

