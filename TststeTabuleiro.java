import java.util.Random;
public class TststeTabuleiro {
    int[][] mat = new int[5][5];
    Random gerador = new Random();
    
    public void  geraOrigemVirus(){
        int linha = gerador.nextInt(5)+1;
    }

}
