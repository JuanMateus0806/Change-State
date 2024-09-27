package co.edu.uptc.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelTable extends JPanel {

    private JTable table;
    private JScrollPane scrollPane;
    DefaultTableModel model;

    public PanelTable(){
        config();
    }

    private void config() {
        this.setBackground(new Color(178, 186, 187));
        this.setLayout(null);
        createDefaultTableModel();
        table = new JTable(model);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.setPreferredScrollableViewportSize(new Dimension(300, 300));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumn("Proceso").setPreferredWidth(100);
        table.getColumn("Tiempo").setPreferredWidth(97);
        table.getColumn("Bloqueable").setPreferredWidth(100);
        table.getColumn("Proceso").setResizable(false);
        table.getColumn("Tiempo").setResizable(false);
        table.getColumn("Bloqueable").setResizable(false);
        table.setBackground(new Color(229, 232, 232));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(7,5,300,320);
        add(scrollPane);
    }

    private void createDefaultTableModel(){
        String [] nameColumn = {"Proceso","Tiempo","Bloqueable"};
        String [][] data = {};
        model = new DefaultTableModel(data, nameColumn){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desactivar la edición para todas las celdas
            }
        };
    }

    public void addRow(String [] row) {
        model.addRow(row);
    }

    public String deleteRow(){
        int x = table.getSelectedRow();
        System.out.println(x);
        String nameProcess = (String) table.getValueAt(x,0);
        model.removeRow(x);
        System.out.println(nameProcess);
        return nameProcess;
    }

}
