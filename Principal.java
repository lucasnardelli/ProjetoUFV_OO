import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
       
        Tabuleiro x=new Tabuleiro();
        x.mostrar();        
        Scanner input = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();
        
        // for para os jogadores escolherem qual tipo de jogador eles vão ser
        for(int i = 1; i<=2 ; i++){
            System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2)?");
            int escolha = input.nextInt();
            if(escolha == 1){
                new JogadorSuporte();
            } else if(escolha == 2){
                new JogadorSimples();
            }            
        }

        System.out.println("Vocês estão no meio do tabuleiro");
        for(Jogador jog : jogadores){
            while(jog.getDEF() != 0 /*&& colocar quando ciclo chegar a 25 acabar*/){
                
            }
        }
    }
}
