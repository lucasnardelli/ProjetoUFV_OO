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
    public int getATK() {
        return ATK;
    }
    public void setATK(int temp_atk_def) {
        this.ATK = temp_atk_def;
    }
    public int getDEF() {
        return DEF;
    }
    public void setDEF(int temp_atk_def) {
        this.DEF = temp_atk_def;
    }
    public Virus() {
        Virus tempVirus=new Virus();
        do{
            ovirus.add(tempVirus);
            tamanho_vet--;
        }while (tamanho_vet>0);
    }
}





