package server.controller;

import model.ChessBoard;
import model.Coordinates;
import model.pieces.Piece;
import model.Player;
import view.ChessBoardView;
import view.GameView;

import javax.swing.*;
import java.net.Socket;
import java.util.List;

public class GameController {
    private ChessBoard board;
    private GameView view;
    private Piece chosenPiece;
    private ChessBoardView boardView;
    private Communication communication;
    private Player player;
    private boolean endMove;


    public GameController(Player player, Socket socket){
        this.player = player;
        board = new ChessBoard(8,8);
        communication = new Communication(socket, board);
        view = new GameView(board,socket,player, 60, this);
        this.boardView = view.getChessBoardView();
        endMove = false;
    }

    public void startGame() {
        view.initWindow();
        board.setPiecesOnBoard();
        view.redraw();
        turnMessage();

        if(player == Player.BLACK){
            communication.waitMove();
        }
    }

    public void checkClick(double clickedX, double clickedY) {
        int x, y;
        Piece p;

            if (clickedX >= 0 && clickedY >= 0) {
                x = (int) (clickedX / 60);
                y = this.board.getHeight() - 1 - (int) (clickedY / 60);
                p = this.board.getPieceAtCoordinate(x, y);

                if (p != null) {
                    if (p.getPlayer() == player) {
                        this.chosenPiece = p;
                        System.out.println(chosenPiece.getPlayer() + " " + chosenPiece.getName());
                    } else {
                        if (chosenPiece == null) {
                            return;
                        }
                        movePieceToOpponentCell(p);
                    }
                } else if (chosenPiece != null) {

                    movePieceToEmptyCell(x, y);
            }
        }
    }

    private void movePieceToOpponentCell(Piece opponent) {
        List<Coordinates> coord = chosenPiece.getPossibleCoordinates();
        for (Coordinates curCoord : coord) {
            if (opponent.getXCoord() == curCoord.getX() && opponent.getYCoord() == curCoord.getY()) {
                removeMessage(chosenPiece, opponent);
                communication.sendMove(opponent);
                communication.sendMove(chosenPiece, curCoord.getX(), curCoord.getY());
                boardView.drawPieceNull(opponent.getXCoord(), opponent.getYCoord());
                removePiece(opponent);
                boardView.drawPieceNull(chosenPiece.getXCoord(), chosenPiece.getYCoord());
                chosenPiece.setCoordinate(curCoord.getX(), curCoord.getY());
                boardView.drawPiece(chosenPiece);
                turnMessage();
//                view.redraw();
                communication.waitMove();
                if(isCheckmate()){
                    gameOver();
                }
            }
        }
    }

    private void movePieceToEmptyCell(int x, int y) {
        List<Coordinates> coord = chosenPiece.getPossibleCoordinates();
        for (Coordinates curCoord : coord) {
            if (curCoord.getX() == x && curCoord.getY() == y) {
                boardView.drawPieceNull(chosenPiece.getXCoord(), chosenPiece.getYCoord());
                communication.sendMove(chosenPiece, x, y);
                communication.setEndMove(true);
                chosenPiece.setCoordinate(x, y);
                turnMessage();
                boardView.drawPiece(chosenPiece);
                chosenPiece = null;
                communication.waitMove();
            }
        }
    }

    private void gameOver(){
//        int result = JOptionPane.showConfirmDialog(
//                view,"Победа " + chosenPiece.getPlayer() +"\nНачать заново?",
//                "Шах и мат",JOptionPane.YES_NO_OPTION);
//        if(result == JOptionPane.YES_OPTION) {
//            resetGame();
//        }
//        if(result == JOptionPane.NO_OPTION){
//            System.exit(0);
//        }
        JOptionPane.showMessageDialog(null,
                "Игра окончена!",
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private void resetGame(){
        view.frame.dispose();
        board = null;
        view = null;
    }

    private void removePiece(Piece p){
        if(p == board.getWhiteKing()) {
            board.setWhiteKingNull();
        }
        if(p == board.getBlackKing()){
            board.setBlackKingNull();
        }
        p.removeSelf();
    }

    private boolean isCheckmate(){
        if(board.getBlackKing() == null || board.getWhiteKing() == null){
            return true;
        } else {
            return false;
        }
    }

    public Communication getCommunication(){
        return communication;
    }

    public Player getPlayer(){
        return player;
    }

    private void turnMessage() {
        if(player == Player.WHITE) {
            System.out.println("Ход Белых");
        } else {
            System.out.println("Ход Чёрных");
        }
    }

    private void removeMessage(Piece chosen, Piece opponent){
        System.out.println(chosen.getPlayer() + " " + chosenPiece.getName() +
                " съел " + opponent.getPlayer() + " " + opponent.getName());
    }

}