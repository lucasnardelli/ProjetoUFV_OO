import java.util.Scanner;
import java.util.List;
import java.util.Random;

public abstract class Jogador  {

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
        int criarNovoSetor = 0;
        System.out.println(direcoesPossiveis(setor));
        char direcao = input.next().charAt(0);//pega a letra do usuario
        if (direcao == 'c' && setor.getPortaCima()) {
            for (Setor setorAtual : setores) {
                if (setorAtual.getColuna() == setor.getColuna() && setorAtual.getLinha() == setor.getLinha() - 1
                        && setorAtual.getId() != 0) {
                    movimentarJogador(jogador, jogadores, setorAtual, setor, jogador.getLinha() - 1,
                            jogador.getColuna());
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                criarNovoSetor(setor, setores, jogadores, jogador, setor.getLinha() - 1, setor.getColuna());
            }
        } else if (direcao == 'd' && setor.getPortaDireita()) {
            for (Setor setorAtual : setores) {
                if (setorAtual.getColuna() == setor.getColuna() + 1 && setorAtual.getLinha() == setor.getLinha()
                        && setorAtual.getId() != 0) {
                    movimentarJogador(jogador, jogadores, setorAtual, setor, jogador.getLinha(),
                            jogador.getColuna() + 1);
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                criarNovoSetor(setor, setores, jogadores, jogador, setor.getLinha(), setor.getColuna() + 1);
            }
        } else if (direcao == 'e' && setor.getPortaEsquerda()) {
            for (Setor setorAtual : setores) {
                if (setorAtual.getColuna() == setor.getColuna() - 1 && setorAtual.getLinha() == setor.getLinha()
                        && setorAtual.getId() != 0) {
                    movimentarJogador(jogador, jogadores, setorAtual, setor, jogador.getLinha(),
                            jogador.getColuna() - 1);
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                criarNovoSetor(setor, setores, jogadores, jogador, setor.getLinha(), setor.getColuna() - 1);
            }
        } else if (direcao == 'b' && setor.getPortaBaixo()) {
            for (Setor setorAtual : setores) {
                if (setorAtual.getColuna() == setor.getColuna() && setorAtual.getLinha() == setor.getLinha() + 1
                        && setorAtual.getId() != 0) {
                    movimentarJogador(jogador, jogadores, setorAtual, setor, jogador.getLinha() + 1,
                            jogador.getColuna());
                    criarNovoSetor = 1;
                }
            }
            if (criarNovoSetor == 0) {
                criarNovoSetor(setor, setores, jogadores, jogador, setor.getLinha() + 1, setor.getColuna());
            }
        } else {
            throw new AllException("Valor invalido");//caso o jogador errar o comando
        }
    }

    // metodo para o jogador escolher qual inimigo ele vai atacar
    public void atacar(List<Virus> virus, Setor setor) {
        System.out.print("Qual inimigo você deseja atacar?");
        int inimigo = input.nextInt();
        if (inimigo > virus.size()) {
            throw new AllException("Esse virus não existe");
        }
        if (setor.verificaSetorOculto()) {
            if (gerador.nextInt(3) != 0) {
                System.out.println("Inimigo atacado com sucesso!");
                virus.get(inimigo - 1).setDEF(virus.get(inimigo - 1).getDEF() - this.ATK);
                if (virus.get(inimigo - 1).getDEF() <= 0) {
                    virus.remove(inimigo - 1);
                    System.out.println("Inimigo Eliminado");
                }
            } else {
                System.out.println("virus nao encontrado ");
            }
        } else {
            System.out.println("Inimigo atacado com sucesso!");
            if (virus.get(inimigo - 1).getDEF() <= 0) {
                virus.remove(inimigo - 1);
                System.out.println("Inimigo eliminado");
            }
        }
    }

    // metodo para o jogador procurar no setor que ele está
    public void procurar(Jogador jogador, List<Virus> virus) {
        // variavel para armazenar um valor aleatorio de 1 a 6
        int valor = gerador.nextInt(6) + 1;
        int[] mat = new int[5];
        int aux = 0;
        // verificando se o jogador vai encontrar alguma coisa no setor
        if (valor <= 3) {
            System.out.println("Você não encontrou nada");
        } else if (valor == 4) {
            jogador.setDEF(getDEF() + 1);
            System.out.println("Parabens, sua defesa foi aumentada em 1");
        } else if (valor == 5) {
            jogador.setDEF(getDEF() + 2);
            System.out.println("Parabens, sua defesa foi aumentada em 2");
        } else {
            for (Virus vir : virus) {
                // tirar 1 de DEF dos inimigos do setor
                vir.setDEF(vir.getDEF() - 1);
                if (vir.getDEF() <= 0) {
                    mat[aux] = 1;
                }
                aux++;
            }
            for (int i = 0; i < 5; i++) {
                if (mat[i] == 1) {
                    virus.remove(i);
                }
            }
            System.out.println("Parabens, cada inimigo perdeu 1 de defesa");
        }
    }

    public Boolean verificaJogadorSuporte() {
        if (this.ATK == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaJogadorSimples() {
        if (this.ATK == 2) {
            return true;
        } else {
            return false;
        }
    }

    public void criarNovoSetor(Setor setor, List<Setor> setores, List<Jogador> jogadores, Jogador jogador, int linha,
            int coluna) {
        Setor setorNovo;
        jogador.setLinha(linha);
        jogador.setColuna(coluna);
        setor.setjogadoresPrincipal(jogadores);
        setorNovo = new Setor(jogadores, setores, linha, coluna, 0);
        setorNovo.setJogadorPassou(true);
        setores.add(setorNovo);
        setorNovo.mostraSetor();
    }

    public void movimentarJogador(Jogador jogador, List<Jogador> jogadores, Setor setorAtual, Setor setorPassado,
            int linha, int coluna) {
        jogador.setLinha(linha);
        jogador.setColuna(coluna);
        setorPassado.setjogadoresPrincipal(jogadores);
        setorAtual.setjogadoresPrincipal(jogadores);
        setorAtual.mostraSetor();
    }

    public String direcoesPossiveis(Setor setor) {
        String str = "Você deseja ir para: ";
        if (setor.getPortaCima()) {//retorna true
            str = str.concat(" Cima(c)");
        }
        if (setor.getPortaDireita()) {//retorna true
            str = str.concat(" Direita(d)");
        }
        if (setor.getPortaEsquerda()) {//retorna true
            str = str.concat(" Esquerda(e)");
        }
        if (setor.getPortaBaixo()) {//retorna true
            str = str.concat(" Baixo(b)");
        }
        str = str.concat(" ?");//so pra colocar a interrogaçao
        return str;
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