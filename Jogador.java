import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Jogador {

    private int  ATK;
    private int  DEF;
    private int cont_Jogadas;

    Scanner input = new Scanner(System.in);

    public Jogador(int ATK, int DEF) {
        this.ATK = ATK;
        this.DEF = DEF;
    }

    public int getCont_Jogadas() {
        return cont_Jogadas;
    }

    public void setCont_Jogadas(int cont_Jogadas) {
        this.cont_Jogadas = cont_Jogadas;
    }

    public int getATK() {
        return this.ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void movimentar(){
        
    }
  
    public void atacar(){
        System.out.print("Qual inimigo você deseja atacar?");
        int inimigo = input.nextInt();

    }

    public void procurar(Jogador jogador) {
        Random gerador = new Random();
        int valor = gerador.nextInt(5) + 1;

        if(valor >= 1 && valor <= 3){
            System.out.println("Você não encontrou nada");
        }else if(valor == 4){
            jogador.setDEF(getDEF()+1);
        }else if(valor == 5){
            jogador.setDEF(getDEF()+2);
        }else if(valor == 6){
            // tirar 1 de DEF dos inimigos do setor
        }
    }

    public void recuperarDEF(List<Jogador> jogadores){

    }

    @Override
    public String toString() {
        return "{" +
            " ATK='" + getATK() + "'" +
            ", DEF='" + getDEF() + "'" +
            "}";
    }

}
