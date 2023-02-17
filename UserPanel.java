

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class UserPanel implements ActionListener
{
    JFrame jf;
    JLabel jl1,jl2,jl3;
    JButton jb;
    JTextField jt1,jt2;
    
    JComboBox cb;
    
    UserPanel()
    {
        
         try
        {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ee)
                
                {
                    System.out.println(ee);
                }
         
       jf=new JFrame("Zero And Cross Game Develop by Kunal Wadhai");
        jf.setSize(600,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        
        jl1=new JLabel("Enter Player one (X) : ");
        jl1.setBounds(50,50,130,30);
        jf.add(jl1);
        
        jt1=new JTextField();
        jt1.setBounds(180,50,200,30);
        jf.add(jt1);
        
        jl2=new JLabel("Enter Player two (0) :");
        jl2.setBounds(50,100, 160, 30);
        jf.add(jl2);
        
        jt2=new JTextField();
        jt2.setBounds(180,100,200,30);
        jf.add(jt2);
        
        jl3=new JLabel(" Select Series : ");
        jl3.setBounds(80,250,120,30);
        jf.add(jl3);
        
        
        String[] series={"3","5","7","9","11"};
        cb=new JComboBox(series);
        cb.setBounds(175,250,200,30);
        jf.add(cb);
        
        jb=new JButton(" Start Game ");
        jb.setBackground(Color.darkGray);
        jb.setBounds(220,350,120,50);
        jb.addActionListener(this);
        jf.add(jb);
        
        
        jf.setVisible(true);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==jb)
        {
            String player1=jt1.getText();      // concept of event handling.
            String player2=jt2.getText();
            
            String series=(String) cb.getSelectedItem();               // getSelectedItem();  this method returns an object that's why we has typecast into a string.
            
            
          GamePanel gp1=  new GamePanel(player1,player2,Integer.parseInt(series));
          
          gp1.openGamePanel();   // beacause we had set the designing part in that  calling method.
          jf.setVisible(false);         // this is for closing of user input panel.
        }
    }
}
    

