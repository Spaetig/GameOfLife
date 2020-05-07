import javax.swing.*;

public class Game extends JFrame {
    private World world;
    private static int amountCells;
    private int size = amountCells * 15;
    private static int amountCycles;
    private static int inputSize;

    public Game() {
        world = new World(amountCells,size, this);
        setTitle("Game of Life");
        add(world);
        setSize(world.tableHeight, world.tableHeight);
        setVisible(true);
        world.startLifecycle(amountCycles);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        inputSize = Integer.parseInt(JOptionPane.showInputDialog(frame,"Gamefield size: "));
        amountCells = inputSize;
        amountCycles = 700;
        new Game();
    }
}
