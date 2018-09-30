package model.Pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;

public class King extends  Piece {

    public King(ChessBoard board, Player player){
        super ("king", board, player);
        if(player == Player.WHITE){
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/White_King.png";
        } else {
            this.imagePath = "E:/5sem/PPvIS/MyChess/src/wresources/Black_King.png";
        }
    }

    public ArrayList<Coordinates> getPossibleCoordinates(){
        ArrayList<Coordinates> coord = new ArrayList<>();
        return coord;
    }

}
