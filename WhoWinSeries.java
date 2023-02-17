import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
/**
 *
 * @author HP
 */
public class WhoWinSeries 
{
    WhoWinSeries(String message)
    {
         JFrame jf=new JFrame();
         jf.setSize(600,400);
         jf.setBackground(Color.DARK_GRAY);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jf.setLayout(null);
    
    
        JLabel jl=new JLabel(message);        // set the winner name on the frame at the last.
        jl.setBounds(30,150,350,40);
        jl.setFont(new Font("Arial", 1, 27));
        jl.setForeground(Color.darkGray);
        jf.add(jl);
      
        jf.setVisible(true);
    }

   
    
}