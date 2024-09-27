package co.edu.uptc.model;

import co.edu.uptc.pojos.*;
import co.edu.uptc.pojos.Process;
import co.edu.uptc.presenter.ContractChangeOfStatusOfProcesses;
import co.edu.uptc.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Processor implements ContractChangeOfStatusOfProcesses.Model {

    //Attributes
    private ContractChangeOfStatusOfProcesses.Presenter presenter;
    private Status ready;
    private Status blocked;
    private Status running;
    private Status finished;
    private boolean go;
    private HashMap<NameTransitions,Transition> transitions;

    public Processor(){
        this.ready = new Status(NameState.READY);
        this.blocked = new Status(NameState.BLOCKED);
        this.running = new Status(NameState.RUNNING,5);
        this.finished = new Status(NameState.FINISHED);
        this.go = false;
        transitions = new HashMap<>();
        loadTransitions();
        initializerProcess();
        refresh();
    }

    //Implements methods interface
    @Override
    public void setPresenter(ContractChangeOfStatusOfProcesses.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void startProcess(boolean go) {
        this.go = go;
        initializerProcess();
    }

    @Override
    public boolean addProcess(Process process) {
        return addNewProcess(process);
    }

    @Override
    public void deleteProcess(String s) {
        deleteProcessX(s);
    }

    @Override
    public void refresh() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (go){
                    presenter.refresh();
                    Utils.sleep();
                }
            }
        });
        thread.start();
    }

    @Override
    public String[] listProcess() {
        return new String[0];
    }

    //Load transitions
    private void loadTransitions(){
        transitions.put(NameTransitions.DISPATCH,new Transition(NameTransitions.DISPATCH,ready,running));
        transitions.put(NameTransitions.WAKE_UP,new Transition(NameTransitions.WAKE_UP,blocked,ready));
        transitions.put(NameTransitions.BLOCKED,new Transition(NameTransitions.BLOCKED,running,blocked));
        transitions.put(NameTransitions.TIME_EXPIRATION,new Transition(NameTransitions.TIME_EXPIRATION,running,ready));
        transitions.put(NameTransitions.FINISHED,new Transition(NameTransitions.FINISHED,running,finished));
    }

    //Manage processes
    public boolean addNewProcess(Process process){
        boolean x = false;
        if (process!=null){
            if (searchProcess(process.getName())==null) {
                ready.getHistoryProcess().add(process);
                presenter.notifyConfirm("El proceso se agrego correctamente");
                x = true;
            }else
                presenter.notifyWarning("Ya existe un proceso con este nombre: "+process.getName());
        }
        return x;
    }

    public void deleteProcessX(String nameProcess){
        ready.getHistoryProcess().remove(searchProcess(nameProcess));
    }

    private Process searchProcess(String nameProcess){
        Process process = null;
        for (Process aux: ready.getHistoryProcess())
            if(aux.getName().compareToIgnoreCase(nameProcess)==0)
                process = aux;
        return process;
    }

    //Initializer Process
    private void initializerProcess(){
        initializerStateRunning();
        initializerStateBlocked();
    }

    private void initializerStateRunning(){
        Thread threadRunning = new Thread(new Runnable() {
            @Override
            public void run() {
                while (go){
                    runNextProcess();
                    runProcess();
                    Utils.sleep();
                    System.out.println("Ejecutando:  "+running.getHistoryProcess().getLast().getName());
                }
            }
        });
        threadRunning.start();
    }

    private void runNextProcess(){
        if (running.getHistoryProcess().isEmpty()){
            transitionDispatch();
        }else if (!running.getHistoryProcess().getLast().isRunning()){
                    if (verifyProcess() >-1)
                        transitionDispatch();
        }
    }

    private void runProcess(){
        if (running.getHistoryProcess().getLast().isRunning()){
            double time = running.getHistoryProcess().getLast().getRuntime();
                runningProcess(time);
        }
    }

    private void runningProcess(double t){
        int count = 0;
        double time = t;
        do {
            if (time>0){
                Utils.sleep();
                count++;
                time--;
            }
        }while (count<5 && time>0);
        running.getHistoryProcess().getLast().setRunning(false);
        running.getHistoryProcess().getLast().setRuntime(t-count);
        runningNextTransition();
    }

    private void transitionDispatch(){
        Transition tmp = transitions.get(NameTransitions.DISPATCH);
        synchronized (running.getHistoryProcess()){
            tmp.getHistoryProcess().add(tmp.getInitialState().getHistoryProcess().get(nextProcess()));
            tmp.getFinalStatus().getHistoryProcess().add(tmp.getHistoryProcess().getLast());
            tmp.getFinalStatus().getHistoryProcess().getLast().setRunning(true);
        }
    }

    private int nextProcess(){
        int x = -1;
        for (int i=0;i<ready.getHistoryProcess().size();i++){
            if (ready.getHistoryProcess().get(i).isReady()){
                x = i;
                ready.getHistoryProcess().get(i).setReady(false);
                break;
            }
        }
        return x;
    }

    private int verifyProcess(){
        int x = -1;
        for (int i=0;i<ready.getHistoryProcess().size();i++){
            if (ready.getHistoryProcess().get(i).isReady()){
                x = i;
                break;
            }
        }
        return x;
    }

    private void transitionTimeExpiration(){
        Transition tmp = transitions.get(NameTransitions.TIME_EXPIRATION);
        tmp.getHistoryProcess().add(tmp.getInitialState().getHistoryProcess().getLast());
        loadStatusProcess(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().add(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().getLast().setReady(true);
    }

    private void transitionWakeUp(){
        Transition tmp = transitions.get(NameTransitions.WAKE_UP);
        for (Process process: checkProcessWakeUp()){
            tmp.getHistoryProcess().add(process);
            loadStatusProcess(tmp.getHistoryProcess().getLast());
            tmp.getFinalStatus().getHistoryProcess().add(tmp.getHistoryProcess().getLast());
            tmp.getFinalStatus().getHistoryProcess().getLast().setReady(true);
        }
    }

    private void transitionBlocked(){
        Transition tmp = transitions.get(NameTransitions.BLOCKED);
        tmp.getHistoryProcess().add(tmp.getInitialState().getHistoryProcess().getLast());
        loadStatusProcess(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().add(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().getLast().setBlocked(true);
    }

    private void transitionFinished(){
        Transition tmp = transitions.get(NameTransitions.FINISHED);
        tmp.getHistoryProcess().add(tmp.getInitialState().getHistoryProcess().getLast());
        loadStatusProcess(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().add(tmp.getHistoryProcess().getLast());
        tmp.getFinalStatus().getHistoryProcess().getLast().setFinished(true);
    }

    private List<Process> checkProcessWakeUp(){
        Transition tmp = transitions.get(NameTransitions.WAKE_UP);
        List<Process> processWakeUp = new ArrayList<>();
        for (Process aux: tmp.getInitialState().getHistoryProcess()){
            if (!aux.isBlocked() && !aux.isReady() && !aux.isRunning() && !aux.isFinished()){
                processWakeUp.add(aux);
            }
        }
        return processWakeUp;
    }



    private void runningNextTransition(){
        if (!running.getHistoryProcess().getLast().isRunning())
            if (running.getHistoryProcess().getLast().getRuntime()==0)
                transitionFinished();
            else
                transitionTimeExpiration();
        else
            transitionTimeExpiration();
    }

    private void loadStatusProcess(Process process){
        if (process.isReady()){
            process.setReady(false);
        }else if (process.isRunning()){
            process.setRunning(false);
        } else if (process.isBlocked()) {
            process.setBlocked(false);
        }
    }

    private void initializerStateBlocked(){
        Thread threadBlocked = new Thread(new Runnable() {
            @Override
            public void run() {
                while (go){
                    blockedNextTransition();
                    Utils.sleep();
                    if (!blocked.getHistoryProcess().isEmpty()){
                        System.out.println("Bloqueado_Finalizado: proceso: " + blocked.getHistoryProcess().getLast().getName() + blocked.getHistoryProcess().getLast().isFinished());
                    }
                }
            }
        });
        //threadBlocked.start();
    }

    private void blockedNextTransition() {
        List<Process> tmp = blocked.getHistoryProcess();
        for(Process process: tmp){

        }
        transitionWakeUp();
    }


}
