public class Tabuleiro {

    
    int tabuleiro1[][]=new int [5][5];

    public void mostrar() {
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
                    System.out.print("-----  -----  -----  -----");
                    System.out.println();
                    System.out.print("\n");

        }
            
    }
}