package client.controller;

import server.controller.GameController;
import model.Player;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Controller {
    private static final int PORT = 5678;
    private static final String HOST = "127.0.0.1";
    private Socket connection;
    ObjectInputStream in ;
    ObjectOutputStream out;

    public Controller(){
        createConnection();

    }

    private void createConnection(){
        try {
            System.out.println("Подключаемся к " + HOST + " по порту " + PORT);
            connection = new Socket(HOST, PORT);
            System.out.println("Вы подключились к " + connection.getLocalSocketAddress());
            JOptionPane.showMessageDialog(null, "Вы подключились");
            new GameController(Player.WHITE, connection).startGame();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
