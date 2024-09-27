package co.edu.uptc.view;

import co.edu.uptc.pojos.Process;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class AddProcess extends JDialog {

    private JLabel name;
    private JLabel timeEjecution;
    private JTextField nameText;
    private JTextField timeText;
    private JButton confirm;
    private JLabel blocked;
    private JRadioButton yes;
    private JRadioButton not;
    ButtonGroup radioButton;

    public AddProcess(ActionListener event){
        config(event);
    }

    private void config(ActionListener event){
        this.setTitle("Agregar proceso");
        this.setSize(250, 250);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        initComponent(event);
        this.setVisible(true);
    }

    private void initComponent(ActionListener event){
        createLabelName();
        createNameText();
        createLabelTimeExecution();
        createTimeExecution();
        createLabelLockable();
        createJRadioButtonYes();
        createJRadioButtonNot();
        createJRadioButton();

        createButton(event);
    }

    private void createLabelName(){
        name = new JLabel("Nombre del proceso");
        name.setBounds(50,10,120,25);
        add(name);
    }

    private void createNameText(){
        nameText = new JTextField();
        nameText.setBounds(45,35,150,25);
        add(nameText);
    }

    private void createLabelTimeExecution(){
        timeEjecution = new JLabel("Tiempo de ejecucion");
        timeEjecution.setBounds(50,65,140,25);
        add(timeEjecution);
    }

    private void createTimeExecution(){
        timeText = new JTextField();
        timeText.setBounds(45,90,150,25);
        add(timeText);
    }

    private void createButton(ActionListener event){
        confirm = new JButton("Agregar");
        confirm.addActionListener(event);
        confirm.setBounds(75,170,80,25);
        add(confirm);
    }

    private void createLabelLockable(){
        blocked = new JLabel("¿El proceso es bloqueable?");
        blocked.setBounds(40,120,180,15);
        add(blocked);
    }

    private void createJRadioButton(){
        radioButton = new ButtonGroup();
        radioButton.add(yes);
        radioButton.add(not);
    }

    private void createJRadioButtonYes(){
        yes = new JRadioButton("Si");
        yes.setBounds(70,145,50,15);
        add(yes);
    }

    private void createJRadioButtonNot(){
        not = new JRadioButton("No");
        not.setBounds(130,145,50,15);
        add(not);
    }

    public Process getNewProcess(){
        Process process = null;
        if (!nameText.getText().isEmpty() && !timeText.getText().isEmpty()) {
            process = new Process(nameText.getText().trim(), Double.parseDouble(timeText.getText().trim()), verifyCheck());
            close();
        }
        return process;
    }

    private boolean verifyCheck(){
        boolean tmp = false;
        if (yes.isSelected()){
            tmp = true;
        }
        return tmp;
    }

    public void close(){
        this.processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }

}
