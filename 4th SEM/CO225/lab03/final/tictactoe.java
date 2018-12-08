
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
 
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */


public class tictactoe extends JFrame  {

	
	private final int SIZE=3;
	private static final int WIDTH=1000;
	private static final int HEIGHT=1000;
        private int winner;
      

	public tictactoe(){
		super();

			setSize(WIDTH,HEIGHT);
			setLocationRelativeTo(null);
                        JFrame frame = new JFrame("Tic Tac Toe");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       // frame.getContentPane().setLayout(new GridLayout(SIZE,SIZE));
                        JPanel panel = new JPanel (new GridLayout(SIZE,SIZE));
                        
                        JButton button1 = new JButton();
                        button1.setPreferredSize(new Dimension(100,100));
                        panel.add(button1);
                        button1.addActionListener(new buttonListener(1, button1));
                       
                        
                        JButton button2 = new JButton();
                        button2.setPreferredSize(new Dimension(100,100));
                        panel.add(button2);
                        button2.addActionListener(new buttonListener(2, button2));
                        
                        JButton button3 = new JButton();
                        button3.setPreferredSize(new Dimension(100,100));
                        panel.add(button3);
                        button3.addActionListener(new buttonListener(3, button3));
                        
                        JButton button4 = new JButton();
                        button4.setPreferredSize(new Dimension(100,100));
                        panel.add(button4);
                        button4.addActionListener(new buttonListener(4, button4));
                        
                        JButton button5 = new JButton();
                        button5.setPreferredSize(new Dimension(100,100));
                        panel.add(button5);
                        button5.addActionListener(new buttonListener(5, button5));
                        
                        JButton button6 = new JButton();
                        button6.setPreferredSize(new Dimension(100,100));
                        panel.add(button6);
                        button6.addActionListener(new buttonListener(6, button6));
                        
                        JButton button7 = new JButton();
                        button7.setPreferredSize(new Dimension(100,100));
                        panel.add(button7);
                        button7.addActionListener(new buttonListener(7, button7));
                        
                        JButton button8 = new JButton();
                        button8.setPreferredSize(new Dimension(100,100));
                        panel.add(button8);
                        button8.addActionListener(new buttonListener(8, button8));
                        
                        JButton button9 = new JButton();
                        button9.setPreferredSize(new Dimension(100,100));
                        panel.add(button9);
                        button9.addActionListener(new buttonListener(9, button9));
                        
                        frame.setContentPane(panel);
                        frame.pack();
                        frame.setVisible(true);

	}
        
        
    public static void result(int winner){
    
        if(winner == 2){
           // System.out.println("Player 1 wins");
            
            JFrame frame = new JFrame("Result");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            JPanel panel1 = new JPanel();
            JLabel label1 = new JLabel("Player 2 wins");
            label1.setFont(new Font("Arial",2,40));
            panel1.add(label1);
            panel1.setBorder(new LineBorder(Color.BLACK));
            frame.add(panel1, new GridBagConstraints());
            frame.setSize(400,400);
            frame.setContentPane(panel1);
            frame.pack();
            frame.setVisible(true);
            
            
        }else if(winner == 1){
           // System.out.println("Player 2 wins");
            
            JFrame frame = new JFrame("Result");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            JPanel panel1 = new JPanel();
            JLabel label1 = new JLabel("Player 1 wins");
            label1.setFont(new Font("Arial",2,40));
            panel1.add(label1);
            panel1.setBorder(new LineBorder(Color.BLACK));
            frame.add(panel1, new GridBagConstraints());
            frame.setSize(400,400);
            frame.setContentPane(panel1);
            frame.pack();
            frame.setVisible(true);
        }else{
            JFrame frame = new JFrame("Result");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridBagLayout());
            JPanel panel1 = new JPanel();
            JLabel label1 = new JLabel("Game Draw");
            label1.setFont(new Font("Arial",2,40));
            panel1.add(label1);
            panel1.setBorder(new LineBorder(Color.BLACK));
            frame.add(panel1, new GridBagConstraints());
            frame.setSize(400,400);
            frame.setContentPane(panel1);
            frame.pack();
            frame.setVisible(true);
        
        }
    
    }

    
    public static void main(String[] args) 
    {
            tictactoe tictactoe = new tictactoe();
    }
    
    
   
}

  	