import java.util.ArrayList;
import java.util.List;
public class Placar extends Principal {

    List<Jogador> jogadoresPrincipal = new ArrayList<>();
    List<Virus> recebeoVirus = new ArrayList<>();
    Virus x=new Virus();

    public void recebeVirus()
    {
      recebeoVirus=x.geradorDeVirus();//adiciona todos os virus
    }



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
        return this.recebeoVirus;
    }

    public void setRecebeVirus(List<Virus> recebeVirus) {
        this.recebeoVirus = recebeVirus;
    }
   // public void calculo

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
        recebeVirus();

            System.out.println();
            System.out.println("________________________________________");
            System.out.print("|"+recebeoVirus.toString()+"|");

            for (int c=0;c<6;c++)
            {
                System.out.println();
                System.out.print("|                                    |");
            }

            System.out.println();
            System.out.print("----------------------------------------");


    }

}