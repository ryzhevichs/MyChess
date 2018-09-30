package model.Pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(ChessBoard board, Player player) {
        super("bishop", board, player);
        if(player == Player.WHITE){
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/White_Bishop.png";
        } else {
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/Black_Bishop.png";
        }

    }

    public ArrayList<Coordinates> getPossibleCoordinates(){
        ArrayList<Coordinates> coord = new ArrayList<>();
        int x = getXCoord();
        int y = getYCoord();
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
