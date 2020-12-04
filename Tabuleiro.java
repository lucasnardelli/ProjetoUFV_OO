import java.util.List;
import java.util.Random;

public class Tabuleiro {
    private Random gerador = new Random();
    private char[][] tabuleiro = new char[11][21];
    private int[][] mat = new int[5][5];
    private Setor setorOrigem, setorCentro, setor;
    private int linhaVirus;
    private int colunaVirus;

    public Tabuleiro() {
    }

    public int getLinhaVirus() {
        return linhaVirus;
    }

    public int getColunaVirus() {
        return colunaVirus;
    }

    public void gerarCaminhoParaOrigemVirus(List<Setor> tabuleiro, List<Jogador> jogadores) {

        int coluna_cont = 2;

        do {
            mat[2][2] = 1; // 1 significa que é o centro
            linhaVirus = gerador.nextInt(5);
            setorCentro = new Setor(jogadores, tabuleiro, 2, 2, 1);
            colunaVirus = gerador.nextInt(5);
            mat[linhaVirus][colunaVirus] = 2; // 2 significa que é a origem do virus
            setorOrigem = new Setor(jogadores, tabuleiro, linhaVirus, colunaVirus, 2);

        } while (mat[2][2] == 2);
        // (j-2) % 4 == 0 && i%2 !=0
        this.tabuleiro[(linhaVirus * 2) + 1][(colunaVirus * 4) + 2] = 'X';
        setorCentro.setJogadorPassou(true);
        tabuleiro.add(setorCentro);
        tabuleiro.add(setorOrigem);
        // abre um caminho ate a origem do virus, para que seja possivel ganhar o jogo
        do {
            if (colunaVirus < 2) {
                if (colunaVirus != 2 && linhaVirus != 2) {
                    setor = new Setor(jogadores, tabuleiro, linhaVirus, coluna_cont, 3);
                    tabuleiro.add(setor);
                }
                coluna_cont--;
            } else if (colunaVirus > 2) {
                if (colunaVirus != 2 && linhaVirus != 2) {
                    setor = new Setor(jogadores, tabuleiro, linhaVirus, coluna_cont, 3);
                    tabuleiro.add(setor);
                }
                coluna_cont++;
            }
        } while (coluna_cont != colunaVirus);
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
        for (Setor seto : setores) {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 21; j++) {
                    if ((j - 2) % 4 == 0 && i % 2 != 0) { // coluna
                        int linha = i / 2;
                        int coluna = (j - 2) / 4;
                        if (seto.getLinha() == linha && seto.getColuna() == coluna) {
                            if (seto.getPortaCima() == true && seto.getJogadorPassou() == true) {
                                tabuleiro[i - 1][j] = '*';
                            }
                            if (seto.getPortaDireita() == true && seto.getJogadorPassou() == true) {
                                tabuleiro[i][j + 2] = '*';
                            }
                            if (seto.getPortaBaixo() == true && seto.getJogadorPassou() == true) {
                                tabuleiro[i + 1][j] = '*';
                            }
                            if (seto.getPortaEsquerda() == true && seto.getJogadorPassou() == true) {
                                tabuleiro[i][j - 2] = '*';
                            }
                        }
                        int aux = 0;
                        int verifica[] = new int[2];
                        for (Jogador jogador : jogadores) {
                            if (jogador.getLinha() == linha && jogador.getColuna() == coluna) {
                                if (linha == 2 && coluna == 2) {
                                    tabuleiro[linha * 2 + 1][coluna * 4 + 2] = 'C';
                                }  else {
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