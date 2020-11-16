import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Setor extends Principal {
    private Boolean cima;
    private Boolean esquerda;
    private Boolean baixo;
    private Boolean direita;
    private int id, linha, coluna, tipoSetor;

    private List<Jogador> jogadoresPrincipal = new ArrayList<>();
    private List<Virus> recebeoVirus = new ArrayList<>();
    private Random gerador = new Random();
    private Virus x = new Virus();

    public Setor(List<Jogador> jogadores, List<Setor> setores, int linha, int coluna, int id) {
        recebeVirus();
        this.coluna = coluna;
        this.linha = linha;
        this.id = id;
        this.setTipoSetor(8);
        // this.setTipoSetor(gerador.nextInt(10)); // 0-4 = setor normal / 5-7 = setor
        // privado / 8-9 = setor oculto
        for (Jogador jogador : jogadores) {
            if (jogador.getColuna() == this.coluna && jogador.getLinha() == this.linha) {
                jogadoresPrincipal.add(jogador);
            }
        }
        int verificaBaixo = 0, verificaCima = 0, verificaEsquerda = 0, verificaDireita = 0;
        if (id == 0) {
            this.id = 4;
            for (Setor setor : setores) {
                if (setor.getColuna() == this.getColuna() && setor.getLinha() == this.getLinha() + 1
                        && setor.getId() != 0) {
                    if (setor.getCima() == true) {
                        verificaBaixo = 1;
                    } else {
                        verificaBaixo = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() && setor.getLinha() == this.getLinha() - 1
                        && setor.getId() != 0) {
                    if (setor.getBaixo() == true) {
                        verificaCima = 1;
                    } else {
                        verificaCima = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() + 1 && setor.getLinha() == this.getLinha()
                        && setor.getId() != 0) {
                    if (setor.getEsquerda() == true) {
                        verificaDireita = 1;
                    } else {
                        verificaDireita = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() - 1 && setor.getLinha() == this.getLinha()
                        && setor.getId() != 0) {
                    if (setor.getDireita() == true) {
                        verificaEsquerda = 1;
                    } else {
                        verificaEsquerda = 2;
                    }
                }
            }
            // gera portas aleatorias

            if (verificaBaixo == 1) {
                this.baixo = true;
            } else if (verificaBaixo == 2) {
                this.baixo = false;
            } else {
                int random = gerador.nextInt(3);
                if (random == 0) {
                    this.baixo = false;
                } else {
                    this.baixo = true;
                }
            }

            if (verificaCima == 1) {
                this.cima = true;
            } else if (verificaCima == 2) {
                this.cima = false;
            } else {
                int random = gerador.nextInt(3);
                if (random == 0) {
                    this.cima = false;
                } else {
                    this.cima = true;
                }
            }

            if (verificaDireita == 1) {
                this.direita = true;
            } else if (verificaDireita == 2) {
                this.direita = false;
            } else {
                int random = gerador.nextInt(3);
                if (random == 0) {
                    this.direita = false;
                } else {
                    this.direita = true;
                }
            }

            if (verificaEsquerda == 1) {
                this.esquerda = true;
            } else if (verificaEsquerda == 2) {
                this.esquerda = false;
            } else {
                int random = gerador.nextInt(3);
                if (random == 0) {
                    this.esquerda = false;
                } else {
                    this.esquerda = true;
                }
            }

            // Coloca parede se o setor estiver em alguma extremidade
            if (this.coluna == 0) {
                this.esquerda = false;
            }
            if (this.linha == 0) {
                this.cima = false;
            }
            if (this.coluna == 4) {
                this.direita = false;
            }
            if (this.linha == 4) {
                this.baixo = false;
            }
        } else if (id != 0) {
            this.baixo = true;
            this.cima = true;
            this.esquerda = true;
            this.direita = true;

            // Coloca parede se o setor estiver em alguma extremidade
            if (this.coluna == 0) {
                this.esquerda = false;
            }
            if (this.linha == 0) {
                this.cima = false;
            }
            if (this.coluna == 4) {
                this.direita = false;
            }
            if (this.linha == 4) {
                this.baixo = false;
            }
        }
        if (id == 1) {
            recebeoVirus.clear();
        }
    }

    public Boolean getCima() {
        return this.cima;
    }

    public Boolean getEsquerda() {
        return this.esquerda;
    }

    public Boolean getBaixo() {
        return this.baixo;
    }

    public Boolean getDireita() {
        return this.direita;
    }

    public int getId() {
        return this.id;
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public int getTipoSetor() {
        return this.tipoSetor;
    }

    public void setTipoSetor(int tipoSetor) {
        this.tipoSetor = tipoSetor;
    }

    public List<Jogador> getjogadoresPrincipal() {
        return this.jogadoresPrincipal;
    }

    public void setjogadoresPrincipal(List<Jogador> jogadoresPrincipais) {
        this.jogadoresPrincipal.clear();
        for (Jogador jogador : jogadoresPrincipais) {
            if (jogador.getColuna() == this.coluna && jogador.getLinha() == this.linha) {
                this.jogadoresPrincipal.add(jogador);
            } else {
                this.jogadoresPrincipal.remove(jogador);
            }
        }
    }

    public List<Virus> getRecebeVirus() {
        return this.recebeoVirus;
    }

    public void recebeVirus() {
        recebeoVirus = x.geradorDeVirus(linha, coluna);// adiciona todos os virus
    }

    public void mostraSetor() {
        System.out.print("Setor [" + linha + "," + coluna + "]   -   ");
        if (this.getTipoSetor() < 5) {
            System.out.print("Setor normal");
        } else if (this.getTipoSetor() == 5 || this.getTipoSetor() == 6 || this.getTipoSetor() == 7) {
            System.out.print("Setor privado");
        } else if (this.getTipoSetor() == 8 || this.getTipoSetor() == 9) {
            System.out.print("Setor oculto");
        }

        System.out.println();
        for (int i = 0; i < 15; i++) {
            if (i == 7 && this.getCima() == true) {
                System.out.print("**");
            }
            System.out.print("--");
        }
        System.out.println();
        System.out.print("|" + recebeoVirus.toString());

        //
        for (int i = 0; i < 5 - recebeoVirus.size(); i++) {
            // Sempre que alterar um carcter no Virus.toString alterar os espaços aqui
            System.out.print("     ");
        }
        System.out.print("     |");

        for (int i = 0; i < 4; i++) {
            System.out.println();
            if (i == 2) {
                if (this.getEsquerda() == true && this.getDireita() == true)
                    System.out.print("*                              *\n");
                else if (this.getEsquerda() == true)
                    System.out.print("*                              |\n");
                else if (this.getDireita() == true)
                    System.out.print("|                              *\n");

            }
            System.out.print("|                              |");
        }
        System.out.println();
        System.out.print("|" + jogadoresPrincipal.toString());

        //
        for (int i = 0; i < 5 - jogadoresPrincipal.size(); i++) {
            // Sempre que alterar um carcter no Virus.toString alterar os espaços aqui
            System.out.print("     ");
        }
        System.out.print("     |");

        System.out.println();
        for (int i = 0; i < 15; i++) {
            if (i == 7 && this.getBaixo() == true) {
                System.out.print("**");
            }
            System.out.print("--");
        }
        System.out.println();
    }
}