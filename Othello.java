
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * File Name: Othello.java
 *   Created: May 9, 2014
 *    Author: Sung Min Choi Hong
 *    This code sucks...
 */

public class Othello extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
// Declare instance variables here...
  private Board board;
private Button reset;
private Button leave;
  @SuppressWarnings("unused")
private int[][] blackwhite;
  JFrame frame;
  
  // Constructor
  public Othello(int w, int h, JFrame f)
  {
    board = new Board(this);
    blackwhite = board.getGrid();
    frame = f;
    
    super.setOpaque(true);
    super.setPreferredSize(new Dimension(w, h));
    super.setBackground(Color.GRAY);
    super.setLayout(null);
    newGame();

    reset = new Button("Reset");
    reset.setBounds(475,50,100,25);
    super.add(reset);
    reset.addActionListener(this);
    
    leave = new Button("Leave");
    leave.setBounds(475,80,100,25);
    super.add(leave);
    leave.addActionListener(this);
//    
//    chaosBlack = new Button("Black mess up");
//    chaosBlack.setBounds(700,25,100,50);
//    super.add(chaosBlack);
//    chaosBlack.addActionListener(this);
    
  }
  
  public void newGame()
  {
    board.setBounds(50,50,400,400);
    super.add(board);
  }
  
  public void refresh()
  {
      super.repaint();
  }
  
  // Perform any custom painting (if necessary) in this method
  @Override  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    
    
    g.setFont(new Font("ComicSans", Font.PLAIN, 22));
    g.drawString("Player's Turn:", 460, 150);
    if (board.getTurn()%2 == 1)
    {
        g.setColor(Color.WHITE);
        g.drawString("White", 495, 200);   
    }
    else if (board.getTurn()%2 == 0)
    {
        g.setColor(Color.BLACK);
        g.drawString("Black", 495, 200);
    }
    int black = board.blackPoints();
    int white = board.whitePoints();
    
    g.setColor(Color.WHITE);
    g.drawString("White: "+white, 485, 300);
    g.setColor(Color.BLACK);
    g.drawString("Black: "+black, 485, 350);
    
    if (board.GameOver() == true)
    {
        if (black > white)
        {
            g.setColor(Color.BLACK);
            g.drawString("GAME OVER", 460, 450);
            g.drawString("BLACK WINS", 460, 500);
        }
        else if (white > black)
        {
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", 460, 450);
            g.drawString("WHITE WINS", 460, 500);
        }
    }    
  }
  
  // Process GUI input in this method
  @Override  
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() instanceof Button)
    {
      Button temp = (Button) e.getSource();
      if (temp == reset)
      {
          board.restart();
      }
      if (temp == leave)
      {
    	  
    	  frame.dispose();
      }
//      if (temp == chaosBlack)
//      {
//          board.chaosblack();
//      }
    }
    super.repaint();
  }
  
  //<editor-fold defaultstate="collapsed" desc="--This method will launch your application--">
  public static void main(String[] args)
  {
    JFrame.setDefaultLookAndFeelDecorated(false);
    JFrame fr = new JFrame("Application: Othello");
    fr.setContentPane(new Othello(600, 500, fr));
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setLocation(10, 10);
    fr.setResizable(false);
    fr.pack();
    fr.setVisible(true);  
  }
  //</editor-fold>  

}