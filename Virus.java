import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Virus {
    int ATK;
   int DEF;
    List<Virus>ovirus=new ArrayList<>();
    Random nvirus=new Random();
    Random ATK_DEF=new Random();
   int tamanho_vet=  nvirus.nextInt(5)+1;
   int temp_atk_def=ATK_DEF.nextInt(3)+1;
    Virus tempVirus=new Virus();
    public int getTemp_atk_def() {
        return temp_atk_def;
    }


    public Virus() {

        do{
            tempVirus.ATK=temp_atk_def;
             tempVirus.DEF=temp_atk_def;
            ovirus.add(tempVirus);

            tamanho_vet--;
            mostra_virus();
        }while (tamanho_vet>0);
    }

    public List<Virus> getOvirus() {
        return ovirus;
    }
    public Virus mostra_virus(){

        for (Virus vi: ovirus) {

            return vi;

        }
    }

}





