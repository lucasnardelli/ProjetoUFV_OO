import java.util.Scanner;
import java.util.List;

public class Menu {
    private Scanner input = new Scanner(System.in);
    // atributo para fazer a contagem de quantos ciclos ja ocorreram
    private int contCiclos = 0;

    public int getContCiclos() {
        return contCiclos;
    }
    // metodo para o jogador escolher se vai ser suporte ou simples
    public Jogador escolherPersonagem(int i){
        System.out.print("Player " + i + " você deseja ser suporte(1) ou simples(2):");

        int escolha = input.nextInt();
        if(escolha != 1 && escolha !=2 ){
            throw new AllException("Esse tipo de jogador não existe!");
        }
        if (escolha == 1) {// obedeçer a regra que jogador suporte vem depois de jogador Simples
            return new JogadorSuporte();
        } else {
            return new JogadorSimples();
        }
    }

    // metodo para o jogador escolher o que ira fazer naquele turno
    public void escolherAcao(List<Jogador> jogadores, Jogador jogador, List<Virus> virus, int aux, Setor setor)throws Exception {
        for (int i = 1; i < 3; i++) {
            setor.mostraSetor();
            // verifica se o jogador é suporte
            if (jogador.verificaJogadorSuporte()) {
                if (setor.verificaSetorPrivado()){
                    if(virus.isEmpty()){
                        System.out.println("Player" + aux + " você so pode recuperar defesa!");
                        jogador.recuperarDEF(jogadores);
                    }else{
                        System.out.println("Player" + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/r)?");
                        char escolha = input.next().charAt(0);
                        if (escolha == 'a') {
                            jogador.atacar(virus, setor);
                        } else if (escolha == 'r') {
                            jogador.recuperarDEF(jogadores);
                        } else {
                            throw new AllException("Essa ação não existe!");
                        }
                    }                    
                } else {
                    if(virus.isEmpty()){
                        System.out.println(
                            "Player" + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (p/r)?");
                        char escolha = input.next().charAt(0);
                        if (escolha == 'p') {
                            jogador.procurar(jogador, setor.getRecebeVirus());
                        } else if (escolha == 'r') {
                            jogador.recuperarDEF(jogadores);
                        }else {
                            throw new AllException("Essa ação não existe!");
                        }
                    }else {
                        System.out.println(
                            "Player" + aux + " qual vai ser sua escolha atacar, procurar ou recuperar (a/p/r)?");
                        char escolha = input.next().charAt(0);
                        if (escolha == 'a') {
                            jogador.atacar(virus, setor);
                        } else if (escolha == 'p') {
                            jogador.procurar(jogador, setor.getRecebeVirus());
                        } else if (escolha == 'r') {
                            jogador.recuperarDEF(jogadores);
                        }else {
                            throw new AllException("Valor invalido!");
                        }
                    }   
                }
            } else {
                if (setor.getTipoSetor() == 5 || setor.getTipoSetor() == 6 || setor.getTipoSetor() == 7) {
                    if(virus.isEmpty()){
                        System.out.println("Player" + aux + " você não tem mais escolha nesse setor");
                    } else{
                        System.out.println("Player" + aux + " qual vai ser sua escolha: atacar(a)?");
                        char escolha = input.next().charAt(0);
                        if (escolha == 'a') {
                            jogador.atacar(virus, setor);
                        }
                    }                   
                } else {
                    if(virus.isEmpty()){
                        System.out.println("Player" + aux + " você so pode procurar!");
                        jogador.procurar(jogador, setor.getRecebeVirus());
                    }else{
                        System.out.println("Player" + aux + " qual vai ser sua escolha: atacar ou procurar (a/p)?");
                        char escolha = input.next().charAt(0);
                        if (escolha == 'a') {
                            jogador.atacar(virus, setor);
                        } else if (escolha == 'p') {
                            jogador.procurar(jogador, setor.getRecebeVirus());
                        }else {
                            throw new AllException("Valor invalido!");
                        }
                    }
                }
            }
        }
        this.contCiclos++;
    }
}