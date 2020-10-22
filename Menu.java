import java.util.Scanner;
import java.util.List;

public class Menu {
    Scanner input = new Scanner(System.in);


    public Jogador escolherPersonagem(int i){

            System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2)?");
            int escolha = input.nextInt();
            
            if(escolha == 1){
                return new JogadorSuporte();
            } else if(escolha == 2){
                return new JogadorSuporte();
            }                    
    }

    public void escolherAcao(List<Jogador> jogadores){
        int aux = 1;
        for(Jogador jog : jogadores){
            if(jog.getDEF() > 0){
                for(int i=1 ; i<3 ; i++){
                    if(jog.getATK() == 1){
                        System.out.println("Player " + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/p/r)?");
                        char escolha = input.next().charAt(0);
                        if(escolha == 'a'){
                            jog.atacar();
                        }else if(escolha == 'p'){
                            jog.procurar(jog);
                        }else if(escolha == 'r'){
                            jog.recuperarDEF(jogadores);
                        }
                    }                   
                }
            } else {
                jogadores.remove(jog);
                System.out.println("Jogador " + aux + " morreu!");
            }
            aux++;
        }
    }
}
