import java.util.Scanner;


public class JogadorSuporte extends Jogador{
    
    Scanner teclado = new Scanner(System.in);
    
    public JogadorSuporte(){
        super(1, 7);
    }
    


    public void recuperarDEF(){
        System.out.print("Você deseja recuperar a defesa de qual jogador(1 ou 2)?");
        int jogador = teclado.nextInt();
        if(jogador == 1){

        } 
        else if(jogador == 2){

        }

    }
}
