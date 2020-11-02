import java.util.Random;

public class TststeTabuleiro {
    public int[][] mat = new int[5][5];

    public void caminho_virus() {
        Random gerador = new Random();
        int local_linha;
        int local_coluna;
        int coluna_cont = 2;
        mat_1();
        do {
            mat[2][2] = 99;
            local_linha = 2;/*gerador.nextInt(4);*/
            local_coluna = 0;/*gerador.nextInt(4);*/
            mat[local_linha][local_coluna] = 80;

        } while (mat[2][2] == 80);
//caminho do virus
        do {
            if (local_coluna < 2) {
                if(local_linha != 2){
                    mat[local_linha][coluna_cont] = 4;
                    coluna_cont--;
                } else {
                    if(mat[local_linha][coluna_cont] != 99){
                        mat[local_linha][coluna_cont] = 4;
                        coluna_cont--;
                    }                    
                }

            } else if (local_coluna > 2) {
                if(local_linha != 2){
                    mat[local_linha][coluna_cont] = 4;
                    coluna_cont++;
                } else if(mat[local_linha][coluna_cont] != 99) {
                    mat[local_linha][coluna_cont] = 4;
                    coluna_cont++;
                }
            }
        } while (coluna_cont != local_coluna);

        extremidade();
        mostrarTabuleiro();
    }

    public void mat_1() {
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                mat[i][c] = 1;
            }
        }
    }

    public void extremidade() {
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                if (i == 0 || c == 0 || i == 4 || c == 4) {

                    mat[i][c] = mat[i][c] * -1;//logica real
                }
            }
        }
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                System.out.print("\t" + mat[i][c]);
            }
            System.out.println();
        }
    }

}
