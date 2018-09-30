package view;

import controller.GameController;
import model.ChessBoard;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    protected ChessBoard board;
    protected GameController controller;
    protected ChessBoardView boardView;

    private int cell_size;
    private int boardWidth;
    private int boardHeight;

    private int topPanelWidth = 30;
    private int topPanelHeight = 30;

    public GameView(ChessBoard chessBoard, int cell){
        cell_size = cell;
        board = chessBoard;
        boardHeight = board.getHeight() * cell_size ;
        boardWidth = board.getWidth() * cell_size ;

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        boardView = null;

        this.setPreferredSize(new Dimension(boardWidth , boardHeight));
    }

    public void setController(GameController gameController){
        controller = gameController;
    }

    public void redraw(){
        boardView.repaint();
    }

    public void initWindow(){

        boardView = new ChessBoardView(board, controller, cell_size, boardWidth,
                boardHeight);

        this.add(boardView,BorderLayout.CENTER);

        JFrame frame = new JFrame("Chess");
        frame.setBackground(new Color(255, 206, 158));

        JPanel westPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.magenta);
        westPanel.setBackground(Color.cyan);
//        westPanel.setSize(new Dimension(ge));
//        frame.add(westPanel,BorderLayout.SOUTH);
//        frame.add(westPanel, BorderLayout.WEST);
//        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.getContentPane().setPreferredSize(new Dimension(boardWidth + topPanelWidth,
                boardHeight + topPanelHeight));
        frame.pack();
        frame.setVisible(true);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
    }

}
