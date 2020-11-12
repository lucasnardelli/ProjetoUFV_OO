import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        List<Setor> setores = new ArrayList<>();
        Menu menu = new Menu();
        Tabuleiro x = new Tabuleiro();

        x.iniciarTabuleiro();
        x.gerarCaminhoParaOrigemVirus(setores, jogadores);
        // for para os jogadores escolherem qual tipo de jogador eles vão ser
        for (int i = 1; i <= 2; i++) {
            jogadores.add(menu.escolherPersonagem(i));
        }
        x.mostrarTabuleiro(setores, jogadores);
        System.out.println("O jogo começou!");
        System.out.println("Vocês estão no meio do tabuleiro!");

        // while para o jogo continuar enquanto o ciclo não chegar em 25
        while (menu.getCont_Ciclos() <= 25) {
            for (Jogador jog : jogadores) {
                for (Setor setor : setores) {
                    if(jog.getLinha() == setor.getLinha() && jog.getColuna() == setor.getColuna()){
                        jog.movimentar(setor, setores, jog, jogadores, menu); 
                    }                  
                } 
            }
        }

        input.close();
    }

}
