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
        // вверх вправо
        for(int ix = getXCoord() + 1, jy = getYCoord() + 1; ix < board.getWidth() && jy < board.getHeight(); ix++, jy++ ) {
            if(isValidCoordinates(ix,jy)){
                coord.add(new Coordinates(ix,jy));
                continue;
            }
            break;
        }
        // вверх влево
        for(int ix = getXCoord() - 1, jy = getYCoord() + 1; ix >= 0 && jy < board.getHeight(); ix--, jy++ ) {
            if(isValidCoordinates(ix,jy)){
                coord.add(new Coordinates(ix,jy));
                continue;
            }
            break;
        }
        // вниз вправо
        for(int ix = getXCoord() + 1, jy = getYCoord() - 1; ix < board.getWidth() && jy >= 0; ix++, jy-- ) {
            if(isValidCoordinates(ix,jy)){
                coord.add(new Coordinates(ix,jy));
                continue;
            }
            break;
        }
        // вниз влево
        for(int ix = getXCoord() - 1, jy = getYCoord() - 1; ix >= 0 && jy >= 0; ix--, jy-- ) {
            if(isValidCoordinates(ix,jy)){
                coord.add(new Coordinates(ix,jy));
                continue;
            }
            break;
        }


        return coord;
    }

}
