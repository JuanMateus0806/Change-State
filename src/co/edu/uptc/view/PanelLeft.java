package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class PanelLeft extends JPanel {

    private PanelTable panelTable;
    private PanelIOptions panelIOptions;

    public PanelLeft(){
        config();
        initComponent();
        this.setVisible(true);
    }

    private void config(){
        this.setBackground(new Color(52, 73, 94));
        this.setLayout(null);
    }

    private void initComponent(){
        createPanelTable();
        createPanelOptions();
    }

    private void createPanelTable(){
        panelTable = new PanelTable();
        panelTable.setBounds(10,10,313,330);
        add(panelTable);
    }

    private void createPanelOptions(){
        panelIOptions = new PanelIOptions();
        panelIOptions.setBounds(10,340,313,470);
        add(panelIOptions);
    }

    public PanelTable getPanelTable() {
        return panelTable;
    }

    public void setPanelTable(PanelTable panelTable) {
        this.panelTable = panelTable;
    }

    public PanelIOptions getPanelIOptions() {
        return panelIOptions;
    }

    public void setPanelIOptions(PanelIOptions panelIOptions) {
        this.panelIOptions = panelIOptions;
    }
}
