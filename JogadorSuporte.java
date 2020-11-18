import java.util.Scanner;
import java.util.List;

public class JogadorSuporte extends Jogador {

    private Scanner input = new Scanner(System.in);

    public JogadorSuporte() {// construtor para jogador suporte iniciar com atk = 1e def =7
        super(1, 7);//super para classe Jogador
    }

    // metodo sobrescrito para escolher de quem ira recuperar a defesa
    @Override
    public void recuperarDEF(List<Jogador> jogadores) {
        System.out.print("Você deseja recuperar a defesa de qual jogador(1 ou 2)?");
        int jogador = input.nextInt();

        //jogador-1 vetor[0]==jogador1
        jogadores.get(jogador - 1).setDEF((jogadores.get(jogador - 1).getDEF() + 2)); //adicionando +2 de DEF para o jogar selecionado
        System.out.println("Defesa do jogador " + jogador + " recuperada com sucesso!");
    }
}