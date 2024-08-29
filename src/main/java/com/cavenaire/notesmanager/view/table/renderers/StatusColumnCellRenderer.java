package com.cavenaire.notesmanager.view.table.renderers;

import com.cavenaire.notesmanager.view.styles.Palette;

import javax.swing.*;
import java.awt.*;

/**
 * It renders cells from {@code status} column, the only difference is colors.
 * It assumes it that the column text is only {@code Finished} or {@code Draft}. <br/>
 * In that case, it needs a model implementation that uses {@code getStatusColumnIndex}
 */
public class StatusColumnCellRenderer extends MenuTableCellRenderer {

    public StatusColumnCellRenderer(int alignment, Font font, int leftMargin) {
        super(alignment, font, leftMargin);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent cell = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value.toString().startsWith("T")) {
            cell.setForeground(Palette.FINISHED);
        } else {
            cell.setForeground(Palette.DRAFT);
        }
        return cell;
    }
}
