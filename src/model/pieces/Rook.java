package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;

public class Rook extends  Piece {
    public Rook(ChessBoard board, Player player) {
        super("Ладья", board, player);
        if(player == Player.WHITE){
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/White_Rook.png";
        } else {
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/Black_Rook.png";
        }
    }

    public ArrayList<Coordinates> getPossibleCoordinates(){
        ArrayList<Coordinates> coord = new ArrayList<>();

        // вверх
        for(int y = yCoord + 1; y < board.getHeight(); y++) {
            if(isValidCoordinates(xCoord, y)){
                coord.add(new Coordinates(xCoord, y));
                continue;
            }
            break;
        }
        // вниз
        for(int y = yCoord - 1; y < board.getHeight() && y >= 0; y--) {
            if(isValidCoordinates(xCoord, y)){
                coord.add(new Coordinates(xCoord, y));
                continue;
            }
            break;
        }
        // влево
        for(int x = xCoord - 1; x >= 0; x--) {
            if(isValidCoordinates(x, yCoord)){
                coord.add(new Coordinates(x, yCoord));
                continue;
            }
            break;
        }
        // вправо
        for(int x = xCoord + 1; x < board.getWidth(); x++) {
            if(isValidCoordinates(x, yCoord)){
                coord.add(new Coordinates(x, yCoord));
                continue;
            }
            break;
        }
        return coord;
    }

}
