package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public  class Knight extends  Piece {

    public Knight(ChessBoard board, Player player){
        super("Конь", board, player);
        if(player == Player.WHITE){
            this.imagePath = "src/wresources/White_Knight.png";
        } else {
            this.imagePath = "src/wresources/Black_Knight.png";
        }
    }

    public List<Coordinates> getPossibleCoordinates(){
        List<Coordinates> coord = new ArrayList<>();
        int x = getXCoord();
        int y = getYCoord();

        int possibleMove = (player == Player.WHITE ? 1 : -1);

        //вверх*2 вправо
        isValidCoordinates(coord,x + 1, y + possibleMove * 2 );
        //вверх*2 влево
        isValidCoordinates(coord,x - 1, y + possibleMove * 2 );
        //вверх вправо*2
        isValidCoordinates(coord,x + 2 , y + possibleMove);
        //вверх влево*2
        isValidCoordinates(coord,x - 2, y + possibleMove);
        //вниз*2 вправо
        isValidCoordinates(coord,x + 1, y - possibleMove * 2 );
        //вниз*2 влево
        isValidCoordinates(coord,x - 1, y - possibleMove * 2 );
        //вниз вправо*2
        isValidCoordinates(coord,x + 2, y - possibleMove * 2 );
        //вниз влево*2
        isValidCoordinates(coord,x - 2, y - possibleMove * 2 );

        return coord;
    }

}
