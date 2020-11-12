import java.util.Scanner;
import java.util.List;
import java.util.Random;

public abstract class Jogador {

    private int ATK, DEF, linha, coluna;

    Scanner input = new Scanner(System.in);

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
    public void movimentar(Setor setor, List<Setor> setores, Jogador jogador, List<Jogador> jogadores, Menu menu) {
        Setor setorNovo;
        int criaNovoSetor = 0;
        // menu.escolherAcao(jogadores, setorNovo.getRecebeVirus());
        System.out.println("Você deseja ir para: ");
        if (setor.getCima() == true) {
            System.out.println("Cima(c)");
        }
        if (setor.getDireita() == true) {
            System.out.println("Direita(d)");
        }
        if (setor.getEsquerda() == true) {
            System.out.println("Esquerda(e)");
        }
        if (setor.getBaixo() == true) {
            System.out.println("Baixo(b)");
        }
        char direcao = input.next().charAt(0);
        if (direcao == 'c') {
            for (Setor seto : setores) {
                if (seto.getColuna() == setor.getColuna() - 1 && seto.getLinha() == setor.getLinha()
                        && seto.getId() != 0) {
                    jogador.setColuna(jogador.getColuna() - 1);
                    setor.setjogadoresPrincipal(jogadores);
                    setor.mostraSetor();
                    menu.escolherAcao(jogadores, seto.getRecebeVirus());
                    criaNovoSetor = 1;
                }
            }
            if (criaNovoSetor == 0) {
                jogador.setColuna(jogador.getColuna() - 1);
                setor.setjogadoresPrincipal(jogadores);
                setorNovo = new Setor(jogadores, setor.getLinha(), setor.getColuna() - 1, 0);
                setores.add(setorNovo);
                setor.mostraSetor();
                menu.escolherAcao(jogadores, setorNovo.getRecebeVirus());
            }
        } else if (direcao == 'd') {
            for (Setor seto : setores) {
                setorNovo = new Setor(jogadores, setor.getLinha() + 1, setor.getColuna(), 0);
                if (seto.getColuna() == setor.getColuna() && seto.getLinha() == setor.getLinha() + 1
                        && seto.getId() == 0) {
                    jogador.setLinha(jogador.getLinha() + 1);
                    setor.setjogadoresPrincipal(jogadores);
                    setores.add(setorNovo);
                    menu.escolherAcao(jogadores, setorNovo.getRecebeVirus());
                } else if (seto.getId() != 0) {
                    jogador.setLinha(jogador.getLinha() + 1);
                    setor.setjogadoresPrincipal(jogadores);
                    menu.escolherAcao(jogadores, seto.getRecebeVirus());
                }
            }

            // return new Setor(jogadores, setor.getLinha() + 1, setor.getColuna());
        } else if (direcao == 'e') {
            // return new Setor(jogadores, setor.getLinha() - 1, setor.getColuna());
        } else {
            new Setor(jogadores, setor.getLinha(), setor.getColuna() + 1, 7);
        }
    }

    // metodo para o jogador escolher qual inimigo ele ira atacar
    public void atacar(List<Virus> virus) {
        System.out.print("Qual inimigo você deseja atacar?");
        int inimigo = input.nextInt();
        virus.get(inimigo - 1).setDEF(getDEF() - this.ATK);
        if (virus.get(inimigo - 1).getDEF() <= 0) {
            virus.remove(inimigo - 1);
        }
        System.out.println("Inimigo atacado com sucesso!");
    }

    // metodo para o jogador procurar no setor que ele esta
    public void procurar(Jogador jogador) {
        Random gerador = new Random();

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
        return "{" + " ATK='" + getATK() + "'" + ", DEF='" + getDEF() + "'" + "}";
    }

}
