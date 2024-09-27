package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class PanelIOptions extends JPanel {

    private JLabel informsLabel;
    private JLabel andTransition;
    private JButton ready;
    private JButton running;
    private JButton blocked;
    private JButton finished;
    private JButton wakeUp;
    private JButton dispatch;
    private JButton time_expiration;
    private JButton block;

    public PanelIOptions(){
        config();
        initComponent();
        this.setVisible(true);
    }

    private void config(){
        this.setLayout(null);
        this.setBackground(new Color(52, 73, 94));
    }

    private void initComponent(){
        createInformsLabel();
        createAndTransition();
        createReady();
        createRunning();
        createBlocked();
        createFinished();
        createDispatch();
        createBlock();
        createWakeUp();
        createTimeExpiration();
    }

    private void createInformsLabel(){
        informsLabel = new JLabel("Informes de estados");
        informsLabel.setBounds(30,10,250,20);
        informsLabel.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
        informsLabel.setForeground(Color.WHITE);
        add(informsLabel);
    }

    private void createAndTransition(){
        andTransition = new JLabel("y transiciones");
        andTransition.setBounds(60,30,250,25);
        andTransition.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
        andTransition.setForeground(Color.WHITE);
        add(andTransition);
    }

    private void createReady(){
        ready = new JButton("Listo");
        ready.setBounds(75,85,160,30);
        ready.setBackground(new Color(189, 195, 199));
        add(ready);
    }

    private void createRunning(){
        running = new JButton("En ejecución");
        running.setBounds(75,125,160,30);
        running.setBackground(new Color(189,195,199));
        add(running);
    }

    private void createBlocked(){
        blocked = new JButton("Bloquear");
        blocked.setBounds(75,165,160,30);
        blocked.setBackground(new Color(189,195,199));
        add(blocked);
    }

    private void createFinished(){
        finished = new JButton("Finalizado");
        finished.setBounds(75,205,160,30);
        finished.setBackground(new Color(189,195,199));
        add(finished);
    }

    private void createDispatch(){
        dispatch = new JButton("Despachar");
        dispatch.setBounds(75,245,160,30);
        dispatch.setBackground(new Color(189,195,199));
        add(dispatch);
    }

    private void createBlock(){
        block = new JButton("Bloqueado");
        block.setBounds(75,285,160,30);
        block.setBackground(new Color(189,195,199));
        add(block);
    }

    private void createWakeUp(){
        wakeUp = new JButton("Despertar");
        wakeUp.setBounds(75,325,160,30);
        wakeUp.setBackground(new Color(189,195,199));
        add(wakeUp);
    }

    private void createTimeExpiration(){
        time_expiration = new JButton("Expiracion de tiempo");
        time_expiration.setBounds(75,365,160,30);
        time_expiration.setBackground(new Color(189,195,199));
        add(time_expiration);
    }

}
