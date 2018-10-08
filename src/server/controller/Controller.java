package server.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Controller {
    public static final int PORT = 5678;
    private ServerSocket serverSocket;
    private Socket client;


    public Controller(){
        createConnection();

    }

    private void createConnection(){
        try {
             serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        try {
            while(true) {
                System.out.println("Ожидание клиента...");
                client = serverSocket.accept();

                System.out.println("Клиент подключён");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
