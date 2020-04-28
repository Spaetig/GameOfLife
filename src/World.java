import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class World extends JTable {
    TableColumn[] tableColumns;
    Cell[][] cells;
    Game parent;

    public World(int numRows, int width, Game parent) {
        super(numRows, numRows);
        this.parent = parent;
        setBounds(0, 0, width, width);
        setRowHeight(width / numRows);
        setCellSelectionEnabled(true);
        tableColumns = new TableColumn[numRows];
        for (int i = 0; i < numRows; i++) {
            tableColumns[i] = getColumnModel().getColumn(i);
        }
        cells = new Cell[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                cells[i][j] = new Cell(i, j, numRows - 1, numRows -1);
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                cells[i][j].saveNeighbours(cells);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startLifecycle(int amountCycles) {
        for (int i = 0; i < amountCycles; i++) {
            int counter = 0;
            for (Cell[] cellRow : cells) {

                for (Cell cell : cellRow) {
                    cell.age();
                }
                tableColumns[counter].setCellRenderer(new CustomColorRenderer(Color.BLACK, Color.GREEN, cells));
                parent.repaint();
                counter++;
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
