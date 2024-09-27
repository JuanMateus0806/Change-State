package co.edu.uptc.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Status {

    //Attributes
    private NameState nameState;
    private List<Process> historyProcess;
    private double timeAllowed;

    //Constructors
    public Status(NameState nameState){
        this.nameState = nameState;
        this.historyProcess = new ArrayList<>();
        timeAllowed = 0;
    }

    public Status(NameState nameState, double timeAllowed){
        this.nameState = nameState;
        this.timeAllowed = timeAllowed;
        this.historyProcess = new ArrayList<>();
    }

    //Getter and Setter
    public String getNameState() {
        return nameState.name();
    }

    public void setNameState(NameState nameState) {
        this.nameState = nameState;
    }

    public double getTimeAllowed() {
        return timeAllowed;
    }

    public void setTimeAllowed(double timeAllowed) {
        this.timeAllowed = timeAllowed;
    }

    public List<Process> getHistoryProcess() {
        return historyProcess;
    }

    public void setHistoryProcess(List<Process> historyProcess) {
        this.historyProcess = historyProcess;
    }
}
