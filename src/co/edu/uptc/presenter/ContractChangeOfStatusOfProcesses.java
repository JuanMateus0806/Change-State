package co.edu.uptc.presenter;
import co.edu.uptc.pojos.Process;

public interface ContractChangeOfStatusOfProcesses {

    interface Model{
        void setPresenter(ContractChangeOfStatusOfProcesses.Presenter presenter);
        void startProcess(boolean go);
        boolean addProcess(Process process);
        void deleteProcess(String string);
        void refresh();
        String [] listProcess();
    }

    interface Presenter{
        void setModel(ContractChangeOfStatusOfProcesses.Model model);
        void setView(ContractChangeOfStatusOfProcesses.View view);
        boolean addProcess(Process process);
        void deleteProcess(String s);
        void refresh();
        void startProcess(boolean go);
        void notifyWarning(String message);
        void notifyConfirm(String message);
        String [] listProcess();
    }

    interface View{
        void setPresenter(ContractChangeOfStatusOfProcesses.Presenter presenter);
        void start();
        void addProcess();
        void deleteProcess();
        void refresh();
        void startProcess(boolean go);
        void notifyWarning(String message);
        void notifyConfirm(String message);
    }

}
