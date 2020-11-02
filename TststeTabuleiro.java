import java.util.Random;

public class TststeTabuleiro {
    public int[][] mat = new int[5][5];

    public void caminho_virus() {
        Random gerador = new Random();
        int local_linha;
        int local_coluna;
        int coluna_cont = 2;
        
        do {
            mat[2][2] = 99;
            local_linha = gerador.nextInt(4);
            local_coluna = gerador.nextInt(4);
            mat[local_linha][local_coluna] = 80;
            for (int i = 0; i < 5; i++) {
                for (int c = 0; c < 5; c++) {
                    if (i == 0 || c == 0 || i == 4 || c == 4) {
                        // mat[i][c]=mat[i][c]*-1;//logica real
                        // mat[i][c]=mat[i][c]=-1;
                    }
                    System.out.print("\t" + mat[i][c]);
                }
                System.out.println();
            }
        } while (mat[2][2] == 80);

        do {
            if (local_coluna < 2) {
                mat[local_linha][coluna_cont] = 4;
                coluna_cont--;

            } else if (local_coluna > 2) {
                mat[local_linha][coluna_cont] = 4;
                coluna_cont++;
            }
        } while (coluna_cont != local_coluna);

    }
}
