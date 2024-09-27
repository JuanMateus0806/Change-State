package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSuperior extends JPanel {

    private JButton start;
    private JButton stop;
    private JButton addProcess;
    private JButton deleteProcess;
    private JButton editProcess;
    private JButton exit;

    public PanelSuperior(ActionListener event){
        config();
        initComponent(event);
        this.setVisible(true);
    }

    private void config(){
        this.setBackground(new Color(189, 195, 199));
        this.setLayout(null);
    }

    private void initComponent(ActionListener event){
        createButtonStart(event);
        createAddProcess(event);
        createDeleteProcess(event);
        createEditProcess();
        createExit();
    }

    private void createButtonStart(ActionListener event){
        start = new JButton("Iniciar");
        start.setBounds(30,60,70,30);
        start.setBorderPainted(false);
        start.setBackground(new Color(52,73,94));
        start.setForeground(Color.WHITE);
        add(start);
    }

    private void createButtonStop(ActionListener event){
        stop = new JButton("Detener");
        stop.setBounds(130,60,80,30);
        stop.setBorderPainted(false);
        stop.setBackground(new Color(52, 73, 94 ));
        stop.setForeground(Color.WHITE);
        add(stop);
    }

    private void createAddProcess(ActionListener event){
        addProcess = new JButton("Agregar proceso");
        addProcess.setBounds(130,60,130,30);
        addProcess.setBorderPainted(false);
        addProcess.setBackground(new Color(52,73,94));
        addProcess.setForeground(Color.WHITE);
        addProcess.addActionListener(event);
        add(addProcess);
    }

    private void createDeleteProcess(ActionListener event){
        deleteProcess = new JButton("Eliminar proceso");
        deleteProcess.setBounds(290,60,130,30);
        deleteProcess.setBorderPainted(false);
        deleteProcess.setBackground(new Color(52,73,94));
        deleteProcess.setForeground(Color.WHITE);
        deleteProcess.addActionListener(event);
        add(deleteProcess);
    }

    private void createEditProcess(){
        editProcess = new JButton("Editar proceso");
        editProcess.setBounds(450,60,130,30);
        editProcess.setBorderPainted(false);
        editProcess.setBackground(new Color(52,73,94));
        editProcess.setForeground(Color.WHITE);
        add(editProcess);
    }

    private void createExit(){
        exit = new JButton("Salir");
        exit.setBounds(1410,60,80,30);
        exit.setBorderPainted(false);
        exit.setBackground(new Color(52,73,94));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }

}
