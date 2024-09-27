package co.edu.uptc.presenter;

import co.edu.uptc.model.Processor;
import co.edu.uptc.persistence.Persistence;
import co.edu.uptc.pojos.Process;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Presenter implements ContractChangeOfStatusOfProcesses.Presenter{

    private ContractChangeOfStatusOfProcesses.Model model;
    private ContractChangeOfStatusOfProcesses.View view;
    private Persistence persistence;

    //Persistence
    public void store() throws FileNotFoundException {
        String store = new Gson().toJson(model);
        persistence.store(store);
    }

    public void load () throws FileNotFoundException {
        model = new Gson().fromJson(persistence.load(), Processor.class);
    }

    //Implements methods interface
    @Override
    public void setModel(ContractChangeOfStatusOfProcesses.Model model) {
        this.model = model;
    }

    @Override
    public void setView(ContractChangeOfStatusOfProcesses.View view) {
        this.view = view;
    }

    @Override
    public boolean addProcess(Process process) {
        return model.addProcess(process);
    }

    @Override
    public String[] listProcess() {
        return new String[0];
    }

    @Override
    public void deleteProcess(String s) {
        model.deleteProcess(s);
    }

    @Override
    public void refresh() {
        view.refresh();
    }

    @Override
    public void startProcess(boolean go) {
        model.startProcess(go);
    }

    @Override
    public void notifyWarning(String message) {
        view.notifyWarning(message);
    }

    @Override
    public void notifyConfirm(String message) {
        view.notifyConfirm(message);
    }
}
