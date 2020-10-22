import java.util.ArrayList;
import java.util.List;
public class Placar extends Principal {

    List<Jogador> jogadores_principal = new ArrayList<>();
    ArrayList<Virus> recebeVirus = new ArrayList<>();


    public Placar(List<Jogador> jogadores) {
        this.jogadores_principal = jogadores;

    }

    public void tipoJogador() {
        for (Jogador tipoJogador : jogadores_principal) {
            if (tipoJogador.getATK() == 1) {
                //jogador suporte
            } else {
                //jogador Simples
            }

        }
    }


    public void mostraPlacar()
    {
        for (int i=0;i<1;i++ ) {
            System.out.println();
            System.out.print("____________________");
            for (int c=0;c<6;c++)
            {
                System.out.println();
                System.out.print("|                  |");


            }

            System.out.println();
            System.out.print("--------------------");
        }

    }

}