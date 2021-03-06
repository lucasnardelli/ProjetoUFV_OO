import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try{
            int aux;
            List<Setor> setores = new ArrayList<>();
            List<Jogador> jogadores = new ArrayList<>();
            
            Scanner input = new Scanner(System.in);
            Menu menu = new Menu();
            Tabuleiro tabuleiro = new Tabuleiro();
            Setor setorAtual = new Setor(jogadores, setores, 20, 20, 50);


            tabuleiro.iniciarTabuleiro();
            tabuleiro.gerarCaminhoParaOrigemVirus(setores, jogadores);
            // for para os jogadores escolherem qual tipo de jogador eles vão ser
            for (int i = 1; i <= 2; i++) {
                if(jogadores.isEmpty()){ // se a lista estiver vazia o jogador pode escolher seu personagem
                    jogadores.add(menu.escolherPersonagem(i));
                } else {
                    if(jogadores.get(i-2).getATK() == 1){  // se o primeiro jogador escolher suporte o segundo player tem que ser simples
                        jogadores.add(new JogadorSimples());
                        System.out.print("Player " + i + " é um jogador simples, pois jogador 1 escolheu suporte:");
                    }else{
                        jogadores.add(menu.escolherPersonagem(i));
                    }
                } 
            }
            
            System.out.println("O jogo começou!");
            System.out.println("Vocês estão no meio do tabuleiro!");
            
    
            // while para o jogo continuar enquanto o ciclo não chegar em 25
            while (menu.getContCiclos() <= 25) {
                aux = 0;
                tabuleiro.mostrarTabuleiro(setores, jogadores);
                for (Jogador jog : jogadores) {
                    aux++;
                    
                    for (Setor setor : setores) {
                        if (jog.getLinha() == setor.getLinha() && jog.getColuna() == setor.getColuna()) {
                            setorAtual = setor;
                        }
                    }
                    if (setorAtual.getRecebeVirus().isEmpty()) {
                        jog.movimentar(setorAtual, setores, jog, jogadores, aux);
                        tabuleiro.mostrarTabuleiro(setores, jogadores);
                    }
                    if (jog.getLinha() == tabuleiro.getLinhaVirus() && jog.getColuna() == tabuleiro.getColunaVirus()) {
                        System.out.println("Parabens você ganhou o jogo!");
                        System.exit(0);
                    }
    
                }
                aux = 0;
                for (Jogador jog : jogadores) {
                    aux++;
                    for (Setor setor : setores) {
                        if (jog.getLinha() == setor.getLinha() && jog.getColuna() == setor.getColuna()) {
                            menu.escolherAcao(jogadores, jog, setor.getRecebeVirus(), aux, setor);
                        }
                    }
                }
                for (Setor setor : setores) {
                    for (Jogador jogador : jogadores) {
                        if (jogador.getColuna() == setor.getColuna() && jogador.getLinha() == setor.getLinha()) {
                            for (Virus virus : setor.getRecebeVirus()) {
                                virus.atacar(setor.getjogadoresPrincipal());
                            }
                        }
                        if (jogador.getColuna() == setor.getColuna() && jogador.getLinha() == setor.getLinha()) {
                            setor.mostraSetor();
                        }
                    }
                }
                aux = 0;
                int[] mat = new int[jogadores.size()];
                for (Jogador jog : jogadores) { // verifica se os jogadores estão vivos
                    if(jog.getDEF() <= 0){
                        mat[aux] = 1;
                    }
                    aux++;   
                }
                for(int i=0 ; i<jogadores.size() ; i++){
                    if(mat[i] == 1){
                        jogadores.remove(i);
                        System.out.println("O Player " + i+1 + " morreu!");
                    }
                }
    
                if (jogadores.isEmpty()) { // se os dois jogadores morrerem acaba o jogo
                    System.out.println("Os dois jogadores morreram!");
                    System.out.println("GAME OVER!");
                    System.exit(0); 
                }
            }
    
            System.out.println("Você atingiu o maximo de cliclos!");
            System.out.println("GAME OVER!");
            System.exit(0);
    
            input.close();
        } catch(AllException e){
            System.out.println("Erro: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Erro na entrada de dados!");
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            System.out.println("Erro inesperado: " + e);
        }        
    }
}