import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Setor extends Principal {
    private Boolean portaCima;
    private Boolean portaEsquerda;
    private Boolean portaBaixo;
    private Boolean portaDireita;
    private Boolean JogadorPassou;
    private int id, linha, coluna, tipoSetor;

    private List<Jogador> jogadoresNoSetor = new ArrayList<>();
    private List<Virus> listaDeVirus = new ArrayList<>();
    private Random gerador = new Random();
    private Virus virus = new Virus();

    public Setor(List<Jogador> jogadores, List<Setor> setores, int linha, int coluna, int id) {
        this.recebeVirus();
        this.coluna = coluna;
        this.linha = linha;
        this.id = id;
        this.setTipoSetor(gerador.nextInt(10));// 0-4 = setor normal / 5-7 = setor// privado / 8-9 = setor oculto
        for (Jogador jogador : jogadores) {
            if (jogador.getColuna() == this.coluna && jogador.getLinha() == this.linha) {
                jogadoresNoSetor.add(jogador);
            }
        }
        this.JogadorPassou = false;
        int verificaBaixo = 0, verificaCima = 0, verificaEsquerda = 0, verificaDireita = 0;
        if (id == 0) {
            this.id = 4;
            for (Setor setor : setores) {
                if (setor.getColuna() == this.getColuna() && setor.getLinha() == this.getLinha() + 1
                        && setor.getId() != 0) {
                    if (setor.getPortaCima() == true) {
                        verificaBaixo = 1;
                    } else {
                        verificaBaixo = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() && setor.getLinha() == this.getLinha() - 1
                        && setor.getId() != 0) {
                    if (setor.getPortaBaixo() == true) {
                        verificaCima = 1;
                    } else {
                        verificaCima = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() + 1 && setor.getLinha() == this.getLinha()
                        && setor.getId() != 0) {
                    if (setor.getPortaEsquerda() == true) {
                        verificaDireita = 1;
                    } else {
                        verificaDireita = 2;
                    }
                } else if (setor.getColuna() == this.getColuna() - 1 && setor.getLinha() == this.getLinha()
                        && setor.getId() != 0) {
                    if (setor.getPortaDireita() == true) {
                        verificaEsquerda = 1;
                    } else {
                        verificaEsquerda = 2;
                    }
                }
            }

            // gera portas aleatorias
            this.portaBaixo = this.gerarPortas(verificaBaixo);
            this.portaCima = this.gerarPortas(verificaCima);
            this.portaEsquerda = this.gerarPortas(verificaEsquerda);
            this.portaDireita = this.gerarPortas(verificaDireita);

            // Coloca parede se o setor estiver em alguma extremidade
            definirExtremidade();
        } else {
            this.portaBaixo = true;
            this.portaCima = true;
            this.portaEsquerda = true;
            this.portaDireita = true;

            // Coloca parede se o setor estiver em alguma extremidade
            this.definirExtremidade();
        }
        if (id == 1) {
            listaDeVirus.clear();
        }
    }

    public Boolean getPortaCima() {
        return this.portaCima;
    }

    public Boolean getPortaEsquerda() {
        return this.portaEsquerda;
    }

    public Boolean getPortaBaixo() {
        return this.portaBaixo;
    }

    public Boolean getPortaDireita() {
        return this.portaDireita;
    }

    public Boolean getJogadorPassou() {
        return this.JogadorPassou;
    }

    public void setJogadorPassou(Boolean jogadorPassou) {
        this.JogadorPassou = jogadorPassou;
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
        return this.jogadoresNoSetor;
    }

    public void setjogadoresPrincipal(List<Jogador> jogadoresPrincipais) {
        this.jogadoresNoSetor.clear();
        for (Jogador jogador : jogadoresPrincipais) {
            if (jogador.getColuna() == this.coluna && jogador.getLinha() == this.linha) {
                this.jogadoresNoSetor.add(jogador);
            } else {
                this.jogadoresNoSetor.remove(jogador);
            }
        }
    }

    public List<Virus> getRecebeVirus() {
        return this.listaDeVirus;
    }

    public void recebeVirus() {
        listaDeVirus = virus.geradorDeVirus(linha, coluna);// adiciona todos os virus
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
            if (i == 7 && this.getPortaCima() == true) {
                System.out.print("**");
            }
            System.out.print("--");
        }
        System.out.println();
        System.out.print("|" + listaDeVirus.toString());

        //
        for (int i = 0; i < 5 - listaDeVirus.size(); i++) {
            // Sempre que alterar um carcter no Virus.toString alterar os espaços aqui
            if (listaDeVirus.isEmpty()) {
                System.out.print("    ");
            } else {
                System.out.print("     ");
            }
        }
        if (listaDeVirus.isEmpty()) {
            System.out.print("        |");
        } else {
            System.out.print("     |");
        }

        for (int i = 0; i < 4; i++) {
            System.out.println();
            if (i == 2) {
                if (this.getPortaEsquerda() == true && this.getPortaDireita() == true)
                    System.out.print("*                              *\n");
                else if (this.getPortaEsquerda() == true)
                    System.out.print("*                              |\n");
                else if (this.getPortaDireita() == true)
                    System.out.print("|                              *\n");

            }
            System.out.print("|                              |");
        }
        System.out.println();
        System.out.print("|" + jogadoresNoSetor.toString());

        //
        for (int i = 0; i < 5 - jogadoresNoSetor.size(); i++) {
            // Sempre que alterar um carcter no Virus.toString alterar os espaços aqui
            System.out.print("     ");
        }
        System.out.print("     |");

        System.out.println();
        for (int i = 0; i < 15; i++) {
            if (i == 7 && this.getPortaBaixo() == true) {
                System.out.print("**");
            }
            System.out.print("--");
        }
        System.out.println();
    }

    public Boolean verificaSetorNormal() {
        if (this.tipoSetor < 5) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaSetorPrivado() {
        if (this.tipoSetor > 4 && this.tipoSetor < 8) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaSetorOculto() {
        if (this.tipoSetor >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean gerarPortas(int verificador) {
        if (verificador == 1) {
            return true;
        } else if (verificador == 2) {
            return false;
        } else {
            int random = gerador.nextInt(3);
            if (random == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void definirExtremidade(){
        if(this.linha == 0 ){
            this.portaCima = false;
        } else if(this.linha == 4){
            this.portaBaixo = false;
        }
        if (this.coluna == 0) {
            this.portaEsquerda = false;
        } else if(this.coluna == 4){
            this.portaDireita = false;
        }
    }

}