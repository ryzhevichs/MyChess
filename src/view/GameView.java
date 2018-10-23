package view;

import model.Player;
import server.controller.GameController;
import model.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class GameView extends JPanel {

    protected ChessBoard board;
    private GameController controller;
    private ChessBoardView boardView;

    private int cell_size;
    private int boardWidth;
    private int boardHeight;
    private Socket socket;
    private Player player;
    public JFrame frame;

    private int topPanelWidth = 30;
    private int topPanelHeight = 30;

    public GameView(ChessBoard chessBoard, Socket socket, Player player, int cell, GameController controller){
        cell_size = cell;
        this.socket = socket;
        this.player = player;
        board = chessBoard;
        boardHeight = board.getHeight() * cell_size ;
        boardWidth = board.getWidth() * cell_size ;
        this.controller = controller;
        boardView = new ChessBoardView(board, this.controller, cell_size, boardWidth, boardHeight,socket, player);
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.setPreferredSize(new Dimension(boardWidth , boardHeight));
    }


    public void redraw(){
        boardView.repaint();
    }

    public void initWindow(){

        this.add(boardView,BorderLayout.CENTER);

        frame = new JFrame(player.getColor());
        frame.setBackground(new Color(255, 206, 158));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.magenta);

        frame.getContentPane().setPreferredSize(new Dimension(boardWidth + topPanelWidth,
                boardHeight + topPanelHeight));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
    }

    public ChessBoardView getChessBoardView() {
        return this.boardView;
    }
}
