import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private int cima;
    private int esquerda;
    private int baixo;
    private int direita;

    
    int tabuleiro1[][]=new int [5][5];
    public void mostrar() {
        for(int l=0;l<5;l++){
            for(int c=0;c<5;c++){
                tabuleiro1[l][c]=0;
                if( tabuleiro1[l][c]==0){
                    System.out.print("____\n");
                    System.out.print("|      |\n|      |" +
                            "\n ____");

                }
            }
            System.out.println();

        }        
    }
}

