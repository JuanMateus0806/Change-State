package co.edu.uptc.view;

import co.edu.uptc.pojos.Process;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DeleteProcess extends JDialog{

    private JLabel name;
    private JTextField nameText;
    private JButton confirm;


    public DeleteProcess(ActionListener event){
        config(event);
    }

    private void config(ActionListener event){
        this.setTitle("Eliminar proceso");
        this.setSize(300, 230);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        initComponent(event);
        this.setVisible(true);
    }

    private void initComponent(ActionListener event){
        name = new JLabel("Nombre del proceso");
        name.setBounds(30,50,120,25);
        add(name);
        nameText = new JTextField();
        nameText.setBounds(30,75,220,25);
        add(nameText);
        confirm = new JButton("Eliminar");
        confirm.addActionListener(event);
        confirm.setBounds(105,110,80,25);
        add(confirm);
    }

    public String deleteProcess(){
        if (nameText.getText() == "") {
            return name.getText();
        }
        return null;
    }


}
