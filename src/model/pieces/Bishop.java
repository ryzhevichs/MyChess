package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(ChessBoard board, Player player) {
        super("Слон", board, player);
        if(player == Player.WHITE){
            this.imagePath = "src/wresources/White_Bishop.png";
        } else {
            this.imagePath = "src/wresources/Black_Bishop.png";
        }

    }

    public List<Coordinates> getPossibleCoordinates(){
        List<Coordinates> coord = new ArrayList<>();

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
