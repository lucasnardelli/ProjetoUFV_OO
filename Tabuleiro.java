public class Tabuleiro {

    
    char tabuleiro1[][]=new char [5][5];

  /*  public void mostrar() {
        for(int l=0;l<5;l++){
            for(int c=0;c<5;c++){
                tabuleiro1[l][c]=1;

            }
        }
        for(int l=0;l<5;l++){

                    System.out.print("_____  _____  _____  _____");
                    System.out.println();
                    System.out.print("|   |  |   |  |   |  |   |");
                    System.out.println();

                    System.out.println("|   |  |   |  |   |  |   |");
                   // System.out.print("-----  -----  -----  -----");
                  //  System.out.println();
                  //  System.out.println();
        }
    }
*/
    public void mostrar(){



        for (int l=0;l<11;l++){

            for (int c=0;c<5;c++){

            if (c!=5&&l%2==0){

                System.out.print("|");

            }
            if(l%2==0){

                System.out.print("---");
                if(c==4){
                    System.out.print("|");
                }
            }else {
                System.out.print("|  \t");
                if(c==4){
                    System.out.print("|");
                }
            }
            }
            System.out.println();
        }
    }



}
