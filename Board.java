import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel; 


/*
 * File Name: Board.java
 *   Created: May 15, 2014
 *    Author: Sung Min
 */

public class Board extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
private Button[][] buttongrid;
  private int[][] blackwhite;
  private int turn;
  private Othello main;
  @SuppressWarnings("unused")
private boolean stopC;
  
  public Board(Othello o)
  {
    main = o;
    blackwhite = new int[8][8];
    buttongrid = new Button[8][8];
    turn = 1;
    stopC = false;
    
    super.setLayout(null);
    for (int r = 0; r < 8; r++)
    {
      for (int c = 0; c < 8; c++)
      {
        Button temp = new Button();
        buttongrid[r][c] = temp;
        temp.setBounds(c*50,r*50,50,50);
        temp.setBackground(Color.GREEN);
        super.add(temp);
        temp.addActionListener(this);
        blackwhite[r][c] = -1;
      }
    }
    
    buttongrid[3][3].setVisible(false);
    buttongrid[3][4].setVisible(false);
    buttongrid[4][3].setVisible(false);
    buttongrid[4][4].setVisible(false);
    
    blackwhite[3][3] = 1;
    blackwhite[3][4] = 0;
    blackwhite[4][3] = 0;
    blackwhite[4][4] = 1;
    
    
//    blackwhite[1][4] = 0;
//    buttongrid[1][4].setVisible(false);
//    
//    blackwhite[1][6] = 0;
//    buttongrid[1][6].setVisible(false);
//    
    
    
//    for (int r1 = 0; r1 < 8; r1++)
//    {
//        for (int c1 = 0; c1 < 8; c1++)
//        {
//            System.out.print("("+r1+","+c1+")  ");
//        }
//        System.out.println("");
//    }
//    System.out.println("");
//    for (int r2 = 0; r2 < 8; r2++)
//    {
//        for (int c2 = 0; c2 < 8; c2++)
//        {
//            System.out.print("("+r2+","+(7-c2)+")  ");
//        }
//        System.out.println("");
//    }
    
//    for (int r2 = 0; r2 < 8; r2++)
//    {
//        for(int c2 = 0; c2 < 8; c2++)
//        {
//            blackwhite[r2][c2] = 0;
//            buttongrid[r2][c2].setVisible(false);
//        }
//    }
//    blackwhite[2][7] = -1;
//    buttongrid[2][7].setVisible(true);
//    blackwhite[2][6] = 1;
  }

  public void restart()
  {
      turn = 1;
      for (int r = 0; r < 8; r++)
      {
        for (int c = 0; c < 8; c++)
        {
          buttongrid[r][c].setVisible(true);
          blackwhite[r][c] = -1;
        }
      }
      
    buttongrid[3][3].setVisible(false);
    buttongrid[3][4].setVisible(false);
    buttongrid[4][3].setVisible(false);
    buttongrid[4][4].setVisible(false);
    
    blackwhite[3][3] = 1;
    blackwhite[3][4] = 0;
    blackwhite[4][3] = 0;
    blackwhite[4][4] = 1;
    
//    int a = 0;
//    for (int r1 = 2; r1 < 6; r1++)
//    {
//        for (int c1 = 2; c1 < 6; c1++)
//        {
//            blackwhite[r1][c1] = a%2;
//            buttongrid[r1][c1].setVisible(false);
//            a++;
//        }
//        a++;
//    }
    
  }
  
  public int[][] getGrid()
  {
      return blackwhite;
  }
  
  public int getTurn()
  {
      return turn;
  }
  
  public int blackPoints()
  {
      int black = 0;
      for (int r = 0; r < 8; r++)
      {
          for (int c = 0; c < 8; c++)
          {
              if (blackwhite[r][c] == 0)
              {
                  black++;
              }
          }
      }
      return black;
  }
  
  public int whitePoints()
  {
      int white = 0;
      for (int r = 0; r < 8; r++)
      {
          for (int c = 0; c < 8; c++)
          {
              if (blackwhite[r][c] == 1)
              {
                  white++;
              }
          }
      }
      return white;
  }
  
  public boolean gameOverVer1()
  {
//      for (int r = 0; r < 8; r++)
//      {
//          for (int c = 0; c < 8; c++)
//          {
//              if(blackwhite[r][c] == -1)
//              {
//                if (checkCondNorth(r,c) == true || checkCondSouth(r,c) == true || checkCondEast(r,c) == true || checkCondWest(r,c) == true || checkCondNorthEast(r,c) == true || checkCondNorthWest(r,c) == true || checkCondSouthEast(r,c) == true || checkCondSouthWest(r,c) == true)
//                {
//                    System.out.println("a");
//                    System.out.println(turn);
//                    return false;
//                }
////                else if(stopC == false)
////                {
////                    turn++;
////                    main.refresh();
////                    System.out.println("b");
////                    System.out.println(turn);
////                    stopC = true;
////                    
////                }
//              }
//          }
//      }
//      return true;
      return false;
  }
 
  public boolean CanPlace(int r, int c, int player)
  {
    if (checkGameOverNorth(r,c,player) == true || checkGameOverSouth(r,c,player) == true || checkGameOverEast(r,c,player) == true || checkGameOverWest(r,c,player) == true || checkGameOverNorthEast(r,c,player) == true || checkGameOverNorthWest(r,c,player) == true || checkGameOverSouthEast(r,c,player) == true || checkGameOverSouthWest(r,c,player) == true)
    {
        return true;
    }
    return false;
  }
  
  public boolean GameOver()
  {
      for(int r1 = 0; r1 < 8; r1++)
      {
          for (int c1 = 0; c1 < 8; c1++)
          {
              if (blackwhite[r1][c1] == -1)
              {
                if (CanPlace(r1,c1,turn%2) == true)
                {
                    return false;
                }
              }
          }
      }
      for (int r2 = 0; r2 < 8; r2++)
      {
          for (int c2 = 0; c2 < 8; c2++)
          {
              if (blackwhite[r2][c2] == -1)
              {
                  if(CanPlace(r2,c2,(turn+1)%2) == true)
                  {
                      turn++;
                      main.refresh();
                      return false;
                  }
              }
          }
      }
      return true;
  }
  
  public void chaosblack()
  {
//      for (int r = 0; r < 8; r++)
//      {
//          for (int c = 0; c < 8; c++)
//          {
//              if (blackwhite[r][c] != -1)
//              {
//                blackwhite[r][c] = (int) Math.random()*2;
//              }
//          }
//      }
  }
  
  public void flipSouth(int r, int c)
  {
    boolean stop = false;
    for (int scout1 = r; scout1 < 8; scout1++)
    {
      if (blackwhite[scout1][c] == -1)
      {
          break;
      }
      if (blackwhite[scout1][c] == turn%2 && stop == false)
      {
        for(int rerun1 = r; rerun1 < scout1; rerun1++)
        {
          blackwhite[rerun1][c] = turn%2;
          stop = true;
        }
      }
    }
  }
  
  public void flipNorth(int r, int c)
  {
    boolean stop = false;
    for (int scout2 = r; scout2 > -1; scout2--)
    {
      if (blackwhite[scout2][c] == -1)
      {
          break;
      }
      if (blackwhite[scout2][c] == turn%2 && stop == false)
      {
        for(int rerun2 = r; rerun2 > scout2; rerun2--)
        {
          blackwhite[rerun2][c] = turn%2;
          stop = true;
        }
      }
    }
  }
  
  public void flipEast(int r, int c)
  {
    boolean stop = false;
    for (int scout3 = c; scout3 < 8; scout3++)
    {
      if (blackwhite[r][scout3] == -1)
      {
          break;
      }
      if (blackwhite[r][scout3] == turn%2 && stop == false)
      {
        for(int rerun3 = c; rerun3 < scout3; rerun3++)
        {
          blackwhite[r][rerun3] = turn%2;
          stop = true;
        }
      }
    }
  }
  
  public void flipWest(int r, int c)
  {
    boolean stop = false;
    for (int scout4 = c; scout4 > -1; scout4--)
    {
      if (blackwhite[r][scout4] == -1)
      {
          break;
      }
      if (blackwhite[r][scout4] == turn%2 && stop == false)
      {
        for(int rerun4 = c; rerun4 > scout4; rerun4--)
        {
          blackwhite[r][rerun4] = turn%2;
          stop = true;
        }
      }
    }
  }
  
  public void flipSouthEast(int r, int c)
  {
      boolean stop = false;
      if (r > c)
          {
              for (int scout5 = r; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5][scout5-r+c] == turn%2 && stop == false)
                  {
                      for (int rerun5 = r; rerun5 < scout5; rerun5++)
                      {
                          blackwhite[rerun5][rerun5-r+c] = turn%2;
                          stop = true;
                      }
                  }
              }
          }
          else if (r <= c)
          {
              for (int scout5 = c; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5-c+r][scout5] == turn%2 && stop == false)
                  {
                      for (int rerun5 = c; rerun5 < scout5; rerun5++)
                      {
                          blackwhite[rerun5-c+r][rerun5] = turn%2;
                          stop = true;
                      }
                  }
              }
          }
  }
  
  public void flipNorthWest(int r, int c)
  {
    boolean stop = false;
    if (r < c)
    {
        for (int scout6 = r; scout6 > -1; scout6--)
        {
            if (blackwhite[scout6][c-(r-scout6)] == turn%2 && stop == false)
            {
                for (int rerun6 = r; scout6 < rerun6; rerun6--)
                {
                    blackwhite[rerun6][c-(r-rerun6)] = turn%2;
                    stop = true;
                }
            }
        }
    }
    else if (r >= c)
    {
        for (int scout6 = c; scout6 > -1; scout6--)
        {
             if (blackwhite[r-(c-scout6)][scout6] == turn%2 && stop == false)
             {
                for (int rerun6 = c; scout6 < rerun6; rerun6--)
                {
                    blackwhite[r-(c-rerun6)][rerun6] = turn%2;
                    stop = true;
                }
             }
        }
     }
  }
  
  public void flipSouthWest(int r, int c)
  {
    boolean stop = false;
    if (r > (7-c))
       {
           for (int scout7 = r; scout7 < 8; scout7++)
           {
               if (blackwhite[scout7][c-(scout7-r)] == turn%2 && stop == false)
               {
                   for (int rerun7 = r; rerun7 < scout7; rerun7++)
                   {
                       blackwhite[rerun7][c-(rerun7-r)] = turn%2;
                       stop = true;
                   }
               }
           }
       }
       else if (r <= (7-c))
       {
           for (int scout7 = c; scout7 > -1; scout7--)
           {
               if (blackwhite[(c-scout7)+r][scout7] == turn%2 && stop == false)
               {
                   for (int rerun7 = c; rerun7 > scout7; rerun7--)
                   {
                       blackwhite[(c-rerun7)+r][rerun7] = turn%2;
                       stop = true;
                   }
               }
           }
       }
  }
  
  public void flipNorthEast(int r, int c)
  {
    boolean stop = false;
    if (r < (7-c))
       {
           for (int scout8 = r; scout8 > -1; scout8--)
           {
               if (blackwhite[scout8][c+(r-scout8)] == turn%2 && stop == false)
               {
                   for (int rerun8 = r; rerun8 > scout8; rerun8--)
                   {
                       blackwhite[rerun8][c+(r-rerun8)] = turn%2;
                       stop = true;
                   }
               }
           }
       }
       else if (r >= (7-c))
       {
           for (int scout8 = c; scout8 < 8; scout8++)
           {
               if (blackwhite[r-(scout8-c)][scout8] == turn%2 && stop == false)
               {
                   for (int rerun8 = c; rerun8 < scout8; rerun8++)
                   {
                       blackwhite[r-(rerun8-c)][rerun8] = turn%2;
                       stop = true;
                   }
               }
           }
       }
  }
  
  public boolean checkCondSouth(int r, int c)
  {
    if (r+1 < 8)
    {
      if (blackwhite[r+1][c] == (turn+1)%2)
      {
        for (int scout1 = r+1; scout1 < 8; scout1++)
        {
          if (blackwhite[scout1][c] == -1)
          {
              return false;
          }
          if (blackwhite[scout1][c] == turn%2)
          {
              return true;
          }
        }
      }
    }
    return false;
  }
   
  public boolean checkCondNorth(int r, int c)
  {
    if (r-1 > -1)
    {
      if (blackwhite[r-1][c] == (turn+1)%2)
      {
        for (int scout2 = r-1; scout2 > -1; scout2--)
        {
          if (blackwhite[scout2][c] == -1)
          {
              return false;
          }
          if (blackwhite[scout2][c] == turn%2)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkCondEast(int r, int c)
  {
    if (c+1 < 8)
    {
      if (blackwhite[r][c+1] == (turn+1)%2)
      {
        for (int scout3 = c+1; scout3 < 8; scout3++)
        {
          if (blackwhite[r][scout3] == -1)
          {
              return false;
          }
          if (blackwhite[r][scout3] == turn%2)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkCondWest(int r, int c)
  {
    if (c-1 > -1)
    {
      if (blackwhite[r][c-1] == (turn+1)%2)
      {
        for (int scout4 = c-1; scout4 > -1; scout4--)
        {
          if (blackwhite[r][scout4] == -1)
          {
              return false;
          }
          if (blackwhite[r][scout4] == turn%2)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkCondSouthEast(int r, int c)
  {
    if (r+1 < 8 && c+1 < 8)
    {
      if (blackwhite[r+1][c+1] == (turn+1)%2)
      {
          if (r > c)
          {
              for (int scout5 = r+1; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5][scout5-r+c] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[scout5][scout5-r+c] == turn%2)
                  {
                      return true;
                  }
              }
          }
          else if (r <= c)
          {
              for (int scout5 = c+1; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5-c+r][scout5] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[scout5-c+r][scout5] == turn%2)
                  {
                      return true;
                  }
              }
          }
      }
    }
    return false;
  }
  
  public boolean checkCondNorthWest(int r, int c)
  {
    if (r-1 > -1 && c-1 > -1)
    {
      if (blackwhite[r-1][c-1] == (turn+1)%2)
      {
         if (r < c)
         {
             for (int scout6 = r-1; scout6 > -1; scout6--)
             {
                 if (blackwhite[scout6][c-(r-scout6)] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[scout6][c-(r-scout6)] == turn%2)
                 {
                     return true;
                 }
             }
         }
         else if (r >= c)
         {
             for (int scout6 = c-1; scout6 > -1; scout6--)
             {
                  if (blackwhite[r-(c-scout6)][scout6] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[r-(c-scout6)][scout6] == turn%2)
                  {
                      return true;
                  }
             }
          }
      }
    }
    return false;
  }
  
  public boolean checkCondSouthWest(int r, int c)
  {
    if (r+1 < 8 && c-1 > -1)
    {
      if (blackwhite[r+1][c-1] == (turn+1)%2)
      {
         if (r > (7-c))
         {
             for (int scout7 = r+1; scout7 < 8; scout7++)
             {
                 if (blackwhite[scout7][c-(scout7-r)] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[scout7][c-(scout7-r)] == turn%2)
                 {
                     return true;
                 }
             }
         }
         else if (r <= (7-c))
         {
             for (int scout7 = c-1; scout7 > -1; scout7--)
             {
                 if (blackwhite[(c-scout7)+r][scout7] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[(c-scout7)+r][scout7] == turn%2)
                 {
                     return true;
                 }
             }
         }
      }
    }
    return false;
  }
  
  public boolean checkCondNorthEast(int r, int c)
  {
    if (r-1 > -1 && c+1 < 8)
    {
      if (blackwhite[r-1][c+1] == (turn+1)%2)
      {
         if (r < (7-c))
         {
             for (int scout8 = r-1; scout8 > -1; scout8--)
             {
                 if (blackwhite[scout8][c+(r-scout8)] ==-1)
                 {
                     return false;
                 }
                 if (blackwhite[scout8][c+(r-scout8)] == turn%2)
                 {
                     return true;
                 }
             }
         }
         else if (r >= (7-c))
         {
             for (int scout8 = c+1; scout8 < 8; scout8++)
             {
                 if (blackwhite[r-(scout8-c)][scout8] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[r-(scout8-c)][scout8] == turn%2)
                 {
                     return true;
                 }
             }
         }
      }
    } 
    return false;
  }
  
  public boolean checkGameOverSouth(int r, int c, int player)
  {
    if (r+1 < 8)
    {
      if (blackwhite[r+1][c] == (player+1)%2)
      {
        for (int scout1 = r+1; scout1 < 8; scout1++)
        {
          if (blackwhite[scout1][c] == -1)
          {
              return false;
          }
          if (blackwhite[scout1][c] == player)
          {
              return true;
          }
        }
      }
    }
    return false;
  }
   
  public boolean checkGameOverNorth(int r, int c, int player)
  {
    if (r-1 > -1)
    {
      if (blackwhite[r-1][c] == (player+1)%2)
      {
        for (int scout2 = r-1; scout2 > -1; scout2--)
        {
          if (blackwhite[scout2][c] == -1)
          {
              return false;
          }
          if (blackwhite[scout2][c] == player)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkGameOverEast(int r, int c, int player)
  {
    if (c+1 < 8)
    {
      if (blackwhite[r][c+1] == (player+1)%2)
      {
        for (int scout3 = c+1; scout3 < 8; scout3++)
        {
          if (blackwhite[r][scout3] == -1)
          {
              return false;
          }
          if (blackwhite[r][scout3] == player)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkGameOverWest(int r, int c, int player)
  {
    if (c-1 > -1)
    {
      if (blackwhite[r][c-1] == (player+1)%2)
      {
        for (int scout4 = c-1; scout4 > -1; scout4--)
        {
          if (blackwhite[r][scout4] == -1)
          {
              return false;
          }
          if (blackwhite[r][scout4] == player)
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean checkGameOverSouthEast(int r, int c, int player)
  {
    if (r+1 < 8 && c+1 < 8)
    {
      if (blackwhite[r+1][c+1] == (player+1)%2)
      {
          if (r > c)
          {
              for (int scout5 = r+1; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5][scout5-r+c] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[scout5][scout5-r+c] == player)
                  {
                      return true;
                  }
              }
          }
          else if (r <= c)
          {
              for (int scout5 = c+1; scout5 < 8; scout5++)
              {
                  if (blackwhite[scout5-c+r][scout5] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[scout5-c+r][scout5] == player)
                  {
                      return true;
                  }
              }
          }
      }
    }
    return false;
  }
  
  public boolean checkGameOverNorthWest(int r, int c, int player)
  {
    if (r-1 > -1 && c-1 > -1)
    {
      if (blackwhite[r-1][c-1] == (player+1)%2)
      {
         if (r < c)
         {
             for (int scout6 = r-1; scout6 > -1; scout6--)
             {
                 if (blackwhite[scout6][c-(r-scout6)] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[scout6][c-(r-scout6)] == player)
                 {
                     return true;
                 }
             }
         }
         else if (r >= c)
         {
             for (int scout6 = c-1; scout6 > -1; scout6--)
             {
                  if (blackwhite[r-(c-scout6)][scout6] == -1)
                  {
                      return false;
                  }
                  if (blackwhite[r-(c-scout6)][scout6] == player)
                  {
                      return true;
                  }
             }
          }
      }
    }
    return false;
  }
  
  public boolean checkGameOverSouthWest(int r, int c, int player)
  {
    if (r+1 < 8 && c-1 > -1)
    {
      if (blackwhite[r+1][c-1] == (player+1)%2)
      {
         if (r > (7-c))
         {
             for (int scout7 = r+1; scout7 < 8; scout7++)
             {
                 if (blackwhite[scout7][c-(scout7-r)] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[scout7][c-(scout7-r)] == player)
                 {
                     return true;
                 }
             }
         }
         else if (r <= (7-c))
         {
             for (int scout7 = c-1; scout7 > -1; scout7--)
             {
                 if (blackwhite[(c-scout7)+r][scout7] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[(c-scout7)+r][scout7] == player)
                 {
                     return true;
                 }
             }
         }
      }
    }
    return false;
  }
  
  public boolean checkGameOverNorthEast(int r, int c, int player)
  {
    if (r-1 > -1 && c+1 < 8)
    {
      if (blackwhite[r-1][c+1] == (player+1)%2)
      {
         if (r < (7-c))
         {
             for (int scout8 = r-1; scout8 > -1; scout8--)
             {
                 if (blackwhite[scout8][c+(r-scout8)] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[scout8][c+(r-scout8)] == player)
                 {
                     return true;
                 }
             }
         }
         else if (r >= (7-c))
         {
             for (int scout8 = c+1; scout8 < 8; scout8++)
             {
                 if (blackwhite[r-(scout8-c)][scout8] == -1)
                 {
                     return false;
                 }
                 if (blackwhite[r-(scout8-c)][scout8] == player)
                 {
                     return true;
                 }
             }
         }
      }
    } 
    return false;
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.GREEN);
    
    for (int rgrid = 0; rgrid < 8; rgrid++)
    {
      for (int cgrid = 0; cgrid < 8; cgrid++)
      {
        g.fillRect(rgrid*50,cgrid*50,50,50);
      }
    }
    
    g.setColor(Color.WHITE);
    for (int rgrid2 = 0; rgrid2 < 8; rgrid2++)
    {
      for (int cgrid2 = 0; cgrid2 < 8; cgrid2++)
      {
        g.drawRect(rgrid2*50,cgrid2*50,50,50);
      }
    }
    
    for (int r = 0; r < 8; r++)
    {
      for (int c = 0; c < 8; c++)
      {
        if (blackwhite[r][c] == 0)
        {
          g.setColor(Color.BLACK);
          g.fillOval(c*50,r*50,50,50);
        }
        else if (blackwhite[r][c] == 1)
        {
          g.setColor(Color.WHITE);
          g.fillOval(c*50,r*50,50,50);
        }
      }  
    } 
  }
  
  @Override
  public void actionPerformed(ActionEvent ae)
  {
        if (ae.getSource() instanceof Button)
        {
            Button temp = (Button) ae.getSource();
            for (int r = 0; r < 8; r++)
            {
                for (int c = 0; c < 8; c++)
                {
                    if (buttongrid[r][c] == temp)
                    {
                        if (checkCondNorth(r,c) == true)
                        {
                          blackwhite[r][c] = turn%2;
                          flipNorth(r,c);
                          temp.setVisible(false);
                        }
                        if (checkCondSouth(r,c) == true)
                        {
                          blackwhite[r][c] = turn%2;
                          flipSouth(r,c);
                          temp.setVisible(false);
                        }
                        if (checkCondEast(r,c) == true)
                        {
                          blackwhite[r][c] = turn%2;
                          flipEast(r,c);
                          temp.setVisible(false);
                        }
                        if (checkCondWest(r,c) == true)
                        {
                          blackwhite[r][c] = turn%2;
                          flipWest(r,c);
                          temp.setVisible(false);
                        }
                        if (checkCondSouthEast(r,c) == true)
                        {
                            blackwhite[r][c] = turn%2;
                            flipSouthEast(r,c);
                            temp.setVisible(false);
                        }
                        if (checkCondNorthWest(r,c) == true)
                        {
                            blackwhite[r][c] = turn%2;
                            flipNorthWest(r,c);
                            temp.setVisible(false);
                        }
                        if (checkCondSouthWest(r,c) == true)
                        {
                            blackwhite[r][c] = turn%2;
                            flipSouthWest(r,c);
                            temp.setVisible(false);
                        }
                        if (checkCondNorthEast(r,c) == true)
                        {
                            blackwhite[r][c] = turn%2;
                            flipNorthEast(r,c);
                            temp.setVisible(false);
                        }
                        if (blackwhite[r][c] == turn%2)
                        {
                        turn++;
                        main.refresh();
                        }
                    }
                }
            }
        }
    repaint();
    }
  
  public void flipTest(int r, int c)
  {
//    
//    for (int scout1 = r; scout1 < 8; scout1++)
//    {
//      
//      if (blackwhite[scout1][c] == -1)
//      {
//          break;
//      }
//      if (blackwhite[scout1][c] == turn%2)
//      {
//        for(int rerun1 = r; rerun1 < scout1; rerun1++)
//        {
//          blackwhite[rerun1][c] = turn%2;
//        }
//        
//      }
//    }
//    
//    for (int scout2 = r; scout2 > -1; scout2--)
//    {
//      if (blackwhite[scout2][c] == -1)
//      {
//          break;
//      }
//      if (blackwhite[scout2][c] == turn%2)
//      {
//        for(int rerun2 = r; rerun2 > scout2; rerun2--)
//        {
//          blackwhite[rerun2][c] = turn%2;
//        }
//        
//      }
//    }
//    
//    for (int scout3 = c; scout3 < 8; scout3++)
//    {
//      if (blackwhite[r][scout3] == -1)
//      {
//          break;
//      }
//      if (blackwhite[r][scout3] == turn%2)
//      {
//        for(int rerun3 = c; rerun3 < scout3; rerun3++)
//        {
//          blackwhite[r][rerun3] = turn%2;
//        }
//        
//      }
//    }
//    
//    for (int scout4 = c; scout4 > -1; scout4--)
//    {
//      if (blackwhite[r][scout4] == -1)
//      {
//          break;
//      }
//      if (blackwhite[r][scout4] == turn%2)
//      {
//        for(int rerun4 = c; rerun4 > scout4; rerun4--)
//        {
//          blackwhite[r][rerun4] = turn%2;
//        }
//        
//      }
//    }
//    
}
  
  public boolean checkCond1Test(int r, int c)
  {
    return false;
//    if (r+1 < 8)
//    {
//      if (blackwhite[r+1][c] == (turn+1)%2)
//      {
//        return true;
//      }
//    }
//    if (r-1 > -1)
//    {
//      if (blackwhite[r-1][c] == (turn+1)%2)
//      {
//        return true;
//      }
//    }
//    if (c+1 < 8)
//    {
//      if (blackwhite[r][c+1] == (turn+1)%2)
//      {
//        return true;
//      }
//    }
//    if (c-1 > -1)
//    {
//      if (blackwhite[r][c-1] == (turn+1)%2)
//      {
//        return true;
//      }
//    }
//    if (r+1 < 8 && c+1 < 8)
//    {
//      if (blackwhite[r+1][c+1] == (turn+1)%21)
//      {
//         return true;
//      }
//    }
//    if (r-1 > -1 && c-1 > -1)
//    {
//      if (blackwhite[r-1][c-1] == (turn+1)%2)
//      {
//         return true;
//      }
//    }
//    if (r+1 < 8 && c-1 > -1)
//    {
//      if (blackwhite[r+1][c-1] == (turn+1)%2)
//      {
//         return true;
//      }
//    }
//    if (r-1 > -1 && c+1 < 8)
//    {
//      if (blackwhite[r-1][c+1] == (turn+1)%2)
//      {
//         return true;
//      }
//    }
//    return false;
}
  
  public boolean checkCond2Test(int r, int c)
  {
    return false;
//      
//    for (int scout1 = r; scout1 < 8; scout1++)
//    {
//      if (blackwhite[scout1][c] == turn%2)
//      {
//          return true;
//      }
//    }
//    
//    for (int scout2 = r; scout2 > -1; scout2--)
//    {
//      if (blackwhite[scout2][c] == turn%2)
//      {
//        return true;
//      }
//    }
//    
//    for (int scout3 = c; scout3 < 8; scout3++)
//    {
//      if (blackwhite[r][scout3] == turn%2)
//      {
//        return true;
//      }
//    }
//    
//    for (int scout4 = c; scout4 > -1; scout4--)
//    {
//      if (blackwhite[r][scout4] == turn%2)
//      {
//        return true;
//      }
//    }
//    
//    return false;
}
}