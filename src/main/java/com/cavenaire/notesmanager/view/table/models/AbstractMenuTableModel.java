package com.cavenaire.notesmanager.view.table.models;

import lombok.RequiredArgsConstructor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * General implementation for table models. It is intended to be extended for each business object custom model.
 *
 * @param <T> Business object which represents rows
 */
@RequiredArgsConstructor
public abstract class AbstractMenuTableModel<T> extends AbstractTableModel {

    protected final String[] columnNames;
    protected List<T> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // must be implemented by each table type
        return null;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
        fireTableDataChanged();
    }
}
