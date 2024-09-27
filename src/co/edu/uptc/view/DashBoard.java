package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractChangeOfStatusOfProcesses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CopyOnWriteArraySet;

import co.edu.uptc.pojos.Process;

public class DashBoard extends JFrame implements ActionListener,ContractChangeOfStatusOfProcesses.View {

    //Attributes
    private ContractChangeOfStatusOfProcesses.Presenter presenter;
    private PanelMajor panelMajor;
    private JButton start;
    private JButton stop;
    private JButton add;
    private JButton delete;
    private AddProcess jDIalogaddProcess;
    private DeleteProcess jDialogdeleteProcess;
    private AddExpectedPocess addExpectedPocess;
    PanelLeft panelLeft;
    PanelSuperior panelSuperior;

    public DashBoard(){
        config();
        initComponent();
    }

    private void config() {
        this.setUndecorated(true);
        this.setSize(1520, 950);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponent();
        this.setVisible(true);
    }

    private void initComponent(){
        createPanelSuperior();
        createPanelLeft();
    }
/*
    private void createJmenuBar() {
        start = new JButton("Iniciar");
        start.addActionListener(this);
        start.setBounds(0,0,70,25);
        add(start);
        stop = new JButton("Detener");
        stop.addActionListener(this);
        stop.setBounds(70,0,80,25);
        add(stop);
        add = new JButton("Agregar proceso");
        add.addActionListener(this);
        add.setBounds(150,0,140,25);
        add(add);
        delete = new JButton("Eliminar proceso");
        delete.addActionListener(this);
        delete.setBounds(290,0,140,25);
        add(delete);
    }

 */

    private void createPanelSuperior(){
        panelSuperior = new PanelSuperior(this);
        panelSuperior.setBounds(0,0,1550,150);
        getContentPane().add(panelSuperior);
    }

    private void createPanelLeft(){
        panelLeft = new PanelLeft();
        panelLeft.setBounds(0,150,330,800);
        getContentPane().add(panelLeft);
    }

    private void createAddProcess(){
        jDIalogaddProcess = new AddProcess(this);
    }

    private void createDeleteProcess(){

    }


    private void stopProcess(){
        startProcess(false);
    }

    private void startP(){
        startProcess(true);
    }

    @Override
    public void setPresenter(ContractChangeOfStatusOfProcesses.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void startProcess(boolean go) {
        presenter.startProcess(go);
    }

    @Override
    public void start() {
        this.setVisible(true);
    }

    @Override
    public void addProcess() {
        Process process = jDIalogaddProcess.getNewProcess();
        if (this.presenter.addProcess(process)){
            String[] tableRow = {process.getName(),String.valueOf(process.getRuntime()),String.valueOf(process.isLockable())};
            panelLeft.getPanelTable().addRow(tableRow);
        }
    }

    @Override
    public void deleteProcess() {
        this.presenter.deleteProcess(panelLeft.getPanelTable().deleteRow());
    }

    @Override
    public void refresh() {
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case ("Iniciar"):
                startP();
                break;
            case ("Agregar proceso"):
                createAddProcess();
                break;
            case ("Eliminar proceso"):
                deleteProcess();
                break;
            case ("Agregar"):
                addNewProcess();
                break;
            case ("Eliminar"):

                break;
        }
    }

    @Override
    public void notifyWarning(String message) {
        JOptionPane.showMessageDialog(this,message);
    }

    @Override
    public void notifyConfirm(String message) {
        JOptionPane.showMessageDialog(this,message);
    }

    public void addNewProcess(){
        addProcess();
        System.out.println(jDIalogaddProcess.getNewProcess());
    }

    public void changeProcess(){

    }
}
