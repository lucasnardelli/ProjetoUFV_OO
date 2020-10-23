import java.util.ArrayList;
import java.util.List;
public class Placar extends Principal {
    private Boolean cima;
    private Boolean esquerda;
    private Boolean baixo;
    private Boolean direita;

    List<Jogador> jogadoresPrincipal = new ArrayList<>();
    List<Virus> recebeVirus = new ArrayList<>();

    public Placar(List<Jogador> jogadores){
        this.jogadoresPrincipal = jogadores;
    }

    public Boolean getCima() {
        return this.cima;
    }

    public void setCima(Boolean cima) {
        this.cima = cima;
    }

    public Boolean getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(Boolean esquerda) {
        this.esquerda = esquerda;
    }

    public Boolean getBaixo() {
        return this.baixo;
    }

    public void setBaixo(Boolean baixo) {
        this.baixo = baixo;
    }

    public Boolean getDireita() {
        return this.direita;
    }

    public void setDireita(Boolean direita) {
        this.direita = direita;
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