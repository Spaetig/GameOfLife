import java.util.Scanner;

public class Main {

    private static int Dimension;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Setze die grösse des Felders:");
        Dimension = Integer.valueOf(scanner.next());

        boolean[][] World = initWorld();

        System.out.println("Startkonstellation");

        ShowWorld(World);
        for (int i=1; i<=100; i++){
            World = UseRules(World);
            System.out.println("Generation "+i);
            ShowWorld(World);}
    }

    public static boolean[][] UseRules(boolean[][] World){

        for (int i = 0; i < Dimension; i++){
            for (int j = 0; j < Dimension; j++){
                World[i][j] = Math.random() > 0.4;
            }
        }

        return World;
    }

    public static void ShowWorld(boolean[][] World) {


        for (int i = 0; i < Dimension; i++){
            String Line = "";

            for (int j = 0; j < Dimension; j++){
                if (World[i][j]){
                    Line += "1\t";
                }
                else {
                    Line += "0\t";

                }
            }

            System.out.println(Line);
        }
    }

    public static boolean[][] initWorld() {
        boolean[][] World = new boolean[Dimension][Dimension];

        for (int i = 0; i < Dimension; i++){
            for (int j = 0; j < Dimension; j++){
                World[i][j] = Math.random() > 0.4;
            }
        }

        return World;
    }

}
