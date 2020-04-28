import javax.swing.*;

public class Game extends JFrame {
    private World world;
    private static int amountCells;
    private int size = amountCells * 15;
    private static int amountCycles;

    public Game() {
        world = new World(amountCells,size, this);
        setTitle("Game of Life");
        add(world);
        setSize(size, size + 10);
        setVisible(true);
        world.startLifecycle(amountCycles);
    }

    public static void main(String[] args) {

        amountCells = 40;
        amountCycles = 700;
        new Game();
    }
}
