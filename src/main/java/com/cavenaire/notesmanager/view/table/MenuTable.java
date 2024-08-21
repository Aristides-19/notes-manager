package com.cavenaire.notesmanager.view.table;

import com.cavenaire.notesmanager.view.observer.Observable;
import com.cavenaire.notesmanager.view.styles.FontPalette;
import com.cavenaire.notesmanager.view.styles.Palette;
import com.cavenaire.notesmanager.view.table.models.MenuTableModel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * JTable implementation for businesses objects. It implements {@code Observable} interface,
 * and it needs an {@code AbstractViewTableModel} implementation for the business object table.
 *
 * @param <T> Business object to represent in this row
 */
public class MenuTable<T> extends JTable implements Observable<List<T>> {

    private final MenuTableModel<T> viewTableModel;
    @Getter
    private final JScrollPane scrollPane = new JScrollPane(this);

    public MenuTable(MenuTableModel<T> viewTableModel, int... columnWidths) {
        super(viewTableModel);
        this.viewTableModel = viewTableModel;
        initHeader();
        initColumns(columnWidths);
        init();
    }

    @Override
    public void update(List<T> rows) {
        viewTableModel.setRows(rows);
    }

    private void init() {
        putClientProperty("FlatLaf.style",
                "foreground : " + Palette.MAIN_HEX +
                        "; background : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; selectionBackground : " + Palette.BACKGROUND_HEX +
                        "; selectionForeground : " + Palette.MAIN_HEX +
                        "; rowHeight : 53" +
                        "; cellMargins: 0,25,0,0");
        scrollPane.setBorder(BorderFactory.createLineBorder(Palette.BORDER, 1, true));

        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clearSelection();
            }
        });
    }

    private void initColumns(int... columnWidths) {
        var columnModel = getColumnModel();

        for (int i = 1; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(columnWidths[i]);
            columnModel.getColumn(i).setCellRenderer(RENDERER);
        }

        columnModel.getColumn(0).setMaxWidth(columnWidths[0]);
        columnModel.getColumn(0).setCellRenderer(ID_RENDERER);
    }

    private void initHeader() {
        var header = getTableHeader();

        header.putClientProperty("FlatLaf.style",
                "foreground : " + Palette.MAIN_HEX +
                        "; background : " + Palette.SECONDARY_BACKGROUND_HEX +
                        "; height : 53");

        var columnModel = header.getColumnModel();
        for (int i = 1; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setHeaderRenderer(HEADER_RENDERER);
        }

        columnModel.getColumn(0).setHeaderRenderer(ID_HEADER_RENDERER);
    }

    // COMMONS
    private static final MenuTableCellRenderer ID_HEADER_RENDERER = new MenuTableCellRenderer(SwingConstants.CENTER, FontPalette.H2, 0);
    private static final MenuTableCellRenderer HEADER_RENDERER = new MenuTableCellRenderer(SwingConstants.LEADING, FontPalette.H2, 25);
    private static final MenuTableCellRenderer ID_RENDERER = new MenuTableCellRenderer(SwingConstants.CENTER, FontPalette.H3_REG, 0);
    private static final MenuTableCellRenderer RENDERER = new MenuTableCellRenderer(SwingConstants.LEADING, FontPalette.H3_REG, 25);
}
