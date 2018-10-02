import controller.GameController;
import model.ChessBoard;
import view.GameView;

public class Main {

    public static void main(String[] args){
        new GameController().startGame();
    }
//    public Main(ChessBoard board, GameController gameController, GameView gameView){
//        this.board = board;
//        this.controller = gameController;
//        this.view = gameView;
//        view.setController(controller);
//
//    }
//    public void start(){
//        view.initWindow();
//        controller.startGame();
//    }

//    public static void main(String[] args) {
//        ChessBoard board;
//        GameView view;
//        GameController controller;
//        board = new ChessBoard(8,8);
//        view = new GameView(board, 60);
//        controller = new GameController(board, view);
//
//        Main main = new Main(board, controller, view);
//        main.start();
//    }

}
