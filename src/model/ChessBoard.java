package model;

import model.pieces.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Serializable {

    public static int BOARD_WIDTH;
    public static int BOARD_HEIGHT;

    private Piece tiles[][];
    private List<Piece> white;
    private List<Piece> black;
    private Piece kingWhite;
    private Piece kingBlack;


    public ChessBoard(int width, int height){
        BOARD_WIDTH = width;
        BOARD_HEIGHT = height;

        tiles = new Piece[BOARD_HEIGHT][];
        for (int i = 0; i < BOARD_HEIGHT; i++){
            tiles[i] = new Piece[BOARD_WIDTH];
        }
        white = new ArrayList<>();
        black = new ArrayList<>();
    }


    public void addPieceToList(Piece p){
        if (p.getPlayer() == Player.WHITE){
            white.add(p);
        } else {
            black.add(p);
        }
    }

    public void setPiecesOnBoard() {
        Piece p;

        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(0, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(1, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(2, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(3, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(4, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(5, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(6, 1);
        p = new Pawn(this, Player.WHITE);
        p.setCoordinate(7, 1);

        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(0, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(1, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(2, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(3, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(4, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(5, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(6, 6);
        p = new Pawn(this, Player.BLACK);
        p.setCoordinate(7, 6);

        p = new Bishop(this, Player.WHITE);
        p.setCoordinate(2, 0);
        p = new Bishop(this, Player.WHITE);
        p.setCoordinate(5, 0);


        p = new Bishop(this, Player.BLACK);
        p.setCoordinate(2, 7);
        p = new Bishop(this, Player.BLACK);
        p.setCoordinate(5, 7);

        p = new Knight(this, Player.WHITE);
        p.setCoordinate(1, 0);
        p = new Knight(this, Player.WHITE);
        p.setCoordinate(6, 0);

        p = new Knight(this, Player.BLACK);
        p.setCoordinate(1, 7);
        p = new Knight(this, Player.BLACK);
        p.setCoordinate(6, 7);

        p = new Rook(this, Player.WHITE);
        p.setCoordinate(0, 0);
        p = new Rook(this, Player.WHITE);
        p.setCoordinate(7, 0);

        p = new Rook(this, Player.BLACK);
        p.setCoordinate(0, 7);
        p = new Rook(this, Player.BLACK);
        p.setCoordinate(7, 7);

        kingWhite = new King(this, Player.WHITE);
        kingWhite.setCoordinate(4, 0);
        kingBlack = new King(this, Player.BLACK);
        kingBlack.setCoordinate(4, 7);

        p = new Queen(this, Player.WHITE);
        p.setCoordinate(3, 0);

        p = new Queen(this, Player.BLACK);
        p.setCoordinate(3, 7);
    }

    public void setPieceAtCoordinate (Piece p, int x, int y){

        tiles[y][x] = p;
    }

    public Piece getPieceAtCoordinate(int x, int y){

        if (x >= getWidth() || x < 0 || y >= getHeight() || y <0){
            return null;
        } else {

            return tiles[y][x];
        }
    }

    public void removePiece(Piece p){
        int x = p.getXCoord();
        int y = p.getYCoord();

        this.tiles[y][x] = null;
    }

    public void removePieceAtCoord(int x, int y){
        Piece p = getPieceAtCoordinate(x, y);
        if(p == this.getWhiteKing()) {
            this.setWhiteKingNull();
        }
        if(p == this.getBlackKing()){
            this.setBlackKingNull();
        }
        p.removeSelf();
        this.tiles[y][x] = null;

    }

    public void setPieceAtNewCoordinate(Piece piece, Coordinates oldCoord, Coordinates newCoord) {
        Piece p = getPieceAtCoordinate(oldCoord.getX(), oldCoord.getY());
        p.setCoordinate(newCoord.getX(), newCoord.getY());
    }


    public void setWhiteKingNull(){
        System.out.println("Белый король занулен");
        kingWhite = null;
    }

    public void setBlackKingNull(){
        System.out.println("Черный король занулен");
        kingBlack = null;
    }

    public Piece getWhiteKing(){
        return kingWhite;
    }

    public Piece getBlackKing(){
        return kingBlack;
    }


    public  int getWidth() {
        return BOARD_WIDTH;
    }

    public  int getHeight() {
        return BOARD_HEIGHT;
    }

    public boolean isCheckmate(){
        if(this.getBlackKing() == null || this.getWhiteKing() == null){
            return true;
        } else {
            return false;
        }
    }
}
