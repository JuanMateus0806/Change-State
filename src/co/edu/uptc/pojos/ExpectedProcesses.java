package co.edu.uptc.pojos;

public class ExpectedProcesses {

    private Process process;
    private double timeExpected;
    private boolean state;

    public ExpectedProcesses(){}

    public ExpectedProcesses(Process process, double timeExpected) {
        this.process = process;
        this.timeExpected = timeExpected;
        this.state = false;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public double getTimeExpected() {
        return timeExpected;
    }

    public void setTimeExpected(double timeExpected) {
        this.timeExpected = timeExpected;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
