import java.util.ArrayList;
import java.util.List;
public class Placar extends Principal{

    List<Jogador> jogadoresPrincipal = new ArrayList<>();
    List<Virus> recebeVirus = new ArrayList<>();

    public Placar(List<Jogador> jogadores){
        this.jogadoresPrincipal = jogadores;
    }

    public List<Jogador> getjogadoresPrincipal() {
        return this.jogadoresPrincipal;
    }

    public void setjogadoresPrincipal(List<Jogador> jogadoresPrincipal) {
        this.jogadoresPrincipal = jogadoresPrincipal;
    }

    public List<Virus> getRecebeVirus() {
        return this.recebeVirus;
    }

    public void setRecebeVirus(List<Virus> recebeVirus) {
        this.recebeVirus = recebeVirus;
    }

    public void tipoJogador(){
        for (Jogador tipoJogador:jogadoresPrincipal) {
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