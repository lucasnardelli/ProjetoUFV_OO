import java.util.List;
import java.util.Random;

public class Tabuleiro {
    Random gerador = new Random();
    //List<Setor> tabuleiro = new ArrayList<>();
    //List<Jogador> jogadores = new ArrayList<>();
    public char [][] tabuleiro = new char[11][21];
    public int[][] mat = new int[5][5];
    Setor setorOrigem, setorCentro, setor;

    public Tabuleiro (){
        
    }

    public void gerarCaminhoParaOrigemVirus(List<Setor> tabuleiro, List<Jogador> jogadores){
        int local_linha;
        int local_coluna;
        int coluna_cont = 2;
        
        do {
            mat[2][2] = 1; //1 significa que é o centro
            local_linha = gerador.nextInt(5);
            setorCentro = new Setor(jogadores, 2, 2, 1);
            local_coluna = gerador.nextInt(5);
            mat[local_linha][local_coluna] = 2; // 2 significa que é a origem do virus
            setorOrigem = new Setor(jogadores, local_linha, local_coluna, 2);

        } while (mat[2][2] == 2);
        //(j-2) % 4 == 0 && i%2 !=0
        this.tabuleiro[(local_linha*2)+1][(local_coluna*4)+2] = 'X';
        tabuleiro.add(setorCentro);
        tabuleiro.add(setorOrigem);
        //abre um caminho ate a origem do virus, para que seja possivel ganhar o jogo
        do {
            if (local_coluna < 2) {
                if(local_coluna != 2 && local_linha != 2){
                    setor = new Setor(jogadores, local_linha, coluna_cont, 3);
                    tabuleiro.add(setor); 
                }  

                mat[local_linha][coluna_cont] = 3; // significa que todos os lados desse setor serão abertos
                coluna_cont--;
            } else if (local_coluna > 2) {
                if(local_coluna != 2 && local_linha != 2){
                    setor = new Setor(jogadores, local_linha, coluna_cont, 3);
                    tabuleiro.add(setor); 
                }  
                        
                mat[local_linha][coluna_cont] = 3; // significa que todos os lados desse setor serão abertos
                coluna_cont++;
            }
            mat[2][2] = 1;
        } while (coluna_cont != local_coluna);
        
        mostrarTabuleiroInt();
    }

    public void iniciarTabuleiro(){
        String str = "|---|---|---|---|---|";
        String str2 = "|   |   |   |   |   |";
        for(int i=0 ; i<11; i++){
            if(i%2 == 0){
                tabuleiro[i] = str.toCharArray();
            }else{
                tabuleiro[i] = str2.toCharArray();
            }
        }
        str = "|   |   | C |   |   |";
        tabuleiro[5] = str.toCharArray();
    }
/*
    |---|---|---|---|---|
    |   |   |   |   |   |
    |---|---|---|---|---|
    |   |   |   |   |   |
    |---|---|---|---|---|
    |   |   |   |   |   |
    |---|---|---|---|---|
    |   |   |   |   |   |
    |---|---|---|---|---|
    |   |   |   |   |   |
    |---|---|---|---|---|
*/
    private void mostrarTabuleiroInt() {
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                System.out.print("\t" + mat[i][c]);
            }
            System.out.println();
        }
    }
   
    public void mostrarTabuleiro(List<Setor> setores, List<Jogador> jogadores) {
        for(Setor set : setores){
            for(int i=0 ; i<11 ; i++){
                for(int j=0 ; j<21 ; j++){
                    if((j-2) % 4 == 0 && i%2 !=0){  // coluna
                        int linha = i/2;
                        int coluna = (j-2) / 4;
                        if(set.getLinha() == linha && set.getColuna() == coluna){
                            if(set.getCima() == true){
                                tabuleiro[i-1][j] = '*';
                            }
                            if(set.getDireita() == true){
                                tabuleiro[i][j+2] = '*';
                            }
                            if(set.getBaixo() == true){
                                tabuleiro[i+1][j] = '*';
                            }
                            if(set.getEsquerda() == true){
                                tabuleiro[i][j-2] = '*';
                            }
                        }                        
                    }
                }
            }
        }
        for(int i=0 ; i<11 ; i++){
            for(int j=0 ; j<21 ; j++){
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println("");
        }

}
}
