import client.ClientApplication;
import controller.GameController;
import model.ChessBoard;
import server.ServerApplication;
import view.GameView;

public class Main {
//
//    @Override
//    public void run() {
//        new Thread(new ServerApplication()).start();
//        new Thread(new ClientApplication()).start();
//
//    }

    public static void main(String[] args){
        new GameController().startGame();

    }
}
