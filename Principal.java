import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {


    private static Object JogadorSimples;

    public static void main(String[] args) {
        int aux = 0;

        List<Jogador> jogadores = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        List<Setor> setores = new ArrayList<>();
        Menu menu = new Menu();
        Tabuleiro x = new Tabuleiro();
        Setor setorAtual = new Setor(jogadores, setores, 20, 20, 50);

        x.iniciarTabuleiro();
        x.gerarCaminhoParaOrigemVirus(setores, jogadores);
        // for para os jogadores escolherem qual tipo de jogador eles vão ser



            for (int i = 1; i <= 2; i++) {

                jogadores.add(menu.escolherPersonagem(i));
                if(jogadores.get(i)==JogadorSimples){
                    jogadores.add(menu.escolherPersonagem(i));
                }else {
                    System.out.println("Primeiro Jogador simples");
                    jogadores.clear();
                    i=i-1;
                }

                }






        x.mostrarTabuleiro(setores, jogadores);
        System.out.println("O jogo começou!");
        System.out.println("Vocês estão no meio do tabuleiro!");

        // while para o jogo continuar enquanto o ciclo não chegar em 25
        while (menu.getCont_Ciclos() <= 25) {
            aux = 0;
            for (Jogador jog : jogadores) {
                aux++;
                if (jog.getDEF() <= 0) {
                    jogadores.remove(jog);
                    System.out.println("Jogador" + aux + " morreu!");
                }
                for (Setor setor : setores) {
                    if (jog.getLinha() == setor.getLinha() && jog.getColuna() == setor.getColuna()) {
                        setorAtual = setor;
                    }
                }
                if (setorAtual.getRecebeVirus().isEmpty()) {
                    jog.movimentar(setorAtual, setores, jog, jogadores);
                    x.mostrarTabuleiro(setores, jogadores);
                }
                if (jog.getLinha() == x.getLocalLinha() && jog.getColuna() == x.getLocalColuna()) {
                    System.out.println("Parabens você ganhou o jogo!");
                    System.exit(0);
                }

            }
            aux = 0;
            for (Jogador jog : jogadores) {
                aux++;
                for (Setor setor : setores) {
                    if (jog.getLinha() == setor.getLinha() && jog.getColuna() == setor.getColuna()) {
                        menu.escolherAcao(jogadores, jog, setor.getRecebeVirus(), aux, setor);
                        setor.mostraSetor();
                    }
                }
            }
            for (Setor setor : setores) {
                for (Jogador jogador : jogadores) {
                    if (jogador.getColuna() == setor.getColuna() && jogador.getLinha() == setor.getLinha()) {
                        for (Virus virus : setor.getRecebeVirus()) {
                            virus.atacar(setor.getjogadoresPrincipal());
                        }
                    }
                }
            }

            if (jogadores.isEmpty())
                System.exit(0);

        }

        System.out.println("Você atingiu o maximo de cliclos!");
        System.out.println("GAME OVER!");

        input.close();
    }

}