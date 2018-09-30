package model.Pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(ChessBoard board, Player player){
        super("Queen",board,player);
        if(player == Player.WHITE){
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/White_Queen.png";
        } else {
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/Black_Queen.png";
        }
    }

    public ArrayList<Coordinates> getPossibleCoordinates(){
        ArrayList<Coordinates> coord = new ArrayList<>();
        return coord;
    }

}
