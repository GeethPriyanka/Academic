import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

//import javax.swing.Timer; //for timer

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tac extends JPanel 
  implements ActionListener{
    private JPanel panel;
    private JButton[][]buttons;
    private final int SIZE = 3;
    private GridLayout experimentLayout;
    public Tac()
    {
        
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);

        experimentLayout =  new GridLayout(SIZE,SIZE);

        panel = new JPanel();
        panel.setLayout(experimentLayout);


        buttons = new JButton[SIZE][SIZE];
        addButtons(panel);


        add(panel);
        setVisible(true);
    }
    public void addButtons(JPanel panel) {
   for (int k = 0; k < SIZE; k++) {
      for (int j = 0; j < SIZE; j++) {
         buttons[k][j] = new JButton(k + 1 + ", " + (j + 1));
         panel.add(buttons[k][j]);
      }
   }
}
 public static void main(String[] args) 
    {
        new Main();

         //Create and set up the window.
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new tac();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

}

