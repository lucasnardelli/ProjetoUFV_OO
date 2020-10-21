import java.util.Scanner;

public class Jogador {

    private int  ATK;
    private int  DEF;

    Scanner input = new Scanner(System.in);

    public Jogador(int ATK, int DEF) {
        this.ATK = ATK;
        this.DEF = DEF;
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

    @Override
    public String toString() {
        return "{" +
            " ATK='" + getATK() + "'" +
            ", DEF='" + getDEF() + "'" +
            "}";
    }

}
