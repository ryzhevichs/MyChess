package server.controller;

import model.ChessBoard;
import model.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ChessBoard board;


    public Communication(Socket socket, ChessBoard board){
        this.board = board;
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output.flush();

        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }

    }
}
