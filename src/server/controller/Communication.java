package server.controller;

import model.ChessBoard;
import model.Player;
import model.pieces.Piece;

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

    public void sendMove(Piece piece, int x, int y){
        try {
            output.writeObject(piece);
            output.writeObject(x);
            output.writeObject(y);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void waitMove(){
        while (true){
            try{
                Piece piece = (Piece)input.readObject();
                int finalX = (int) input.readObject();
                int finalY = (int) input.readObject();
                board.removePiece(piece);
                board.setPieceAtCoordinate(piece, finalX, finalY);

                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
