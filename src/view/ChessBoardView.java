package view;

import model.Player;
import server.controller.Communication;
import server.controller.GameController;
import model.ChessBoard;
import model.pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Socket;

public class ChessBoardView extends JPanel{
    private ChessBoard board;
    private GameController controller;
    private Communication communication;
    private Player player;
    private int cell_size;
    private JButton button;

//    private  ActionController actionController;
//
    private double mouseX = -1;
    private double mouseY = -1;

    public ChessBoardView(ChessBoard board, GameController controller, int cell_size,
                          int boardWidth, int boardHeight, Socket socket, Player player, JButton button) {
        this.board = board;
        this.controller = controller;
        this.cell_size = cell_size;
        communication = controller.getCommunication();
        this.player = player;

        this.setPreferredSize(new Dimension(boardWidth, boardHeight));

//        actionController = new ActionController(controller, communication);
//        addMouseListener(actionController);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouseX = e.getPoint().getX();
                mouseY = e.getPoint().getY();
                int outY = board.getHeight() - 1 - (int) (mouseY / 60);
                int outX = (int) (mouseX / 60);
                System.out.println("X = " + outX + " Y = " + outY);
                repaint();
                controller.checkClick(mouseX, mouseY);

            }
        });

    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBoard(g2d);
        drawCoord(g2d);
    }

    private void drawCell(Graphics2D g2d, int x, int y, Color color){
        g2d.setColor(color);
        g2d.fillRect(x,y,cell_size,cell_size);
    }

    private void drawCoord(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("TimesRoman",Font.BOLD,18));
        String [] str = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++){
                int x = i * 60 + 30;
                int y = getHeight() - 10;
                g2d.drawString(str[i], x, y);
            }
             for (int j = 0; j < 8; j++){
                int x = getWidth() - 20;
                int y = j * 60 + 30;
                g2d.drawString(String.valueOf(8-j),x,y); }
    }

    private void drawPiece(Graphics2D g2d, Piece p) {
        int pieceCoordX = p.getXCoord();
        int pieceCoordY = p.getYCoord();
        int x = pieceCoordX * cell_size;
        int y = (board.getHeight() - pieceCoordY - 1) * cell_size;
        try {
            BufferedImage image = ImageIO.read(new File(p.getImagePath()));
            g2d.drawImage(image, x, y, cell_size, cell_size, null);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображения!");
            System.exit(0);
        }
    }

    public void drawPieceNull(int x, int y){
        Graphics2D g2d = (Graphics2D) getGraphics();
        int pieceCoordX = x;
        int pieceCoordY = y;
        int xCell = pieceCoordX * cell_size;
        int yCell = (board.getHeight() - pieceCoordY - 1) * cell_size;

        if((x+y) % 2 == 0){
            drawCell(g2d,xCell,yCell,new Color(209, 139, 71));
        } else {
            drawCell(g2d,xCell,yCell,new Color(255, 206, 158));
        }

    }

        public void drawPiece( Piece p){
            Graphics2D g2d = (Graphics2D) getGraphics();
            int pieceCoordX = p.getXCoord();
            int pieceCoordY = p.getYCoord();
            int x = pieceCoordX * cell_size;
            int y = (board.getHeight() - pieceCoordY - 1) * cell_size;
            try {
                BufferedImage image = ImageIO.read(new File(p.getImagePath()));
                g2d.drawImage(image, x ,y, cell_size, cell_size, null);
            } catch (Exception e){
                System.out.println("Ошибка загрузки изображения!");
                System.exit(0);
            }


        }

    public void drawBoard(Graphics2D g2d){
        int count = 0;
        int x, y;

        Color color;
        Piece p;

        for (int i =0; i < board.getHeight(); i++){
            for (int j = 0; j < board.getWidth(); j++){
                x = j * cell_size;
                y = i * cell_size;

                if(count % 2 == 0){
                     color = new Color(255, 206, 158);
                } else {
                    color = new Color(209, 139, 71);
                }
                if (mouseX>= x && mouseX < x + cell_size &&
                        mouseY >= y && mouseY < y +cell_size){
                     color = new Color(140, 91, 49);
                }
                drawCell(g2d, x, y, color);
                count++;
            }
            count++;
        }
        for (int i =0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                p = board.getPieceAtCoordinate(j, i);
                if (p != null) {
                    drawPiece(g2d, p);
                }
            }
        }

    }
}
