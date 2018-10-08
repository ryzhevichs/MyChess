package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private String name;

    protected int xCoord;
    protected int yCoord;

    protected Player player;
    protected ChessBoard board;

    protected String imagePath;

    public Piece(String name, ChessBoard board, Player player){
        this.name = name;
        this.board = board;
        this.player = player;
        this.xCoord = -1;
        this.yCoord = -1;

        this.board.addPieceToList(this);
    }


    protected boolean isValidCoordinates(List<Coordinates> coord, int x, int y){
        if (x < 0 || y < 0 || x >= board.getWidth() || y >= board.getHeight()) {
            return true;
        }
        if (board.getPieceAtCoordinate(x, y) == null){
            coord.add(new Coordinates(x, y));
            return false;
        }

        if (board.getPieceAtCoordinate(x, y).getPlayer() != player ){
            coord.add(new Coordinates(x, y));
            return true;
        } else {
            return true;
        }
    }

    public boolean setCoordinate(int x, int y){
        if(x > board.getWidth() || y > board.getHeight() || x < 0 || y <0 ){
            return false;
        }
        if(xCoord != -1 && yCoord != -1){
            removeSelf();
        }
        this.xCoord = x;
        this.yCoord = y;

        board.setPieceAtCoordinate(this, x, y);
        return  true;
    }

    public abstract List<Coordinates> getPossibleCoordinates();

    public void removeSelf(){

        board.removePiece(this);
        this.xCoord = -1;
        this.yCoord = -1;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }
}
