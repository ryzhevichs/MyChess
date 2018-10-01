package controller;

import com.sun.tools.javac.Main;
import model.ChessBoard;
import model.Coordinates;
import model.pieces.King;
import model.pieces.Piece;
import model.Player;

import view.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameController {
    private ChessBoard board;
    private GameView view;
    private Piece chosenPiece;

    public GameController(ChessBoard chessBoard, GameView gameView) {
        this.board = chessBoard;
        this.view = gameView;
        this.chosenPiece = null;
    }

    public void startGame() {
        board.setPiecesOnBoard();
        view.redraw();
        turnMessage();
    }

    public void checkClick(Graphics2D g2d, double clickedX, double clickedY) {
        int x, y;
        Piece p;

        if (clickedX >= 0 && clickedY >= 0) {
            x = (int) (clickedX / 60);
            y = this.board.getHeight() - 1 - (int) (clickedY / 60);
            p = this.board.getPieceAtCoordinate(x, y);

            if (p != null) {
                if (p.getPlayer() == board.getPlayerForTurn()) {
                    this.chosenPiece = p;
                    System.out.println(chosenPiece.getPlayer() + " " + chosenPiece.getName());
                } else {
                    if (chosenPiece == null) {
                        return;
                    }
                    movePieceToOpponentCell(view, p);
                }
            } else if (chosenPiece != null) {
                movePieceToEmptyCell(view, x, y);
            }
        }
    }

    private void movePieceToOpponentCell(GameView view, Piece opponent) {
        ArrayList<Coordinates> coord = chosenPiece.getPossibleCoordinates();
        for (Coordinates curCoord : coord) {
            if (opponent.getXCoord() == curCoord.getX() && opponent.getYCoord() == curCoord.getY()) {
                removeMessage(chosenPiece, opponent);
                removePiece(opponent);

                chosenPiece.setCoordinate(curCoord.getX(), curCoord.getY());
                chosenPiece = null;

                board.changeTurn();
                turnMessage();
                view.redraw();
            }
        }
    }

    private void movePieceToEmptyCell(GameView view, int x, int y) {
        ArrayList<Coordinates> coord = chosenPiece.getPossibleCoordinates();
        for (Coordinates curCoord : coord) {
            if (curCoord.getX() == x && curCoord.getY() == y) {
                chosenPiece.setCoordinate(x, y);
                chosenPiece = null;
                board.changeTurn();
                turnMessage();
                view.redraw();
            }
        }
    }

    private void gameOver(){
        int result = JOptionPane.showConfirmDialog(
                view,"Победа " + chosenPiece.getPlayer() +"\nНачать заново?",
                "Шах и мат",JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
           startGame();
        }
        if(result == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }

    private void removePiece(Piece p){
        p.removeSelf();
        if(isCheckmate()){
           gameOver();
        }

    }

    private boolean isCheckmate(){
        if (board.getBlackKing() == null || board.getWhiteKing() == null){
            return true;
        } else {
            return false;
        }
    }

    private void turnMessage() {
        if (board.getPlayerForTurn() == Player.WHITE) {
            System.out.println("Ход Белых");
        } else {
            System.out.println("Ход Чёрных");
        }
    }

    private void removeMessage(Piece chosen, Piece opponent){
        System.out.println(chosen.getPlayer() + " " +chosenPiece.getName() +
                " съел " + opponent.getPlayer() + " " + opponent.getName());
    }
}
