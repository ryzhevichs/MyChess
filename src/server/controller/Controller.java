package server.controller;

import model.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Controller {
    public static final int PORT = 5678;
    private ServerSocket serverSocket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public Controller(){
        createConnection();
    }

    private void createConnection() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Ожидание клиента...");
            Socket socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
