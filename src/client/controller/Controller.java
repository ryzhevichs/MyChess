package client.controller;

import controller.GameController;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    private static final int PORT = 5678;
    private static final String HOST = "127.0.0.1";

    public Controller(){
        createConnection();
        new GameController().startGame();
    }

    private void createConnection(){
        try {
            System.out.println("Подключаемся к " + HOST + " по порту " + PORT);
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Вы подключились к " + socket.getLocalSocketAddress());
            JOptionPane.showMessageDialog(null, "Вы подключились");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
