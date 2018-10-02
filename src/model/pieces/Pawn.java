package model.pieces;

import model.ChessBoard;
import model.Coordinates;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends  Piece{
    private boolean isFirstMove ;

    public Pawn(ChessBoard board, Player player){
        super("Пешка", board,player);
        isFirstMove = true;
        if(player == Player.WHITE){
            this.imagePath = "src/wresources/White_Pawn.png";
        } else {
            this.imagePath = "src/wresources/Black_Pawn.png";
        }
    }

    @Override
    public boolean setCoordinate(int x, int y) {
        if (xCoord == -1 && yCoord == -1){
            isFirstMove = true;
        }
        else {
            isFirstMove = false;
        }
        return super.setCoordinate(x, y);
    }

    public List<Coordinates> getPossibleCoordinates(){
        int x = xCoord;
        int y = yCoord;
        ChessBoard board = this.board;

        List<Coordinates> coord = new ArrayList<>();
        int possibleMove = (player == Player.WHITE? 1 : -1);

        if(y + possibleMove >= board.getHeight() || y + possibleMove < 0){
            return coord;
        }
        // если впереди не занято
        if(board.getPieceAtCoordinate(x, y+ possibleMove) != null ){
        } else {
            coord.add(new Coordinates(x, y + possibleMove));
        }
        // первый ход * 2
        if(isFirstMove && board.getPieceAtCoordinate(x, y + possibleMove ) == null &&
                board.getPieceAtCoordinate(x, y + possibleMove * 2) == null){
            coord.add(new Coordinates(x,y + possibleMove * 2));
        }
        // если слева по диагонали враг
        if(board.getPieceAtCoordinate(x-1, y + possibleMove) != null &&
                board.getPieceAtCoordinate(x - 1, y +possibleMove).player != this.player){
            coord.add(new Coordinates(x-1, y + possibleMove));
        }
        // если справа по диагонали враг
        if(board.getPieceAtCoordinate(x + 1, y + possibleMove) !=null &&
                board.getPieceAtCoordinate(x + 1, y + possibleMove).player != this.player){
            coord.add(new Coordinates(x + 1, y + possibleMove));
        }

        return coord;
    }


}
