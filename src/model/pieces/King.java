package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class King extends  Piece {

    public boolean isKingLive = true;

    public King(ChessBoard board, Player player){
        super ("Король", board, player);
        if(player == Player.WHITE){
            this.imagePath = "src/wresources/White_King.png";
        } else {
            this.imagePath = "src/wresources/Black_King.png";
        }
    }

    public boolean isKingLive(){
        return isKingLive;
    }

    public List<Coordinates> getPossibleCoordinates(){
        List<Coordinates> coord = new ArrayList<>();
        //вверх
        if(isValidCoordinates(xCoord, yCoord + 1)){
            coord.add(new Coordinates(xCoord, yCoord + 1));
        }
        //вверх вправо
        if(isValidCoordinates(xCoord + 1, yCoord + 1)){
            coord.add(new Coordinates(xCoord + 1, yCoord + 1));
        }
        //вправо
        if(isValidCoordinates(xCoord + 1, yCoord)){
            coord.add(new Coordinates(xCoord + 1, yCoord));
        }
        //вниз вправо
        if(isValidCoordinates(xCoord + 1, yCoord - 1)){
            coord.add(new Coordinates(xCoord + 1, yCoord - 1));
        }
        //вниз
        if(isValidCoordinates(xCoord, yCoord-1)){
            coord.add(new Coordinates(xCoord, yCoord-1));
        }
        //влево вниз
        if(isValidCoordinates(xCoord -1, yCoord -1)){
            coord.add(new Coordinates(xCoord -1, yCoord -1));
        }
        //влево
        if(isValidCoordinates(xCoord - 1, yCoord)){
            coord.add(new Coordinates(xCoord - 1, yCoord));
        }
        //влево вверх
        if(isValidCoordinates(xCoord - 1, yCoord + 1)){
            coord.add(new Coordinates(xCoord - 1, yCoord +1));
        }


        return coord;
    }

}
