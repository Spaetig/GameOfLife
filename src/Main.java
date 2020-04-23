import java.util.Scanner;

public class Main {

    private static int Dimension = 8;
    private static boolean[][] World;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Setze die grösse des Felders:");
        //Dimension = Integer.valueOf(scanner.next());

        World = initWorld();

        System.out.println("Startkonstellation");

        ShowWorld();
        for (int i=1; i<=100; i++){
            UseRules();
            System.out.println("Generation "+i);
            ShowWorld();}
    }

    public static void UseRules(){

        for (int i = 1; i < Dimension + 1; i++){
            for (int j = 1; j < Dimension + 1; j++){
                SetCellState(i,j);
            }
        }
    }

    private static void SetCellState(int x, int y){

        int Neighbours = CountNeighbour(x,y);

        if (World[x][y]){
            if (Neighbours < 2 || Neighbours > 3){
                World[x][y] = false;
            }
        }
        else {
            if (Neighbours == 3){
                World[x][y] = true;
            }
        }
    }

    public static int CountNeighbour(int x, int y) {
        int ret = 0;

        try {

            for (int i = x - 1; i <= x + 1; ++i)
                for (int j = y - 1; j <= y + 1; ++j)
                    if (World[i][j]) ret += 1;
            // einen Nachbarn zuviel mitgezählt?

            if (World[x][y]) ret -= 1;
        }
        catch (Exception e){
        }
        return ret;
    }

    public static void ShowWorld() {

        for (int i = 1; i < Dimension + 1; i++){
            String Line = "";

            for (int j = 1; j < Dimension + 1; j++){
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
        boolean[][] World = new boolean[Dimension + 2][Dimension + 2];

        for (int i = 1; i < Dimension + 1; i++){
            for (int j = 1; j < Dimension + 1; j++){
                World[i][j] = Math.random() > 0.4;
            }
        }
        return World;
    }

}
