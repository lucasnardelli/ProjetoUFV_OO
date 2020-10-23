import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Virus {


    private int ATK;
    private int DEF;
    
    Random gerador = new Random();
    int tamanho_vet =  gerador.nextInt(5)+1;//NUMERO DE VIRUS



    public int getATK(){
        return this.ATK;
    }
    public int getDEF(){
        return this.DEF;
    }
    public List<Virus> geradorDeVirus(){//RETORNA UMA LISTA

        List<Virus> virus = new ArrayList<>();//LISTA DE VIRUS TEMPORARIA
        
        do{
            Virus tempVirus = new Virus();

            tempVirus.ATK = gerador.nextInt(3)+1;//ATK ==DEF EM RANDOM
            tempVirus.DEF = tempVirus.ATK;//ATK ==DEF EM RANDOM
            virus.add(tempVirus);
    
            tamanho_vet--;            
        }while (tamanho_vet>0);//SO TERMINA QUANDO TODOS OS VIRUS SAO ADD

        return virus;//RETORNA LISTA DE VIRUS GERADOS

    }

    @Override
    public String toString() {
        return "V" +
                  ATK +
                "/" + DEF
                ;
    }
}