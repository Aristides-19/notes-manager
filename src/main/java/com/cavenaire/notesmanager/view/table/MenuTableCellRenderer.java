package com.cavenaire.notesmanager.view.table;

import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MenuTableCellRenderer extends DefaultTableCellRenderer {

    public final Font font;
    public final int leftMargin;

    public MenuTableCellRenderer(int alignment, Font font, int leftMargin) {
        super();
        this.font = font;
        this.leftMargin = leftMargin;
        setHorizontalAlignment(alignment);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent cell = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Palette.BORDER),
                BorderFactory.createEmptyBorder(0, leftMargin, 0, 0)));
        cell.setFont(font);
        cell.setAlignmentX(5.0F);
        return cell;
    }
}
