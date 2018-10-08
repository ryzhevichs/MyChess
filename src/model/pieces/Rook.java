package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Rook extends  Piece {
    public Rook(ChessBoard board, Player player) {
        super("Ладья", board, player);
        if(player == Player.WHITE){
        this.imagePath = "src/wresources/White_Rook.png";
        } else {
            this.imagePath = "src/wresources/Black_Rook.png";
        }
    }

    public List<Coordinates> getPossibleCoordinates(){
        List<Coordinates> coord = new ArrayList<>();

        // вверх
        for(int y = yCoord + 1; y < board.getHeight(); y++) {
            if(isValidCoordinates(coord, xCoord, y)) {
                break;
            }
        }
        // вниз
        for(int y = yCoord - 1; y < board.getHeight() && y >= 0; y--) {
            if(isValidCoordinates(coord, xCoord, y)) {
                break;
            }
        }
        // влево
        for(int x = xCoord - 1; x >= 0; x--) {
            if(isValidCoordinates(coord, x, yCoord)) {
                break;
            }
        }
        // вправо
        for(int x = xCoord + 1; x < board.getWidth(); x++) {
            if(isValidCoordinates(coord, x, yCoord)) {
                break;
            }
        }
        return coord;
    }

}
