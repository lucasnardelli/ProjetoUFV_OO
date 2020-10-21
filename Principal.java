import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int aux = 0;
        Tabuleiro x=new Tabuleiro();
        x.mostrar();        
        Scanner input = new Scanner(System.in);
        
        List<Jogador> jogadores = new ArrayList<>();
        
        // for para os jogadores escolherem qual tipo de jogador eles vão ser
        for(int i = 1; i<=2 ; i++){
            System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2)?");
            int escolha = input.nextInt();
            if(escolha == 1){
                jogadores.add(new JogadorSuporte());
            } else if(escolha == 2){
                jogadores.add(new JogadorSuporte());
            }            
        }

        System.out.println("Vocês estão no meio do tabuleiro");
        //while(colocar quando ciclo chegar a 25 acabar*/){
            for(Jogador jog : jogadores){
                aux ++;
                if(jog.getDEF() > 0){
                    for(int i=1 ; i<3 ; i++){
                        if(jog.getATK() == 1){
                            System.out.println("Player " + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/p/r)?");
                            char escolha = input.next().charAt(0);
                            if(escolha == 'a'){
                                jog.atacar();
                            }else if(escolha == 'p'){
                                jog.procurar();
                            }else if(escolha == 'r'){
                                jog.recuperarDEF();
                            }
                        }                   
                    }
                } else {
                    jogadores.remove(jog);
                }
            }
            aux = 0;
        //}
    }
}
