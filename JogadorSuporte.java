import java.util.Scanner;
import java.util.List;

public class JogadorSuporte extends Jogador{
    
    Scanner teclado = new Scanner(System.in);
    
    public JogadorSuporte(){
        super(1, 7);
    } 

    @Override
    public void recuperarDEF( List<Jogador> jogadores ){
        System.out.print("Você deseja recuperar a defesa de qual jogador(1 ou 2)?");
        int jogador = teclado.nextInt();
        if(jogador == 1){
            jogadores.get(jogador-1).setDEF((getDEF()+2));
            System.out.println("Defesa do jogador " + jogador + " recuperada com sucesso!");
        } 
        else if(jogador == 2){
            jogadores.get(jogador-1).setDEF((getDEF()+2));
            System.out.println("Defesa do jogador " + jogador + " recuperada com sucesso!");
        }
    }
}
