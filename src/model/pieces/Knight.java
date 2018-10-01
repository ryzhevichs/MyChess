package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;

public  class Knight extends  Piece {

    public Knight(ChessBoard board, Player player){
        super("Слон", board, player);
        if(player == Player.WHITE){
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/White_Knight.png";
        } else {
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/Black_Knight.png";
        }
    }

    public ArrayList<Coordinates> getPossibleCoordinates(){
        ArrayList<Coordinates> coord = new ArrayList<>();
        int x = getXCoord();
        int y = getYCoord();

        int possibleMove = (player == Player.WHITE ? 1 : -1);

        //вверх*2 вправо
        if(isValidCoordinates(x + 1, y + possibleMove * 2 )){
            coord.add(new Coordinates(x + 1, y + possibleMove * 2));
        }
        //вверх*2 влево
        if(isValidCoordinates(x - 1, y + possibleMove * 2 )){
            coord.add(new Coordinates(x - 1, y + possibleMove * 2));
        }
        //вверх вправо*2
        if(isValidCoordinates(x + 2 , y + possibleMove)){
            coord.add(new Coordinates(x + 2, y + possibleMove));
        }
        //вверх влево*2
        if(isValidCoordinates(x - 2, y + possibleMove )){
            coord.add(new Coordinates(x - 2, y + possibleMove));
        }
        //вниз*2 вправо
        if(isValidCoordinates(x + 1, y - possibleMove * 2 )){
            coord.add(new Coordinates(x + 1, y - possibleMove * 2));
        }
        //вниз*2 влево
        if(isValidCoordinates(x - 1, y - possibleMove * 2 )){
            coord.add(new Coordinates(x - 1, y - possibleMove * 2));
        }
        //вниз вправо*2
        if(isValidCoordinates(x + 2, y - possibleMove * 2 )){
            coord.add(new Coordinates(x + 2, y - possibleMove * 2));
        }
        //вниз влево*2
        if(isValidCoordinates(x - 2, y - possibleMove * 2 )){
            coord.add(new Coordinates(x - 2, y + possibleMove - 2));
        }
        return coord;
    }

}
