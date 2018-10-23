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

    public String getColor(){
        if(this == WHITE){
            return "White";
        } else {
            return "Black";
        }
    }
}
