import java.util.Random;

public class TststeTabuleiro
{
   public int[][] mat=new int [5][5];
    public void caminho_virus() {
        Random linha = new Random();
        Random coluna = new Random();
    do {
        mat[linha.nextInt(4)][coluna.nextInt(4)] = 80;
        mat[2][2] = 99;
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                if(i==0||c==0||i==4||c==4){
                  //  mat[i][c]=mat[i][c]*-1;//logica real
                     mat[i][c]=mat[i][c]=-1;
                }
                System.out.print("\t" + mat[i][c]);
            }
            System.out.println();
        }
    }while (mat[2][2]==80);
    }
}
