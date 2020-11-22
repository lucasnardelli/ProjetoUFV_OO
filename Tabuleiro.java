import java.util.List;
import java.util.Random;

public class Tabuleiro {
    private Random gerador = new Random();
    private char[][] tabuleiro = new char[11][21];
    private int[][] mat = new int[5][5];
    private Setor setorOrigem, setorCentro, setor;
    private int linhaLocal;
    private int colunaLocal;


    public Tabuleiro() {
    }

    public int getLinhaLocal() {
        return linhaLocal;
    }

    public int getColunaLocal() {
        return colunaLocal;
    }

    public void gerarCaminhoParaOrigemVirus(List<Setor> tabuleiro, List<Jogador> jogadores) {

        int colunaCont = 2;

        do {
            mat[2][2] = 1; // 1 significa que é o centro
            linhaLocal = gerador.nextInt(5);
            setorCentro = new Setor(jogadores, tabuleiro, 2, 2, 1);
            colunaLocal = gerador.nextInt(5);
            mat[linhaLocal][colunaLocal] = 2; // 2 significa que é a origem do virus
            setorOrigem = new Setor(jogadores, tabuleiro, linhaLocal, colunaLocal, 2);

        } while (mat[2][2] == 2);
        // (j-2) % 4 == 0 && i%2 !=0
        this.tabuleiro[(linhaLocal * 2) + 1][(colunaLocal * 4) + 2] = 'X';
        setorCentro.setJogadorPassou(true);
        tabuleiro.add(setorCentro);
        tabuleiro.add(setorOrigem);
        // abre um caminho ate a origem do virus, para que seja possivel ganhar o jogo
        do {
            if (colunaLocal < 2) {
                if (linhaLocal != 2) {
                    setor = new Setor(jogadores, tabuleiro, linhaLocal, colunaCont, 3);
                    tabuleiro.add(setor);
                }
                colunaCont--;
            } else if (colunaLocal > 2) {
                if (linhaLocal != 2) {
                    setor = new Setor(jogadores, tabuleiro, linhaLocal, colunaCont, 3);
                    tabuleiro.add(setor);
                }
                colunaCont++;
            }
        } while (colunaCont != colunaLocal);
    }

    public void iniciarTabuleiro() {
        String str = "|---|---|---|---|---|";
        String str2 = "|   |   |   |   |   |";
        for (int i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                tabuleiro[i] = str.toCharArray();
            } else {
                tabuleiro[i] = str2.toCharArray();
            }
        }
        str = "|   |   | C |   |   |";
        tabuleiro[5] = str.toCharArray();
    }

    public void mostrarTabuleiro(List<Setor> setores, List<Jogador> jogadores) {
        int aux = 0;
        int verifica[] = new int[2];
        for (Setor set : setores) {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 21; j++) {
                    if ((j - 2) % 4 == 0 && i % 2 != 0) { // coluna
                        int linha = i / 2;
                        int coluna = (j - 2) / 4;
                        if (set.getLinha() == linha && set.getColuna() == coluna) {
                            if (set.getPortaCima() && set.getJogadorPassou()) {//retorna true
                                tabuleiro[i - 1][j] = '*';
                            }
                            if (set.getPortaDireita() && set.getJogadorPassou()) {//retorna true
                                tabuleiro[i][j + 2] = '*';
                            }
                            if (set.getPortaBaixo() && set.getJogadorPassou()) {//retorna true
                                tabuleiro[i + 1][j] = '*';
                            }
                            if (set.getPortaEsquerda() && set.getJogadorPassou()) {//retorna true
                                tabuleiro[i][j - 2] = '*';
                            }
                        }

                        for (Jogador jogador : jogadores) {
                            if (jogador.getLinha() == linha && jogador.getColuna() == coluna) {
                                if (linha == 2 && coluna == 2) {
                                    tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'C';
                                } else if (jogador.getLinha() == linhaLocal && jogador.getColuna() == colunaLocal) {
                                    tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'X';
                                } else {
                                    verifica[aux] = 1;
                                }
                            } else {
                                tabuleiro[linha * 2 + 1][coluna * 4 + 2] = ' ';
                                tabuleiro[linha * 2 + 1][coluna * 4 + 3] = ' ';
                            }
                            aux++;
                        }
                        if (verifica[0] == 1 && verifica[1] == 1) {
                            tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'P';
                            tabuleiro[linha * 2 + 1][coluna * 4 + 3] = ' ';
                        } else if (verifica[0] == 1) {
                            tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'P';
                            tabuleiro[linha * 2 + 1][coluna * 4 + 3] = '1';
                        } else if (verifica[1] == 1) {
                            tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'P';
                            tabuleiro[linha * 2 + 1][coluna * 4 + 3] = '2';
                        }
                        tabuleiro[2 * 2 + 1][2 * 4 + 2] = 'C';
                        tabuleiro[linhaLocal * 2 + 1][colunaLocal * 4 + 2] = 'X';
                    }
                }
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println("");
        }
    }
}