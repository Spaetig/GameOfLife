import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {
    private boolean isLiving = false;
    private int x, y, maxX, maxY;
    private List<Cell> neighbours = new ArrayList<>();

    public Cell(int x, int y, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
        Random random = new Random();
        int isLivingChance = random.nextInt(11);
        if (isLivingChance <= 6) isLiving = true;
    }

    public void saveNeighbours(Cell[][] parentTable) {
        if (x != 0 && y != 0) neighbours.add(parentTable[x - 1][y - 1]);
        if (y != 0) neighbours.add(parentTable[x][y - 1]);
        if (x != maxX && y != 0) neighbours.add(parentTable[x + 1][y - 1]);
        if (x != maxX) neighbours.add(parentTable[x + 1][y]);
        if (x != maxX && y != maxY) neighbours.add(parentTable[x + 1][y + 1]);
        if (y != maxY) neighbours.add(parentTable[x][y + 1]);
        if (x != 0 && y != maxY) neighbours.add(parentTable[x - 1][y + 1]);
        if (x != 0) neighbours.add(parentTable[x - 1][y]);
    }

    public void age() {
        int amountLivingNeighbours = 0;
        for (Cell cell : neighbours) {
            if (cell.isLiving) amountLivingNeighbours++;
        }
        if (amountLivingNeighbours < 2 || amountLivingNeighbours > 3) isLiving = false;
        if ((amountLivingNeighbours == 2 || amountLivingNeighbours == 3) && isLiving) isLiving = true;
        if (amountLivingNeighbours == 3 && !isLiving) isLiving = true;
    }

    public boolean isLiving() {
        return isLiving;
    }
}
