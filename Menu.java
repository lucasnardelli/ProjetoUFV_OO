import java.util.Scanner;
import java.util.List;

public class Menu {

    private Scanner input = new Scanner(System.in);
    // atributo para fazer a contagem de quantos ciclos ja ocorreram
    private int cont_Ciclos = 0;

    public int getCont_Ciclos() {
        return cont_Ciclos;
    }

    // metodo para o jogador escolher se vai ser suporte ou simples
    public Jogador escolherPersonagem(int i) {
        System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2)?");
        int escolha = input.nextInt();

        if (escolha == 1) {
            return new JogadorSuporte();
        } else {
            return new JogadorSimples();
        }
    }

    // metodo para o jogador escolher o que ira fazer naquele turno
    public void escolherAcao(List<Jogador> jogadores, Jogador jogador, List<Virus> virus, int aux, Setor setor) {
        for (int i = 1; i < 3; i++) {
            // verifica se o jogador é suporte
            if (jogador.getATK() == 1) {
                if (setor.getTipoSetor() == 5 || setor.getTipoSetor() == 6 || setor.getTipoSetor() == 7) {
                    System.out.println("Player" + aux + " qual vai ser sua escolha atacar ou recuperar (a/r)?");
                    char escolha = input.next().charAt(0);
                    if (escolha == 'a') {
                        jogador.atacar(virus, setor);
                    } else if (escolha == 'r') {
                        jogador.recuperarDEF(jogadores);
                    }
                } else {
                    System.out.println(
                            "Player" + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/p/r)?");
                    char escolha = input.next().charAt(0);
                    if (escolha == 'a') {
                        jogador.atacar(virus, setor);
                    } else if (escolha == 'p') {
                        jogador.procurar(jogador);
                    } else if (escolha == 'r') {
                        jogador.recuperarDEF(jogadores);
                    }
                }

            } else {
                if (setor.getTipoSetor() == 5 || setor.getTipoSetor() == 6 || setor.getTipoSetor() == 7) {
                    System.out.println("Player" + aux + " qual vai ser sua escolha: atacar(a)?");
                    char escolha = input.next().charAt(0);
                    if (escolha == 'a') {
                        jogador.atacar(virus, setor);
                    }
                } else {
                    System.out.println("Player" + aux + " qual vai ser sua escolha: atacar ou procurar (a/p)?");
                    char escolha = input.next().charAt(0);
                    if (escolha == 'a') {
                        jogador.atacar(virus, setor);
                    } else if (escolha == 'p') {
                        jogador.procurar(jogador);
                    }
                }
            }
        }

        cont_Ciclos++;
    }
}