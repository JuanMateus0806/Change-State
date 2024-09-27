package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class PanelMajor extends JPanel {

    private JMenuBar menuBar;
    private JMenu start;
    private JMenu stop;
    private JMenu add;
    private JMenu delete;

    public PanelMajor(){
        config();
        initComponent();
    }

    private void config(){
        this.setBackground(new Color(207, 254, 255 ));
        this.setLayout(null);
        initComponent();
    }

    private void initComponent(){
        add(createJmenuBar());
        setVisible(true);
    }

    private JMenuBar createJmenuBar(){
        menuBar = new JMenuBar();
        start = new JMenu("Iniciar");
        stop = new JMenu("Detener");
        add = new JMenu("Agregar proceso");
        delete = new JMenu("Eliminar proceso");
        menuBar.add(start);
        menuBar.add(stop);
        menuBar.add(add);
        menuBar.add(delete);
        return menuBar;
    }
}
