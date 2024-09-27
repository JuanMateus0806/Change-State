package co.edu.uptc.presenter;

import co.edu.uptc.model.Processor;
import co.edu.uptc.view.DashBoard;

public class ManagerGeneral{

    //Attributes
    public static ManagerGeneral instance;
    private ContractChangeOfStatusOfProcesses.Presenter presenter;
    private ContractChangeOfStatusOfProcesses.View view;
    private ContractChangeOfStatusOfProcesses.Model model;

    public void createMVP(){
        view = new DashBoard();
        presenter = new Presenter();
        model = new Processor();
        presenter.setView(view);
        presenter.setModel(model);
        model.setPresenter(presenter);
        view.setPresenter(presenter);
    }

    public static ManagerGeneral getInstance() {
        return instance == null ? instance = new ManagerGeneral() : instance;
    }

    public void runProject(){
        createMVP();
        view.start();
    }
}
