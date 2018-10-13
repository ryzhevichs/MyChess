package view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionDialog {

    public ConnectionDialog(){
        JDialog connectDialog = new JDialog();
        connectDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        connectDialog.setSize(new Dimension(200,150));
        connectDialog.setLocationRelativeTo(null);
        connectDialog.setModal(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton startServerButton = new JButton("Запустить сервер");
        startServerButton.addActionListener(e ->{
            connectDialog.setVisible(false);
            new server.controller.Controller();
        });
        JButton startClientButton = new JButton("Подключиться");
        startClientButton.addActionListener(e->{
            connectDialog.setVisible(false);
            new client.controller.Controller();
        });

        panel.add(startServerButton);
        panel.add(startClientButton);
        panel.setVisible(true);
        connectDialog.add(panel);

        connectDialog.setVisible(true);
    }
}
