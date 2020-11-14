import java.util.List;
import java.util.Random;

public class Tabuleiro {
    private Random gerador = new Random();
    private char [][] tabuleiro = new char[11][21];
    private int[][] mat = new int[5][5];
    private Setor setorOrigem, setorCentro, setor;
    private int local_linha;
    private int local_coluna;
    
    public Tabuleiro (){}

    public int getLocalLinha (){
        return local_linha;
    }

    public int getLocalColuna (){
        return local_coluna;
    }

    public void gerarCaminhoParaOrigemVirus(List<Setor> tabuleiro, List<Jogador> jogadores){
        
        int coluna_cont = 2;
        
        do {
            mat[2][2] = 1; //1 significa que é o centro
            local_linha = gerador.nextInt(5);
            setorCentro = new Setor(jogadores, tabuleiro, 2, 2, 1);
            local_coluna = gerador.nextInt(5);
            mat[local_linha][local_coluna] = 2; // 2 significa que é a origem do virus
            setorOrigem = new Setor(jogadores, tabuleiro, local_linha, local_coluna, 2);

        } while (mat[2][2] == 2);
        //(j-2) % 4 == 0 && i%2 !=0
        this.tabuleiro[(local_linha*2)+1][(local_coluna*4)+2] = 'X';
        tabuleiro.add(setorCentro);
        tabuleiro.add(setorOrigem);
        //abre um caminho ate a origem do virus, para que seja possivel ganhar o jogo
        do {
            if (local_coluna < 2) {
                if(local_coluna != 2 && local_linha != 2){
                    setor = new Setor(jogadores, tabuleiro, local_linha, coluna_cont, 3);
                    tabuleiro.add(setor); 
                }
                coluna_cont--;
            } else if (local_coluna > 2) {
                if(local_coluna != 2 && local_linha != 2){
                    setor = new Setor(jogadores, tabuleiro, local_linha, coluna_cont, 3);
                    tabuleiro.add(setor); 
                }  
                coluna_cont++;
            }
        } while (coluna_cont != local_coluna);
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
                        int aux = 0;
                        int verifica[] = new int[2];
                        for (Jogador jogador : jogadores) {
                            if(jogador.getLinha() == linha && jogador.getColuna() == coluna){
                                if(linha == 2 && coluna ==2){
                                    tabuleiro[linha*2 + 1][coluna*4 + 2]='C';
                                }else if(jogador.getLinha() == local_linha && jogador.getColuna() == local_coluna){
                                    tabuleiro[linha*2 + 1][coluna*4 + 2]='X';                                    
                                }else{
                                    verifica[aux] = 1;
                                }
                            }else{
                                    tabuleiro[linha*2 + 1][coluna*4 + 2]=' ';
                                    tabuleiro[linha*2 + 1][coluna*4 + 3]=' ';
                            }
                            aux++;
                        }
                        if(verifica[0] == 1 && verifica[1] == 1){
                            tabuleiro[linha*2 + 1][coluna*4 + 2]='P';
                            tabuleiro[linha*2 + 1][coluna*4 + 3]=' ';
                        }else if(verifica[0] == 1){
                            tabuleiro[linha*2 + 1][coluna*4 + 2]='P';
                            tabuleiro[linha*2 + 1][coluna*4 + 3]='1';
                        } else if(verifica[1] == 1){
                            tabuleiro[linha*2 + 1][coluna*4 + 2]='P';
                            tabuleiro[linha*2 + 1][coluna*4 + 3]='2';
                        }
                        tabuleiro[2*2 +1][2*4 + 2]='C';
                        tabuleiro[local_linha* 2 + 1][local_coluna*4 +2]='X';
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
