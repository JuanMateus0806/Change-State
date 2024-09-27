package co.edu.uptc.pojos;

import java.util.ArrayList;
import java.util.List;

public class Transition {

    //Attributes
    private NameTransitions nameTransition;
    private Status initialState;
    private Status finalStatus;
    private List<Process> historyProcess;

    //Constructors
    public Transition(NameTransitions nameTransition, Status initialState,Status statusFinal) {
        this.nameTransition = nameTransition;
        this.finalStatus = statusFinal;
        this.initialState = initialState;
        this.historyProcess = new ArrayList<>();
    }

    //Getters and Setters
    public NameTransitions getNameTransition() {
        return nameTransition;
    }

    public void setNameTransition(NameTransitions nameTransition) {
        this.nameTransition = nameTransition;
    }

    public Status getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(Status finalStatus) {
        this.finalStatus = finalStatus;
    }

    public List<Process> getHistoryProcess() {
        return historyProcess;
    }

    public void setHistoryProcess(List<Process> historyProcess) {
        this.historyProcess = historyProcess;
    }

    public Status getInitialState() {
        return initialState;
    }

    public void setInitialState(Status initialState) {
        this.initialState = initialState;
    }
}
