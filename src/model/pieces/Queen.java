package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(ChessBoard board, Player player){
        super("Ферзь",board,player);
        if(player == Player.WHITE){
            this.imagePath = "src/wresources/White_Queen.png";
        } else {
            this.imagePath = "src/wresources/Black_Queen.png";
        }
    }

    public List<Coordinates> getPossibleCoordinates(){
        List<Coordinates> coord = new ArrayList<>();

        // вверх
        for(int y = yCoord + 1; y < board.getHeight(); y++) {
            if (isValidCoordinates(coord, xCoord, y)) {
                break;
            }
        }
        // вниз
        for(int y = yCoord - 1; y < board.getHeight() && y >= 0; y--) {
            if (isValidCoordinates(coord,xCoord, y)) {
                break;
            }
        }
        // влево
        for(int x = xCoord - 1; x >= 0; x--) {
            if (isValidCoordinates(coord, x, yCoord)) {
                break;
            }
        }
        // вправо
        for(int x = xCoord + 1; x < board.getWidth(); x++) {
            if (isValidCoordinates(coord, x, yCoord)) {
                break;
            }
        }
        // вверх вправо
        for(int ix = getXCoord() + 1, jy = getYCoord() + 1; ix < board.getWidth() && jy < board.getHeight(); ix++, jy++ ) {
            if(isValidCoordinates(coord,ix,jy)) {
                break;
            }
        }
        // вверх влево
        for(int ix = getXCoord() - 1, jy = getYCoord() + 1; ix >= 0 && jy < board.getHeight(); ix--, jy++ ) {
            if (isValidCoordinates(coord, ix, jy)) {
                break;
            }
        }
        // вниз вправо
        for(int ix = getXCoord() + 1, jy = getYCoord() - 1; ix < board.getWidth() && jy >= 0; ix++, jy-- ) {
            if (isValidCoordinates(coord, ix, jy)) {
                break;
            }
        }

        // вниз влево
        for(int ix = getXCoord() - 1, jy = getYCoord() - 1; ix >= 0 && jy >= 0; ix--, jy-- ) {
            if(isValidCoordinates(coord,ix,jy)) {
                break;
            }
        }
        return coord;
    }

}
