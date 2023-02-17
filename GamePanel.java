

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class GamePanel implements ActionListener  
{
    JFrame jf;
    JButton[] jb;
    String xo_value ="";
    String title_str="";
    int count=0;
    boolean win=false;
    Color color1;          // Color is a class which is belong to awt.Color package.
  
    String player1,player2;
    String player_who_wins;
    boolean player1_turn=true;
    int total_series;
    int series_count=1;
    
    String who_win_series_player_name;
    int player1_win_count=0  , player2_win_count=0;
    
    GamePanel(String player1,String player2,int total_series)
    {
        
       this.player1=player1;
       this.player2=player2;
       this.total_series=total_series;
    }

    GamePanel(String player1, String player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void openGamePanel()
    {
        try
        {
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ee)
                
                {
                   System.out.println(ee);
                }
       jf=new JFrame ();
       jf.setTitle(player1+" (X) turns");
       jf.setSize(500,500);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.setLayout(new GridLayout(3, 3));
       
       jb=new JButton[10];
       for(int i=1; i<10; i++)
       {
    	   jb[i]=new JButton();
           jb[i].addActionListener(this);
           jf.add(jb[i]); 
       }
       
     
       jf.setVisible(true);
    }

 

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      count+=1;
      if(player1_turn==true)   // if jb button is at the no. of even no then it will print 0 otherwise it will print X.               //    count %2==0  here we put first turn instead of this.
      {
          xo_value="X";
          title_str="0";
          color1=Color.magenta;  
          jf.setTitle(player2+"("+title_str+") turns");
          player1_turn=false;                                          //        if the value of player one is false then it executed next part.
      }
      else 
      {
        xo_value="0";
          title_str="X";
          color1=Color.green;
          jf.setTitle(player1+"("+title_str+") turns");
          player1_turn=true;                                            //        if the value of player one is two then it executed previous  part.
         
      }
      
      
      
      for(int i=1; i<10; i++)
      {
    	  if(e.getSource()==jb[i])
          {
              jb[i].setBackground(color1);
              jb[i].setFont(new Font("Arial",1,70));
              jb[i].setText(xo_value);
              jb[i].setEnabled(false); // this for fix showing of character on the button with the help of this method it would be stable .
            
          }
      }
     
      
         winningPosibilities(); // Method calling.
          whoWins();
      
    }
    void winningPosibilities()
    {
        if(jb[1].getText()==jb[2].getText()  && jb[2].getText()==jb[3].getText()  && jb[3].getText()!="") // for vertical possibilities of winning.
        {
            //System.out.println(str); // but it will not generate the message.
           // JOptionPane.showMessageDialog(jf, str+" Wins");
            win=true;
        }
        
        else  if(jb[4].getText()==jb[5].getText()  &&  jb[5].getText()==jb[6].getText()  &&  jb[6].getText()!="") 
        {
            //System.out.println(str); // but it will not generate the message.
          //  JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
         
        else if(jb[7].getText()==jb[8].getText()  &&  jb[8].getText()==jb[9].getText()  &&  jb[9].getText()!="") 
        {
            //System.out.println(str); // but it will not generate the message.
          //  JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
          
        else if(jb[1].getText()==jb[4].getText()  &&  jb[4].getText()==jb[7].getText()  &&  jb[7].getText()!="")    //  Horizontal winning posibilities.
        {
            //System.out.println(str); // but it will not generate the message.
           // JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
           
        else   if(jb[2].getText()==jb[5].getText()  &&  jb[5].getText()==jb[8].getText()  &&  jb[8].getText()!="") 
        {
            //System.out.println(str); // but it will not generate the message.
           // JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
            
           else  if(jb[3].getText()==jb[6].getText()  &&  jb[6].getText()==jb[9].getText()  &&  jb[9].getText()!="") 
        {
            //System.out.println(str); // but it will not generate the message.
          //  JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
             
           else   if(jb[1].getText()==jb[5].getText()  &&  jb[5].getText()==jb[9].getText()  &&  jb[9].getText()!="")   // Diagonal winning posibilities.
        {
            //System.out.println(str); // but it will not generate the message.
           // JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
              
           else   if(jb[3].getText()==jb[5].getText()  &&  jb[5].getText()==jb[7].getText()  &&  jb[7].getText()!="") 
        {
            //System.out.println(str); // but it will not generate the message.
           // JOptionPane.showMessageDialog(jf, str+" Wins");
             win=true;
        }
           else 
         {
               win=false;
         }
    }
    
    
    void whoWins()
    {
        
      
        
        if(win==true)
               {
                 //  String player;
                   
                   series_count=series_count+1;
                   
                   if(xo_value.equals("X"))                          // this if else stmt for giving the input name of  winning person.
                   {
                       player_who_wins=player1;              // if X wins then this value goes into the player.
                       player1_win_count=player1_win_count+1;
                   }
                   else
                   {
                       player_who_wins=player2;
                        player2_win_count=player2_win_count+1;
                   }
                   
                    String win_title=player_who_wins+"("+xo_value+")"+" Wins";   //  this if for setting the winning person name on the frame.
                    jf.setTitle(win_title);                                        //  this is setting actual winner name after winning .
                   JOptionPane.showMessageDialog(jf, win_title);
                   restartGame();
               }      
        
        else if(win==false && count>=10)
        {
            JOptionPane.showMessageDialog(jf,"Match Draw");
            restartGame();
        }
        
        else if(win==false  &&  count==9)
            
           {
                  JOptionPane.showMessageDialog(jf, " Match Draw");
                   restartGame();
           }
                       
                
    }
    
    void restartGame()
    {
        
        if(total_series >=series_count)
        {
                      int  i =  JOptionPane.showConfirmDialog(jf, "Do you want to restart the game");
                       System.out.println(" i : "+i);
      
      if(i == 0)             // this is for restart the game.
          {
    	  for(int ii=1; ii<10; ii++)
    	  {
    		  jb[ii].setText("");
    		  jb[i].setBackground(null); 
    	  }
         
          
         buttonEnablingMethod(true);
         count=0;
         
         if (player_who_wins.equals(player1))
         {
             player1_turn=true;
         }
         else 
         {
             player1_turn=false;
         }
             
        //    System.out.println("first_turn : "+first_turn);
         
         jf.setTitle(player_who_wins+"(" +xo_value+") turns");
         win=false;
         
      }
      
         else if(i ==1)    // this is for cancel the game.
                 {
                  System.exit(0);        // this exit shut down the working of "jvm".
                 }
         
           else             // this if for exit .
                {
    
                    buttonEnablingMethod(false);
          
                 }
        }
        else 
        {
          //   System.out.println("your series is complete");
            JOptionPane.showMessageDialog(jf, " Your series is completd.....!!! ");
            if(player1_win_count>player2_win_count)
            {
              //  JOptionPane.showMessageDialog(jf,player1+" Wins the series !");
              new WhoWinSeries(player1+" Wins the series.....!!!");
              jf.setVisible(false);
            }
            
            else  if(player2_win_count>player1_win_count)
            {
                //  JOptionPane.showMessageDialog(jf,player2+" Wins the series !");
                new WhoWinSeries(player2+" Wins the series.....!!!");
                 jf.setVisible(false);
            }
            else
            {
                //  JOptionPane.showMessageDialog(jf,"Match series draw ");
                new WhoWinSeries("Series Draw");
                 jf.setVisible(false);
            }
            
        }
    
      
    }
    void buttonEnablingMethod(boolean b)
    {
        for(int i=1; i<10; i++)
        {
        	 jb[i].setEnabled(b);
        }
    }
    
}
