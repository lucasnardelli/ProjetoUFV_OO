import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
            
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Tabuleiro x = new Tabuleiro();

        List<Jogador> jogadores = new ArrayList<>();
        Placar y =new Placar(jogadores);
        y.mostraPlacar();
       // x.mostrar();

        // for para os jogadores escolherem qual tipo de jogador eles vão ser
        for(int i = 1; i<=2 ; i++){
            jogadores.add(menu.escolherPersonagem(i));
        }
        Placar oPlacar=new Placar(jogadores);

        System.out.println("O jogo começou!");
        System.out.println("Vocês estão no meio do tabuleiro!");
        //while(colocar quando ciclo chegar a 25 acabar*/){
        menu.escolherAcao(jogadores);    
        //}

    }


}
