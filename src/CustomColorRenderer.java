import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomColorRenderer extends DefaultTableCellRenderer {
    Color colorDead, colorLiving;
    Cell[][] cells;

    public CustomColorRenderer(Color colorDead, Color colorLiving, Cell[][] cells) {
        super();
        this.colorDead = colorDead;
        this.colorLiving = colorLiving;
        this.cells = cells;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component graphicalCell = super.getTableCellRendererComponent(table, value, false, false, row, column);
        Cell cell = cells[row][column];
        if (cell.isLiving()) graphicalCell.setBackground(colorLiving);
        else graphicalCell.setBackground(colorDead);
        return graphicalCell;
    }
}
