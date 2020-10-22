import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Virus {


    private int ATK;
    private int DEF;
    
    Random gerador = new Random();
    int tamanho_vet =  gerador.nextInt(5)+1;
    public int getATK(){
        return this.ATK;
    }
    public int getDEF(){
        return this.DEF;
    }
    public List<Virus> geradorDeVirus(){
        List<Virus> virus = new ArrayList<>();
        
        do{
            Virus tempVirus = new Virus();

            tempVirus.ATK = gerador.nextInt(3)+1;
            tempVirus.DEF = tempVirus.ATK;
            virus.add(tempVirus);
    
            tamanho_vet--;            
        }while (tamanho_vet>0);

        return virus;
    }
}