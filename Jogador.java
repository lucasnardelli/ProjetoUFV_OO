import java.util.Scanner;
import java.util.List;
import java.util.Random;

public abstract class Jogador {

    private int ATK, DEF, linha, coluna;

    private Scanner input = new Scanner(System.in);
    private Random gerador = new Random();

    // construtor para definir o ataque e a defesa do jogador
    public Jogador(int ATK, int DEF) {
        this.ATK = ATK;
        this.DEF = DEF;
        this.linha = 2;
        this.coluna = 2;
    }

    public int getATK() {
        return this.ATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getLinha() {
        return this.linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    // metodo usado para o jogador escolher a direção que quer se movimentar
    public void movimentar(Setor setor, List<Setor> setores, Jogador jogador, List<Jogador> jogadores) {
        Setor setorNovo;
        int criarNovoSetor = 0;
        // menu.escolherAcao(jogadores, setorNovo.getRecebeVirus());
        System.out.println("Você deseja ir para: ");
        if (setor.getPortaCima() == true) {
            System.out.println("Cima(c)");
        }
        if (setor.getPortaDireita() == true) {
            System.out.println("Direita(d)");
        }
        if (setor.getPortaEsquerda() == true) {
            System.out.println("Esquerda(e)");
        }
        if (setor.getPortaBaixo() == true) {
            System.out.println("Baixo(b)");
        }
        char direcao = input.next().charAt(0);
        if (direcao == 'c' && setor.getPortaCima() == true) {
            for (Setor seto : setores) {
                if (seto.getColuna() == setor.getColuna() && seto.getLinha() == setor.getLinha() - 1
                        && seto.getId() != 0) {
                    jogador.setLinha(jogador.getLinha() - 1);
                    setor.setjogadoresPrincipal(jogadores);
                    seto.setjogadoresPrincipal(jogadores);
                    seto.mostraSetor();
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                jogador.setLinha(jogador.getLinha() - 1);
                setor.setjogadoresPrincipal(jogadores);
                setorNovo = new Setor(jogadores, setores, setor.getLinha() - 1, setor.getColuna(), 0);
                setores.add(setorNovo);
                setorNovo.mostraSetor();
            }
        } else if (direcao == 'd' && setor.getPortaDireita() == true) {
            for (Setor seto : setores) {
                if (seto.getColuna() == setor.getColuna() + 1 && seto.getLinha() == setor.getLinha()
                        && seto.getId() != 0) {
                    jogador.setColuna(jogador.getColuna() + 1);
                    setor.setjogadoresPrincipal(jogadores);
                    seto.setjogadoresPrincipal(jogadores);
                    seto.mostraSetor();
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                jogador.setColuna(jogador.getColuna() + 1);
                setor.setjogadoresPrincipal(jogadores);
                setorNovo = new Setor(jogadores, setores, setor.getLinha(), setor.getColuna() + 1, 0);
                setores.add(setorNovo);
                setorNovo.mostraSetor();
            }
        } else if (direcao == 'e' && setor.getPortaEsquerda() == true) {
            for (Setor seto : setores) {
                if (seto.getColuna() == setor.getColuna() - 1 && seto.getLinha() == setor.getLinha()
                        && seto.getId() != 0) {
                    jogador.setColuna(jogador.getColuna() - 1);
                    setor.setjogadoresPrincipal(jogadores);
                    seto.setjogadoresPrincipal(jogadores);
                    seto.mostraSetor();
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                jogador.setColuna(jogador.getColuna() - 1);
                setor.setjogadoresPrincipal(jogadores);
                setorNovo = new Setor(jogadores, setores, setor.getLinha(), setor.getColuna() - 1, 0);
                setores.add(setorNovo);
                setorNovo.mostraSetor();
            }
        } else if (direcao == 'b' && setor.getPortaBaixo() == true) {
            for (Setor seto : setores) {
                if (seto.getColuna() == setor.getColuna() && seto.getLinha() == setor.getLinha() + 1
                        && seto.getId() != 0) {
                    jogador.setLinha(jogador.getLinha() + 1);
                    setor.setjogadoresPrincipal(jogadores);
                    seto.setjogadoresPrincipal(jogadores);
                    seto.mostraSetor();
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                jogador.setLinha(jogador.getLinha() + 1);
                setor.setjogadoresPrincipal(jogadores);
                setorNovo = new Setor(jogadores, setores, setor.getLinha() + 1, setor.getColuna(), 0);
                setores.add(setorNovo);
                setorNovo.mostraSetor();
            }
        } else {
            System.out.println("Valor invalido");
            System.exit(0);
        }
    }

    // metodo para o jogador escolher qual inimigo ele ira atacar
    public void atacar(List<Virus> virus, Setor setor) {
        System.out.print("Qual inimigo você deseja atacar?");
        int inimigo = input.nextInt();
        if (setor.getTipoSetor() < 5) { // setor normal
            virus.get(inimigo - 1).setDEF(virus.get(inimigo - 1).getDEF() - this.ATK);
            if (virus.get(inimigo - 1).getDEF() <= 0) {
                virus.remove(inimigo - 1);
                System.out.println("Inimigo eliminado");
            }
            System.out.println("Inimigo atacado com sucesso!");
        } else if (setor.getTipoSetor() == 8 || setor.getTipoSetor() == 9) { // setor oculto
            if (gerador.nextInt(4) != 0) {
                virus.get(inimigo - 1).setDEF(virus.get(inimigo - 1).getDEF() - this.ATK);
                if (virus.get(inimigo - 1).getDEF() <= 0) {
                    virus.remove(inimigo - 1);
                    System.out.println("Inimigo Eliminado");
                }
                System.out.println("Inimigo atacado com sucesso!");
            } else {
                System.out.println("virus nao encontrado ");
            }
        } else {
            virus.get(inimigo - 1).setDEF(virus.get(inimigo - 1).getDEF() - this.ATK);
            if (virus.get(inimigo - 1).getDEF() <= 0) {
                virus.remove(inimigo - 1);
                System.out.println("Inimigo eliminado");
            }
            System.out.println("Inimigo atacado com sucesso!");
        }
    }

    // metodo para o jogador procurar no setor que ele esta
    public void procurar(Jogador jogador) {
        // variavel para armazenar um valor aleatorio de 1 a 6
        int valor = gerador.nextInt(5) + 1;
        // verificando se o jogador vai encontrar alguma coisa no setor
        if (valor >= 1 && valor <= 3) {
            System.out.println("Você não encontrou nada");
        } else if (valor == 4) {
            jogador.setDEF(getDEF() + 1);
            System.out.println("Parabens, sua defesa foi aumentada em 1");
        } else if (valor == 5) {
            jogador.setDEF(getDEF() + 2);
            System.out.println("Parabens, sua defesa foi aumentada em 2");
        } else if (valor == 6) {
            // tirar 1 de DEF dos inimigos do setor
            System.out.println("Parabens, cada inimigo perdeu 1 de defesa");
        }
    }

    // Declaração do metodo de recuperar defesa para o jogador suporte poder ter
    // acesso
    public void recuperarDEF(List<Jogador> jogadores) {
    }

    @Override
    public String toString() {
        return getATK() + "/" + getDEF();
    }

}