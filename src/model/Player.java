package model;

public enum  Player {
    WHITE, BLACK;

    public Player changePlayer(){
        if(this == WHITE){
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
