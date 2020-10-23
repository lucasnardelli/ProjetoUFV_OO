import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Jogador {

    private int  ATK;
    private int  DEF;

    Scanner input = new Scanner(System.in);

    // construtor para definir o ataque e a defesa do jogador
    public Jogador(int ATK, int DEF) {
        this.ATK = ATK;
        this.DEF = DEF;
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

    // metodo usado para o jogador escolher a direção que quer se movimentar
    public void movimentar(Placar placar){
        System.out.println("Você deseja ir para cima, direita, baixo ou esquerda? (c/d/b/e)");
        char direcao = input.next().charAt(0);
        if(direcao == 'c'){
            placar.setCima(true);
            System.out.println("Você foi para cima!");
        }else if(direcao == 'd'){
            placar.setDireita(true);
            System.out.println("Você foi para direita!");
        }else if(direcao == 'b'){
            placar.setBaixo(true);
            System.out.println("Você foi para baixo!");
        }else if(direcao == 'e'){
            placar.setEsquerda(true);
            System.out.println("Você foi para esquerda!");
        }
    }

    // metodo para o jogador escolher qual inimigo ele ira atacar
    public void atacar(List<Virus> virus){
        System.out.print("Qual inimigo você deseja atacar?");
        int inimigo = input.nextInt();
        virus.get(inimigo - 1).setDEF(getDEF() - this.ATK);
        if(virus.get(inimigo - 1).getDEF() <= 0){
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
        if(valor >= 1 && valor <= 3){
            System.out.println("Você não encontrou nada");
        }else if(valor == 4){
            jogador.setDEF(getDEF()+1);
            System.out.println("Parabens, sua defesa foi aumentada em 1");
        }else if(valor == 5){
            jogador.setDEF(getDEF()+2);
            System.out.println("Parabens, sua defesa foi aumentada em 2");
        }else if(valor == 6){
            // tirar 1 de DEF dos inimigos do setor
            System.out.println("Parabens, cada inimigo perdeu 1 de defesa");
        }
    }

    // Declaração do metodo de recuperar defesa para o jogador suporte poder ter acesso
    public void recuperarDEF(List<Jogador> jogadores){}

    @Override
    public String toString() {
        return "{" +
            " ATK='" + getATK() + "'" +
            ", DEF='" + getDEF() + "'" +
            "}";
    }

}
