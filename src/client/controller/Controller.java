package client.controller;

import java.io.IOException;
import java.net.Socket;

public class Controller {
    private static final int PORT = 5678;
    private static final String HOST = "127.0.0.1";

    public Controller(){
        createConnection();
    }

    private void createConnection(){
        try {
            System.out.println("Подключаемся к " + HOST + " по порту " + PORT);
            Socket socket = new Socket(HOST, PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
