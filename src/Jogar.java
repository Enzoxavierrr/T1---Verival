package src;
public class Jogar {
    

    public Resultado ResultadoDoJogo(Mao jogador1, Mao jogador2){
        if(jogador1.gesto.ganha.contains(jogador2.gesto)){
            return Resultado.GANHADOR;
    }
        if(jogador1.gesto.perde.contains(jogador2.gesto)){
            return Resultado.PERDEDOR;
    }
        return Resultado.EMPATE;
    }
}
