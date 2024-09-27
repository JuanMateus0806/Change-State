package co.edu.uptc.view;

import co.edu.uptc.pojos.Process;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddExpectedPocess extends JDialog {

    private JComboBox<String> processJComboBox;
    private JLabel selectProcess;
    private JLabel timeExpected;
    private JTextField timeText;
    private JButton addProcess;

    public AddExpectedPocess(ActionListener event){
        config(event);
    }

    private void config(ActionListener event){
        this.setTitle("Agregar proceso");
        this.setSize(300, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        initComponent(event);
        this.setVisible(true);
    }

    private void initComponent(ActionListener event){
        selectProcess = new JLabel("Seleccione el proceso");
        selectProcess.setBounds(30,50,120,25);
        add(selectProcess);
        processJComboBox = new JComboBox<>();
        processJComboBox.setBounds(30,75,220,25);
        add(processJComboBox);
        timeExpected = new JLabel("Ingrese el tiempo de llegada");
        timeExpected.setBounds(30,115,200,25);
        add(timeExpected);
        timeText = new JTextField();
        timeText.setBounds(30,140,220,25);
        add(timeExpected);
        addProcess = new JButton("Agegar");
        addProcess.setBounds(30,180,80,25);
        addProcess.addActionListener(event);
        addProcess.setActionCommand("Relacionar");
        add(addProcess);
    }

    public void changeProcess(String[] value) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(value);
        processJComboBox.setModel(model);
    }


}
