import java.util.Scanner;
import java.util.List;

public class Menu {
    
    Scanner input = new Scanner(System.in);
    // atributo para fazer a contagem de quantos ciclos ja ocorreram
    private int cont_Ciclos = 0;

    public int getCont_Ciclos() {
        return cont_Ciclos;
    }

    public void setCont_Jogadas(int cont_Jogadas) {
        this.cont_Ciclos = cont_Jogadas;
    }

    // metodo para o jogador escolher se vai ser suporte ou simples
    public Jogador escolherPersonagem(int i){
            System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2)?");
            int escolha = input.nextInt();
            
            if(escolha == 1){
                return new JogadorSuporte();
            } else {
                return new JogadorSimples();
            }                  
    }

    // metodo para o jogador escolher o que ira fazer naquele turno
    public void escolherAcao(List<Jogador> jogadores, List<Virus> virus){
        int aux = 1;
        for(Jogador jog : jogadores){
            // verifica se o jogador esta vivo
            if(jog.getDEF() > 0){
                for(int i=1 ; i<3 ; i++){
                    // verifica se o jogador é suporte
                    if(jog.getATK() == 1){
                        System.out.println("Player " + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/p/r)?");
                        char escolha = input.next().charAt(0);
                        if(escolha == 'a'){
                            jog.atacar(virus);
                        }else if(escolha == 'p'){
                            jog.procurar(jog);
                        }else if(escolha == 'r'){
                            jog.recuperarDEF(jogadores);
                        }
                    } else {
                        System.out.println("Player " + aux + " qual vai ser sua escolha: atacar ou procurar (a/p)?");
                        char escolha = input.next().charAt(0);
                        if(escolha == 'a'){
                            jog.atacar(virus);
                        }else if(escolha == 'p'){
                            jog.procurar(jog);
                        }
                    }                  
                }
            } else {
                jogadores.remove(jog);
                System.out.println("Jogador " + aux + " morreu!");
            }
            aux++;
        }
        cont_Ciclos++;
    }
}
