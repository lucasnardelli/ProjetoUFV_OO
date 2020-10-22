import java.util.ArrayList;
import java.util.List;
public class Placar extends Principal{

    List<Jogador> jogadores_principal=new ArrayList<>();
    Virus virusPlacar=new Virus();

    public Placar(List<Jogador>jogadores) {
        this.jogadores_principal=jogadores;

    }
    public void tipoJogador(){
        for (Jogador tipoJogador:jogadores_principal) {

            if(tipoJogador.getATK()==1)
            {
                //jogador suporte
            }
          else
            {
                //jogador Simples

            }
        }
    }
}