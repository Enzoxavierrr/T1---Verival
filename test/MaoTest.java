package test;

import src.Gesto;
import src.Mao;

public class MaoTest {
    
    public static void main(String[] args) {
        System.out.println("=== Executando testes para a classe Mao ===");
        
        testConstrutorComGestoValido();
        testConstrutorComGestoNull();
        testGetGesto();
        testMaoComDiferentesGestos();
        
        System.out.println("=== Todos os testes da classe Mao passaram! ===\n");
    }
    
    public static void testConstrutorComGestoValido() {
        System.out.println("Testando construtor com gesto válido...");
        
        Mao maoPedra = new Mao(Gesto.PEDRA);
        assert maoPedra != null : "Mao não deve ser null";
        assert maoPedra.getGesto() == Gesto.PEDRA : "Gesto deve ser PEDRA";
        
        Mao maoPapel = new Mao(Gesto.PAPEL);
        assert maoPapel.getGesto() == Gesto.PAPEL : "Gesto deve ser PAPEL";
        
        Mao maoTesoura = new Mao(Gesto.TESOURA);
        assert maoTesoura.getGesto() == Gesto.TESOURA : "Gesto deve ser TESOURA";
        
        System.out.println("✓ Construtor com gesto válido funciona corretamente");
    }
    
    public static void testConstrutorComGestoNull() {
        System.out.println("Testando construtor com gesto null...");
        
        try {
            Mao mao = new Mao(null);
            assert mao.getGesto() == null : "Se aceita null, getGesto deve retornar null";
            System.out.println("✓ Construtor aceita gesto null (comportamento permitido)");
        } catch (Exception e) {
            System.out.println("✓ Construtor rejeita gesto null (comportamento defensivo)");
        }
    }
    
    public static void testGetGesto() {
        System.out.println("Testando método getGesto...");
        
        Mao mao = new Mao(Gesto.PEDRA);
        Gesto gesto = mao.getGesto();
        
        assert gesto != null : "getGesto não deve retornar null para gesto válido";
        assert gesto == Gesto.PEDRA : "getGesto deve retornar o mesmo gesto passado no construtor";
        assert "pedra".equals(gesto.getJogada()) : "Gesto retornado deve ter jogada 'pedra'";
        
        System.out.println("✓ Método getGesto funciona corretamente");
    }
    
    public static void testMaoComDiferentesGestos() {
        System.out.println("Testando Mao com diferentes gestos...");
        
        Mao maoPedra = new Mao(Gesto.PEDRA);
        Mao maoPapel = new Mao(Gesto.PAPEL);
        Mao maoTesoura = new Mao(Gesto.TESOURA);
        
        assert !maoPedra.getGesto().equals(maoPapel.getGesto()) : "Mãos com gestos diferentes devem ter gestos diferentes";
        assert !maoPapel.getGesto().equals(maoTesoura.getGesto()) : "Mãos com gestos diferentes devem ter gestos diferentes";
        assert !maoTesoura.getGesto().equals(maoPedra.getGesto()) : "Mãos com gestos diferentes devem ter gestos diferentes";
        
        Mao outraMaoPedra = new Mao(Gesto.PEDRA);
        assert maoPedra.getGesto() == outraMaoPedra.getGesto() : "Mãos com mesmo gesto devem referenciar o mesmo objeto Gesto";
        
        System.out.println("✓ Mao funciona corretamente com diferentes gestos");
    }
}