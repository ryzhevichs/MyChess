package server.controller;

import model.ChessBoard;
import model.Coordinates;
import model.pieces.Piece;

import javax.swing.*;
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
        Coordinates oldCoord = new Coordinates(piece.getXCoord(), piece.getYCoord());
        Coordinates newCoord = new Coordinates(x,y);

        try {
            output.writeObject(piece);
            output.writeObject(oldCoord);
            output.writeObject(newCoord);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMove(Piece piece){
            Coordinates oldCoord = new Coordinates(piece.getXCoord(), piece.getYCoord());
            Coordinates newCoord = new Coordinates(-1, -1);
            try {
                output.flush();
                output.writeObject(piece);
                output.writeObject(oldCoord);
                output.writeObject(newCoord);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void waitMove(){
        while (true){
            try{
                Piece piece =(Piece) input.readObject();

                Coordinates oldCoord =(Coordinates) input.readObject();
                Coordinates newCoord =(Coordinates) input.readObject();

                int oldX = oldCoord.getX();
                int oldY = oldCoord.getY();
                int newX = newCoord.getX();
                int newY = newCoord.getY();

                if(newX == -1 && newY == -1){
                    board.removePieceAtCoord(oldX, oldY);
                    board.removePiece(piece);
                    if(board.isCheckmate()){
                        JOptionPane.showMessageDialog(null,
                                "Игра окончена!",
                                "Game Over",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    board.setPieceAtNewCoordinate(piece, oldCoord, newCoord);
                    break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
