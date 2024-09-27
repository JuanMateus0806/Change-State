package co.edu.uptc.pojos;

import java.util.ArrayList;
import java.util.List;

public class Process implements Cloneable{

    //Attributes
    private String name;
    private double runtime;
    private boolean lockable;
    private boolean finished;
    private boolean ready;
    private boolean blocked;
    private boolean running;

    //Constructors
    public Process() {
    }

    public Process(String name, double runtime, boolean lockable) {
        this.name = name;
        this.runtime = runtime;
        this.finished = false;
        this.ready = true;
        this.blocked = false;
        this.running = false;
        this.lockable = lockable;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isLockable() {
        return lockable;
    }

    public void setLockable(boolean lockable) {
        this.lockable = lockable;
    }

    @Override
    public Process clone() {
        try {
            Process clone = (Process) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
