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
//            try {
//                System.out.println("заход в try server");
//                GameController controller = new GameController(Player.BLACK, socket);
//                out = new ObjectOutputStream(socket.getOutputStream());
//                out.writeObject(controller);
//                controller.startGame();
                new GameController(Player.WHITE, socket).startGame();
//            } catch (IOException e){
//                e.printStackTrace();
//            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
